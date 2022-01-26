package com.pamplemousse.pampleback.repository;

import java.util.List;
import java.sql.Date;

import com.pamplemousse.pampleback.model.Parcour;
import com.pamplemousse.pampleback.model.Qcm;
import com.pamplemousse.pampleback.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcourRepository extends JpaRepository<Parcour, Long> {
    List<Parcour> findAllByDate(Date date);
    
    List<Parcour> findAllByStagiaire(User stagiare);

    List<Parcour> findAllByQcm(Qcm qcm);
}
