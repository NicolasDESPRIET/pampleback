package com.pamplemousse.pampleback.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pamplemousse.pampleback.dto.ParcoursFromClientDto;
import com.pamplemousse.pampleback.dto.ParcoursToClientDto;
import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.mapper.ParcoursMapper;
import com.pamplemousse.pampleback.model.Parcours;
import com.pamplemousse.pampleback.model.Qcm;
import com.pamplemousse.pampleback.model.Question;
import com.pamplemousse.pampleback.model.User;
import com.pamplemousse.pampleback.repository.ParcoursRepository;
import com.pamplemousse.pampleback.service.ParcoursService;
import com.pamplemousse.pampleback.service.QcmService;
import com.pamplemousse.pampleback.service.QuestionService;
import com.pamplemousse.pampleback.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcoursServiceImpl implements ParcoursService {
    /**
     * ParcourRepository parcourRepository.
     */
    private ParcoursRepository parcourRepository;

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
    private ParcoursMapper parcourMapper;

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
    public ParcoursServiceImpl(ParcoursRepository parcourRepository, UserService userService, QcmService qcmService,
            ParcoursMapper parcourMapper, QuestionService questionService) {
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
    public List<ParcoursToClientDto> getAllParcours() {
        return parcourMapper.listParcoursToListParcoursToClientDto(parcourRepository.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ParcoursToClientDto> getAllParcoursByDate(Date date) {
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        return parcourMapper.listParcoursToListParcoursToClientDto(parcourRepository.findAllByDate(date1));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ParcoursToClientDto> getAllParcoursByUser(Long id) {
        User user = userService.getUserByid(id);
        return parcourMapper.listParcoursToListParcoursToClientDto(parcourRepository.findAllByStagiaire(user));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ParcoursToClientDto> getAllParcoursByQcm(Long id) {
        Qcm qcm = qcmService.getOneById(id);
        return parcourMapper.listParcoursToListParcoursToClientDto(parcourRepository.findAllByQcm(qcm));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParcoursToClientDto getOneById(Long id) {
        Parcours parcour = parcourRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.PARCOUR_ID_NOT_FOUND_IN_DB));
        return parcourMapper.parcoursToParcoursToClientDto(parcour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParcoursToClientDto createParcour(ParcoursFromClientDto parcourFromClientDto) {
        userService.getUserByid(parcourFromClientDto.getStagiaireId());
        qcmService.getOneById(parcourFromClientDto.getQcmId());
        Parcours parcourtoCreate = parcourMapper.parcourFromClientDtoToParcour(parcourFromClientDto);

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
        
        return parcourMapper.parcoursToParcoursToClientDto(parcourtoCreate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParcoursToClientDto updateParcour(Long id, ParcoursFromClientDto parcourFromClientDto) {
        Parcours parcourUpdate = parcourRepository.findById(id)
            .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.PARCOUR_ID_NOT_FOUND_IN_DB));
        parcourMapper.updateParcoursFromDto(parcourFromClientDto, parcourUpdate);

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

        return parcourMapper.parcoursToParcoursToClientDto(parcourUpdate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteParcour(Long id) {
        Parcours parcour = parcourRepository.findById(id)
            .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.PARCOUR_ID_NOT_FOUND_IN_DB));
        parcourRepository.delete(parcour);
    }
}
