package com.pamplemousse.pampleback.repository;

import java.util.Optional;

import com.pamplemousse.pampleback.model.Qcm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QcmRepository extends JpaRepository<Qcm, Long> {
    Optional<Qcm> findByName(String name);
}
