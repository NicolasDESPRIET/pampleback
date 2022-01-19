package com.pamplemousse.pampleback.service;

import java.util.List;

import com.pamplemousse.pampleback.dto.QuestionNoResponseDto;
import com.pamplemousse.pampleback.model.Question;

public interface QuestionService {
    /**
     * get all Questions in the db.
     *
     * @return List<Question>.
     */
    List<Question> getAllQuestions();

    /**
     * get one Question by his id.
     *
     * @param id the id researched.
     * @return the researched Question.
     * @throws NotFoundException.
     */
    Question getQuestionByid(Long id);

    /**
     * get question without responses values.
     * @param id the id of the question
     * @return the dto with the list of ennonce question.
     */
    QuestionNoResponseDto getQuestionByIdNoResponseValue(Long id);

    /**
     * get the first Question by his ennonce.
     *
     * @param ennonce the question researched.
     * @return the researched question.
     * @throws NotFoundException.
     */
    Question getQuestionByEnnonce(String ennonce);

    /**
     * add an Question to the db.
     *
     * @param question the next Question.
     * @return the Question added.
     * @throws BadRequestException.
     */
    Question createQuestion(Question question);

    /**
     * update an Question with new value.
     *
     * @param question the update data for Question.
     * @param id       the id of Question to update.
     * @return the updated Question.
     * @throws BadRequestException.
     * @throws NotFoundException.
     */
    Question updateQuestion(Question question, Long id);

    /**
     * delete the Question by his id.
     *
     * @param id the id of the Question.
     * @throws NotFoundException.s
     */
    void deleteQuestion(Long id);
}
