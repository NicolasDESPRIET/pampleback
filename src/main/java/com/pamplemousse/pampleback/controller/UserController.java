package com.pamplemousse.pampleback.controller;

import java.util.List;

import com.pamplemousse.pampleback.dto.UserFromClientDto;
import com.pamplemousse.pampleback.model.User;
import com.pamplemousse.pampleback.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * UserService userService.
     */
    private UserService userService;

    /**
     * constructor of the controller.
     * @param userService
     */
    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    /**
     * way to get all user in db.
     * getMapping.
     * @return List<User>
     */
    @GetMapping
    public @ResponseBody List<User> getAllUsers() {
        System.out.println("get all user");
        return userService.getAllUsers();
    }

    /**
     * way to get one user by his id.
     * getMapping.
     * @param id
     * @return user
     */
    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable final Long id) {
        return userService.getUserByid(id);
    }

    /**
     * way to get all user with a specific type.
     * getMapping.
     * @param id
     * @return List<User>
     */
    @GetMapping(path = "/type/{id}")
    public List<User> getAllUserByType(@PathVariable final Long id) {
        return userService.getAllUsersByType(id);
    }

    /**
     * way to get one user by his name.
     * getMapping.
     * @param name
     * @return user
     */
    @GetMapping(path = "/name/{name}")
    public User getUserByName(@PathVariable final String name) {
        return userService.getUserByName(name);
    }

    /**
     * way to create an user.
     * postMapping.
     * @param userFromClientDto
     * @return userCreated
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody User createUser(@RequestBody final UserFromClientDto userFromClientDto) {
        User user = userService.createUser(userFromClientDto);
        return user;
    }

    /**
     * way to update data of an user, by his id.
     * putMapping.
     * @param id
     * @param userFromClientDto
     * @return userUpdated
     */
    @PutMapping(path = "/{id}")
    public User updateUser(@PathVariable final Long id,
            @RequestBody final UserFromClientDto userFromClientDto) {
        return userService.updateUser(userFromClientDto, id);
    }

    /**
     * way to delete an user by his id.
     * deleteMapping.
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable final Long id) {
        userService.deleteUser(id);
    }
}
