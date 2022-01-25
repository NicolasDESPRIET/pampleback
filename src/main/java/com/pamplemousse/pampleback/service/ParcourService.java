package com.pamplemousse.pampleback.service;

import java.util.Date;
import java.util.List;

import com.pamplemousse.pampleback.dto.ParcourFromClientDto;
import com.pamplemousse.pampleback.dto.ParcourToClientDto;

public interface ParcourService {
    /**
     * get all parcours in the db.
     * @return List<Parcour>
     */
    List<ParcourToClientDto> getAllParcours();

    /**
     * get all parcours done on a specifique date.
     * @param date
     * @return List<Parcour>
     */
    List<ParcourToClientDto> getAllParcoursByDate(Date date);

    /**
     * gat all parcours in the db done by an user.
     * @param id
     * @return List<Parcour>
     */
    List<ParcourToClientDto> getAllParcoursByUser(Long id);

    /**
     * get all parcours done on a specific qcm.
     * @param id
     * @return List<Parcour>
     */
    List<ParcourToClientDto> getAllParcoursByQcm(Long id);

    /**
     * get one parcours by his id.
     * @param id
     * @return Parcour
     */
    ParcourToClientDto getOneById(Long id);

    /**
     * create a parcours from entri data
     * @param parcourFromClientDto
     * @return Parcour the parcours created
     */
    ParcourToClientDto createParcour(ParcourFromClientDto parcourFromClientDto);

    /**
     * update a parcours from his id with new data.
     * @param id
     * @param parcourFromClientDto
     * @return Parcour the parcour updated
     */
    ParcourToClientDto updateParcour(Long id, ParcourFromClientDto parcourFromClientDto);

    /**
     * delete one parcours by his id.
     * @param id
     */
    void deleteParcour(Long id);
}
