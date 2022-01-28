package com.pamplemousse.pampleback.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pamplemousse.pampleback.dto.ParcoursFromClientDto;
import com.pamplemousse.pampleback.dto.ParcoursToClientDto;
import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.service.ParcoursService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parcours")
public class ParcoursControler {
    /**
     * ParcoursService parcoursService.
     */
    private ParcoursService parcoursService;

    /**
     * constructor of the controler.
     * @param parcoursService
     */
    @Autowired
    public ParcoursControler(ParcoursService parcoursService) {
        this.parcoursService = parcoursService;
    }
    
    /**
     * way to get all parcours.
     * @return List<ParcourToClientDto>
     */
    @GetMapping
    public List<ParcoursToClientDto> getAllParcours(){
        return parcoursService.getAllParcours();
    }

    /**
     * way to get all parcours on a date (yyyy-MM-dd)
     * @param date (yyyy-MM-dd)
     * @return List<ParcourToClientDto>
     */
    @GetMapping(path = "/date")
    public List<ParcoursToClientDto> getAllParcoursByDate(@RequestParam final String date) {
        Date date1;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new BadRequestException(ExceptionMessageConstants.PARCOUR_DATE_BAD_FORMAT);
        }  
        return parcoursService.getAllParcoursByDate(date1);
    }

    /**
     * way du get all parcours done on a qcm.
     * @param id the id of the qcm.
     * @return List<ParcourToClientDto>
     */
    @GetMapping(path = "/qcm/{id}")
    public List<ParcoursToClientDto> getAllParcoursByQcm(@PathVariable final Long id) {
        return parcoursService.getAllParcoursByQcm(id);
    }

    /**
     * way to get all parcours done by an user
     * @param id the id of the user.
     * @return List<ParcourToClientDto>
     */
    @GetMapping(path = "/user/{id}")
    public List<ParcoursToClientDto> getAllParcoursByUser(@PathVariable final Long id) {
        return parcoursService.getAllParcoursByUser(id);
    }

    /**
     * way to get one parcours by his id.
     * @param id
     * @return ParcourToClientDto
     */
    @GetMapping(path = "/{id}")
    public ParcoursToClientDto getOneById(@PathVariable final Long id) {
        return parcoursService.getOneById(id);
    }

    /**
     * way to create parcour
     * @param parcourFromClientDto date of the parcour
     * @return ParcourToClientDto
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParcoursToClientDto createParcours(@RequestBody final ParcoursFromClientDto parcourFromClientDto) {
        System.out.println(parcourFromClientDto);
        return parcoursService.createParcour(parcourFromClientDto);
    }

    /**
     * way to edit a parcour fom his id.
     * @param id
     * @param parcourFromClientDto
     * @return ParcourToClientDto
     */
    @PutMapping(path = "/{id}")
    public ParcoursToClientDto updateParcours(@PathVariable final Long id, @RequestBody final ParcoursFromClientDto parcourFromClientDto) {
        return parcoursService.updateParcour(id, parcourFromClientDto);
    }

    /**
     * way to delete a parcour from his id.
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void deleteParcours(@PathVariable final Long id) {
        parcoursService.deleteParcour(id);
    }
}
