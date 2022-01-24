package com.pamplemousse.pampleback.repository;

import java.util.List;
import java.sql.Date;

import com.pamplemousse.pampleback.model.Parcour;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcourRepository extends JpaRepository<Parcour, Long> {
    List<Parcour> findAllByDate(Date date);
    
    List<Parcour> findAllByStagiaireId(Long stagiareId);

    List<Parcour> findAllByQcmId(Long qcmId);
}
