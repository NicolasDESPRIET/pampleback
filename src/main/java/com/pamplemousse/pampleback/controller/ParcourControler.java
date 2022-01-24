package com.pamplemousse.pampleback.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pamplemousse.pampleback.dto.DateDto;
import com.pamplemousse.pampleback.dto.ParcourFromClientDto;
import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.model.Parcour;
import com.pamplemousse.pampleback.service.ParcourService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parcour")
public class ParcourControler {
    /**
     * ParcourService parcourService.
     */
    private ParcourService parcourService;

    /**
     * constructor of the controler.
     * @param parcourService
     */
    @Autowired
    public ParcourControler(ParcourService parcourService) {
        this.parcourService = parcourService;
    }
    
    /**
     * way to get all parcours.
     * @return List<Parcour>
     */
    @GetMapping
    public List<Parcour> getAllParcours(){
        return parcourService.getAllParcours();
    }

    /**
     * way to get all parcours on a date (yyyy-MM-dd)
     * @param date (yyyy-MM-dd)
     * @return List<Parcour>
     */
    @GetMapping(path = "/date")
    public List<Parcour> getAllParcourByDate(@RequestBody final DateDto date) {
        Date date1;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date.getDate());
        } catch (ParseException e) {
            throw new BadRequestException(ExceptionMessageConstants.PARCOUR_DATE_BAD_FORMAT);
        }  
        return parcourService.getAllParcoursByDate(date1);
    }

    /**
     * way du get all parcours done on a qcm.
     * @param id the id of the qcm.
     * @return List<Parcour>
     */
    @GetMapping(path = "/qcm/{id}")
    public List<Parcour> getAllParcourByQcm(@PathVariable final Long id) {
        return parcourService.getAllParcoursByQcm(id);
    }

    /**
     * way to get all parcours done by an user
     * @param id the id of the user.
     * @return List<Parcour>
     */
    @GetMapping(path = "/user/{id}")
    public List<Parcour> getAllParcourByUser(@PathVariable final Long id) {
        return parcourService.getAllParcoursByUser(id);
    }

    /**
     * way to get one parcours by his id.
     * @param id
     * @return Parcour
     */
    @GetMapping(path = "/{id}")
    public Parcour getOneById(@PathVariable final Long id) {
        return parcourService.getOneById(id);
    }

    /**
     * way to create parcour
     * @param parcourFromClientDto date of the parcour
     * @return Parcour
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parcour createParcour(@RequestBody final ParcourFromClientDto parcourFromClientDto) {
        System.out.println(parcourFromClientDto);
        return parcourService.createParcour(parcourFromClientDto);
    }

    /**
     * way to edit a parcour fom his id.
     * @param id
     * @param parcourFromClientDto
     * @return Parcour
     */
    @PutMapping(path = "/{id}")
    public Parcour updateParcour(@PathVariable final Long id, @RequestBody final ParcourFromClientDto parcourFromClientDto) {
        return parcourService.updateParcour(id, parcourFromClientDto);
    }

    /**
     * way to delete a parcour from his id.
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void deleteParcour(@PathVariable final Long id) {
        parcourService.deleteParcour(id);
    }
}
