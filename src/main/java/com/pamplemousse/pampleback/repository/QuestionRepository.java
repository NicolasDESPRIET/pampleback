package com.pamplemousse.pampleback.repository;

import java.util.Optional;

import com.pamplemousse.pampleback.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    /**
     * function used to find a question by his ennonce.
     * @param ennonce
     * @return Optional<Question>
     */
    Optional<Question> findByEnnonce(String ennonce);
}