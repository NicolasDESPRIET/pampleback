package com.pamplemousse.pampleback.service.impl;

import java.util.List;
import java.util.Optional;

import com.pamplemousse.pampleback.dto.UserFromClientDto;
import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.exception.server.NotFoundException;
import com.pamplemousse.pampleback.mapper.UserMapper;
import com.pamplemousse.pampleback.model.Type;
import com.pamplemousse.pampleback.model.User;
import com.pamplemousse.pampleback.repository.TypeRepository;
import com.pamplemousse.pampleback.repository.UserRepository;
import com.pamplemousse.pampleback.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private TypeRepository typeRepository;

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TypeRepository typeRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
        this.userMapper = userMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsersByType(Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.TYPE_NOT_FOUND_IN_DB));
        System.out.println(type);
        List<User> list = userRepository.findByType(type);
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserByid(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.USER_ID_NOT_FOUND_IN_DB));

        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserByName(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.USER_NOT_FOUND_IN_DB));

        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User createUser(UserFromClientDto userFromClientDto) {
        System.out.println(userFromClientDto);
        Optional<User> userNameTest = userRepository.findByName(userFromClientDto.getName());
        if (!userNameTest.isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.USER_NAME_USED_IN_DB);
        }

        Type type = typeRepository.findById(userFromClientDto.getTypeId())
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.USER_TYPE_NOT_FOUND_IN_DB));
        System.out.println(type);

        User userCreated = userMapper.UserDtoToUser(userFromClientDto);
        userCreated.setType(type);
        System.out.println(userCreated);

        userCreated = userRepository.save(userCreated);

        return userCreated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateUser(UserFromClientDto userFromClientDto, Long id) {
        Optional<User> userNameTest = userRepository.findByName(userFromClientDto.getName());
        if (!userNameTest.isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.USER_NAME_USED_IN_DB);
        }

        Type type = typeRepository.findById(userFromClientDto.getTypeId())
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.USER_TYPE_NOT_FOUND_IN_DB));

        userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.USER_ID_NOT_FOUND_IN_DB));

        User userUpdate = userMapper.UserDtoToUser(userFromClientDto);
        userUpdate.setType(type);
        userUpdate.setId(id);
        userUpdate = userRepository.save(userUpdate);

        return userUpdate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.USER_ID_NOT_FOUND_IN_DB));
        userRepository.delete(user);
    }

    /**
     * Logger Instance if need
     * 
     * import org.apache.logging.log4j.LogManager; import
     * org.apache.logging.log4j.Logger;
     * 
     * private static Logger log = LogManager.getLogger(Object.class);
     */

}
