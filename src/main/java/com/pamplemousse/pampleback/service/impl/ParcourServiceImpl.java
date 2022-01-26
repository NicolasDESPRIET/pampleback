package com.pamplemousse.pampleback.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pamplemousse.pampleback.dto.ParcourFromClientDto;
import com.pamplemousse.pampleback.dto.ParcourToClientDto;
import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.mapper.ParcourMapper;
import com.pamplemousse.pampleback.model.Parcour;
import com.pamplemousse.pampleback.model.Qcm;
import com.pamplemousse.pampleback.model.Question;
import com.pamplemousse.pampleback.model.User;
import com.pamplemousse.pampleback.repository.ParcourRepository;
import com.pamplemousse.pampleback.service.ParcourService;
import com.pamplemousse.pampleback.service.QcmService;
import com.pamplemousse.pampleback.service.QuestionService;
import com.pamplemousse.pampleback.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcourServiceImpl implements ParcourService {
    /**
     * ParcourRepository parcourRepository.
     */
    private ParcourRepository parcourRepository;

    /**
     * UserService userService.
     */
    private UserService userService;

    /**
     * QcmService qcmService.
     */
    private QcmService qcmService;

    /**
     * ParcourMapper parcourMapper.
     */
    private ParcourMapper parcourMapper;

    /**
     * QuestionService questionService.
     */
    private QuestionService questionService;

    /**
     * the constructor of the service.
     * @param parcourRepository
     * @param userService
     * @param qcmService
     * @param parcourMapper
     * @param questionService
     */
    @Autowired
    public ParcourServiceImpl(ParcourRepository parcourRepository, UserService userService, QcmService qcmService,
            ParcourMapper parcourMapper, QuestionService questionService) {
        this.parcourRepository = parcourRepository;
        this.userService = userService;
        this.qcmService = qcmService;
        this.parcourMapper = parcourMapper;
        this.questionService = questionService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ParcourToClientDto> getAllParcours() {
        return parcourMapper.listParcourToListParcourToClientDto(parcourRepository.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ParcourToClientDto> getAllParcoursByDate(Date date) {
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        return parcourMapper.listParcourToListParcourToClientDto(parcourRepository.findAllByDate(date1));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ParcourToClientDto> getAllParcoursByUser(Long id) {
        User user = userService.getUserByid(id);
        return parcourMapper.listParcourToListParcourToClientDto(parcourRepository.findAllByStagiaire(user));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ParcourToClientDto> getAllParcoursByQcm(Long id) {
        Qcm qcm = qcmService.getOneById(id);
        return parcourMapper.listParcourToListParcourToClientDto(parcourRepository.findAllByQcm(qcm));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParcourToClientDto getOneById(Long id) {
        Parcour parcour = parcourRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.PARCOUR_ID_NOT_FOUND_IN_DB));
        return parcourMapper.parcourToParcourToClientDto(parcour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParcourToClientDto createParcour(ParcourFromClientDto parcourFromClientDto) {
        userService.getUserByid(parcourFromClientDto.getStagiaireId());
        qcmService.getOneById(parcourFromClientDto.getQcmId());
        Parcour parcourtoCreate = parcourMapper.parcourFromClientDtoToParcour(parcourFromClientDto);

        User user = userService.getUserByid(parcourFromClientDto.getStagiaireId());
        Qcm qcm = qcmService.getOneById(parcourFromClientDto.getQcmId());

        List<Question> list = new ArrayList<Question>();
        parcourFromClientDto.getNbBlank().stream().forEach(i -> {
            Question q = questionService.getQuestionByid(i);
            list.add(q);
        });
        parcourtoCreate.setNbBlank(list);

        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        parcourtoCreate.setDate(date1);
        parcourtoCreate.setQcm(qcm);
        parcourtoCreate.setStagiaire(user);
        parcourtoCreate = parcourRepository.save(parcourtoCreate);
        
        return parcourMapper.parcourToParcourToClientDto(parcourtoCreate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParcourToClientDto updateParcour(Long id, ParcourFromClientDto parcourFromClientDto) {
        Parcour parcourUpdate = parcourRepository.findById(id)
            .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.PARCOUR_ID_NOT_FOUND_IN_DB));
        parcourMapper.updateParcourFromDto(parcourFromClientDto, parcourUpdate);

        if (parcourFromClientDto.getQcmId() != parcourUpdate.getQcm().getId()) {
            Qcm qcm = qcmService.getOneById(parcourFromClientDto.getQcmId());
            parcourUpdate.setQcm(qcm);
        }

        if(parcourFromClientDto.getStagiaireId() != parcourUpdate.getStagiaire().getId()) {
            User user = userService.getUserByid(parcourFromClientDto.getStagiaireId());
            parcourUpdate.setStagiaire(user);
        }

        List<Question> list = new ArrayList<Question>();
        parcourFromClientDto.getNbBlank().stream().forEach(i -> {
            Question q = questionService.getQuestionByid(i);
            list.add(q);
        });
        parcourUpdate.setNbBlank(list);
        parcourUpdate = parcourRepository.save(parcourUpdate);

        return parcourMapper.parcourToParcourToClientDto(parcourUpdate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteParcour(Long id) {
        Parcour parcour = parcourRepository.findById(id)
            .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.PARCOUR_ID_NOT_FOUND_IN_DB));
        parcourRepository.delete(parcour);
    }
}
