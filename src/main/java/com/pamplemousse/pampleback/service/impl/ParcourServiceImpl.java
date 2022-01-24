package com.pamplemousse.pampleback.service.impl;

import java.util.Date;
import java.util.List;

import com.pamplemousse.pampleback.dto.ParcourFromClientDto;
import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.mapper.ParcourMapper;
import com.pamplemousse.pampleback.model.Parcour;
import com.pamplemousse.pampleback.repository.ParcourRepository;
import com.pamplemousse.pampleback.service.ParcourService;
import com.pamplemousse.pampleback.service.QcmService;
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
     * the constructor of the service.
     * @param parcourRepository
     * @param userService
     * @param qcmService
     * @param parcourMapper
     */
    @Autowired
    public ParcourServiceImpl(ParcourRepository parcourRepository, UserService userService, QcmService qcmService,
            ParcourMapper parcourMapper) {
        this.parcourRepository = parcourRepository;
        this.userService = userService;
        this.qcmService = qcmService;
        this.parcourMapper = parcourMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Parcour> getAllParcours() {
        return parcourRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Parcour> getAllParcoursByDate(Date date) {
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        return parcourRepository.findAllByDate(date1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Parcour> getAllParcoursByUser(Long id) {
        userService.getUserByid(id);
        return parcourRepository.findAllByStagiaireId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Parcour> getAllParcoursByQcm(Long id) {
        qcmService.getOneById(id);
        return parcourRepository.findAllByQcmId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Parcour getOneById(Long id) {
        Parcour parcour = parcourRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.PARCOUR_ID_NOT_FOUND_IN_DB));
        return parcour;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Parcour createParcour(ParcourFromClientDto parcourFromClientDto) {
        userService.getUserByid(parcourFromClientDto.getStagiaireId());
        qcmService.getOneById(parcourFromClientDto.getQcmId());
        Parcour parcourtoCreate = parcourMapper.parcourFromClientDtoToParcour(parcourFromClientDto);

        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        parcourtoCreate.setDate(date1);
        
        return parcourRepository.save(parcourtoCreate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Parcour updateParcour(Long id, ParcourFromClientDto parcourFromClientDto) {
        Parcour parcour = getOneById(id);
        parcourMapper.updateParcourFromDto(parcourFromClientDto, parcour);
        return parcourRepository.save(parcour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteParcour(Long id) {
        Parcour parcour = getOneById(id);
        parcourRepository.delete(parcour);
    }
}
