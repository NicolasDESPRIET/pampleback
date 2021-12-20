package com.pamplemousse.pampleback.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.pamplemousse.pampleback.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long>{
    Optional<Type> findByName(String name);
}
