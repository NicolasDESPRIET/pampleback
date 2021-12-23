package com.pamplemousse.pampleback.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.pamplemousse.pampleback.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    /**
     * function used to find a type by his name.
     * @param name
     * @return Optional<Type>
     */
    Optional<Type> findByName(String name);
}
