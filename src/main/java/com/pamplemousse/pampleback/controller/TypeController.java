package com.pamplemousse.pampleback.controller;

import java.util.List;

import com.pamplemousse.pampleback.dto.TypeDto;
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
    public List<TypeDto> getAllTypes() {
        System.out.println("get alltypes");
        return typeService.getAllTypes();
    }

    @GetMapping(path = "/{id}")
    public TypeDto getUserById(@PathVariable final Long id) {
        return typeService.getTypeByid(id);
    }

    @GetMapping(path = "/name/{name}")
    public TypeDto getUserByName(@PathVariable final String name) {
        return typeService.getTypeByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TypeDto createUser(@RequestBody final TypeDto typeDto) {
        return typeService.addType(typeDto);
    }

    @PutMapping(path = "/{id}")
    public TypeDto updateUser(@PathVariable final Long id,
            @RequestBody final TypeDto typeDto) {
        return typeService.updateType(typeDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable final Long id) {
        typeService.deleteType(id);
    }
}
