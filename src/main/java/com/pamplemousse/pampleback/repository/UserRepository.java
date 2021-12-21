package com.pamplemousse.pampleback.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.pamplemousse.pampleback.model.Type;
import com.pamplemousse.pampleback.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByName(String name);

    List<User> findByType(Type type);
}
