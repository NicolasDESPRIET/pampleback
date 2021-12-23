package com.pamplemousse.pampleback.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.pamplemousse.pampleback.model.Type;
import com.pamplemousse.pampleback.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * function used to find a user by his name.
     * @param name
     * @return Optional<User>
     */
    Optional<User> findByName(String name);

    /**
     * function used to find all user by thier type.
     * @param type
     * @return List<User>
     */
    List<User> findByType(Type type);
}
