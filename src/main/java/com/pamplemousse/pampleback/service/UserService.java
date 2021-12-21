package com.pamplemousse.pampleback.service;

import java.util.List;

import com.pamplemousse.pampleback.dto.UserFromClientDto;
import com.pamplemousse.pampleback.model.User;


public interface UserService {
    
    /**
     * get all users in the db.
     * @return List<User>.
     */
    List<User> getAllUsers();

    /**
     * get all users with the type wanted in the db.
     * @param id the wanted type id.
     * @return List<User>.
     */
    List<User> getAllUsersByType(Long id);
	
    /**
     * get one user by his id.
     * @param id the id researched.
     * @return the researched user.
     * @throws NotFoundException.
     */
	User getUserByid(Long id);

    /**
     * get the first user by his name.
     * @param name the name researched.
     * @return the researched user.
     * @throws NotFoundException.
     */
    User getUserByName(String name);
	
    /**
     * add an user to the db.
     * @param userFromClientDto the next user.
     * @return the user added.
     * @throws BadRequestException.
     */
	User createUser(UserFromClientDto userFromClientDto);
	
    /**
     * update an user with new value.
     * @param userFromClientDto the update data for user.
     * @param id the id user to update.
     * @return the updated user.
     * @throws BadRequestException.
     * @throws NotFoundException.
     */
	User updateUser(UserFromClientDto userFromClientDto, Long id);
	
    /**
     * delete the user by his id.
     * @param id the id of the user.
     * @throws NotFoundException.s
     */
	void deleteUser(Long id);
}
