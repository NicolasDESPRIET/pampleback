package com.pamplemousse.pampleback.controller;

import java.util.List;

import com.pamplemousse.pampleback.model.Type;
import com.pamplemousse.pampleback.service.TypeService;

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
@RequestMapping("/types")
public class TypeController {

    /**
     * TypeService typeService.
     */
    private TypeService typeService;

    /**
     * constructor of the controller.
     * @param typeService
     */
    @Autowired
    public TypeController(final TypeService typeService) {
        this.typeService = typeService;
    }

    /**
     * way to get all types.
     * getMapping.
     * @return List<Type>
     */
    @GetMapping
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }

    /**
     * way to get one type by his id.
     * getMapping
     * @param id
     * @return Type
     */
    @GetMapping(path = "/{id}")
    public Type getTypeById(@PathVariable final Long id) {
        return typeService.getTypeByid(id);
    }

    /**
     * way to get one type by his name.
     * getMapping
     * @param name
     * @return Type
     */
    @GetMapping(path = "/name/{name}")
    public Type getTypeByName(@PathVariable final String name) {
        return typeService.getTypeByName(name);
    }

    /**
     * way to create type.
     * postMapping
     * @param type
     * @return type created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Type createType(@RequestBody final Type type) {
        return typeService.createType(type);
    }

    /**
     * way to update type.
     * putMapping
     * @param id
     * @param type
     * @return type updated
     */
    @PutMapping(path = "/{id}")
    public Type updateType(@PathVariable final Long id,
            @RequestBody final Type type) {
        return typeService.updateType(type, id);
    }

    /**
     * way to delete type.
     * deleteMapping
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void deleteType(@PathVariable final Long id) {
        typeService.deleteType(id);
    }
}
