package com.pamplemousse.pampleback.service;

import java.util.Date;
import java.util.List;

import com.pamplemousse.pampleback.dto.ParcoursFromClientDto;
import com.pamplemousse.pampleback.dto.ParcoursToClientDto;

public interface ParcoursService {
    /**
     * get all parcours in the db.
     * @return List<Parcour>
     */
    List<ParcoursToClientDto> getAllParcours();

    /**
     * get all parcours done on a specifique date.
     * @param date
     * @return List<Parcour>
     */
    List<ParcoursToClientDto> getAllParcoursByDate(Date date);

    /**
     * gat all parcours in the db done by an user.
     * @param id
     * @return List<Parcour>
     */
    List<ParcoursToClientDto> getAllParcoursByUser(Long id);

    /**
     * get all parcours done on a specific qcm.
     * @param id
     * @return List<Parcour>
     */
    List<ParcoursToClientDto> getAllParcoursByQcm(Long id);

    /**
     * get one parcours by his id.
     * @param id
     * @return Parcour
     */
    ParcoursToClientDto getOneById(Long id);

    /**
     * create a parcours from entri data
     * @param parcourFromClientDto
     * @return Parcour the parcours created
     */
    ParcoursToClientDto createParcour(ParcoursFromClientDto parcourFromClientDto);

    /**
     * update a parcours from his id with new data.
     * @param id
     * @param parcourFromClientDto
     * @return Parcour the parcour updated
     */
    ParcoursToClientDto updateParcour(Long id, ParcoursFromClientDto parcourFromClientDto);

    /**
     * delete one parcours by his id.
     * @param id
     */
    void deleteParcour(Long id);
}
