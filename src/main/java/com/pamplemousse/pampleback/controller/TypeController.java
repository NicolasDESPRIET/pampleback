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
@RequestMapping("types")
public class TypeController {
    
    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<Type> getAllTypes() {
        System.out.println("get alltypes");
        return typeService.getAllTypes();
    }

    @GetMapping(path = "/{id}")
    public Type getUserById(@PathVariable final Long id) {
        return typeService.getTypeByid(id);
    }

    @GetMapping(path = "/name/{name}")
    public Type getUserByName(@PathVariable final String name) {
        return typeService.getTypeByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Type createUser(@RequestBody final Type type) {
        return typeService.addType(type);
    }

    @PutMapping(path = "/{id}")
    public Type updateUser(@PathVariable final Long id,
            @RequestBody final Type type) {
        return typeService.updateType(type);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable final Long id) {
        typeService.deleteType(id);
    }
}
