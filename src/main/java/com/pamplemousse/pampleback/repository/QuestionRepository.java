package com.pamplemousse.pampleback.repository;

import java.util.Optional;

import com.pamplemousse.pampleback.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByEnnonce(String ennonce);
}
