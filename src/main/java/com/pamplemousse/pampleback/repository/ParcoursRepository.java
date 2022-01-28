package com.pamplemousse.pampleback.repository;

import java.util.List;
import java.sql.Date;

import com.pamplemousse.pampleback.model.Parcours;
import com.pamplemousse.pampleback.model.Qcm;
import com.pamplemousse.pampleback.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcoursRepository extends JpaRepository<Parcours, Long> {
    List<Parcours> findAllByDate(Date date);
    
    List<Parcours> findAllByStagiaire(User stagiare);

    List<Parcours> findAllByQcm(Qcm qcm);
}
