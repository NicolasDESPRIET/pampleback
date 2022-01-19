package com.pamplemousse.pampleback.controller;

import java.util.List;

import com.pamplemousse.pampleback.dto.QuestionNoResponseDto;
import com.pamplemousse.pampleback.model.Question;
import com.pamplemousse.pampleback.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("questions")
public class QuestionController {
    /**
     * TypeService typeService.
     */
    private QuestionService questionService;

    /**
     * constructor of the controller.
     *
     * @param questionService
     */
    @Autowired
    public QuestionController(final QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * way to get all Questions.
     * getMapping
     *
     * @return List<Question>
     */
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /**
     * way to get question by his id.
     * getMapping
     * @param id
     * @return question
     */
    @GetMapping(path = "/{id}")
    public Question getQuestionById(@PathVariable final Long id) {
        return questionService.getQuestionByid(id);
    }

    /**
     * way to get Question by id with response values.
     * getMapping
     *
     * @param id
     * @return QuestionNoResponseDto
     */
    @GetMapping(path = "/{id}/noR")
    public QuestionNoResponseDto getQuestionNoResponseDtoById(@PathVariable final Long id) {
        return questionService.getQuestionByIdNoResponseValue(id);
    }

    /**
     * way to get question by his ennonce.
     * getMapping
     * @param ennonce
     * @return question
     */
    @GetMapping(path = "/ennonce/{ennonce}")
    public Question getQuestionByEnnonce(@PathVariable final String ennonce) {
        return questionService.getQuestionByEnnonce(ennonce);
    }

    /**
     * way to create question.
     * postMapping
     * @param question
     * @return question
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Question createQuestion(@RequestBody final Question question) {
        return questionService.createQuestion(question);
    }

    /**
     * way to update question by id.
     * putMapping
     * @param question
     * @param id
     * @return question
     */
    @PutMapping(path = "/{id}")
    public Question updateQuestion(@RequestBody final Question question, @PathVariable final Long id) {
        return questionService.updateQuestion(question, id);
    }

    /**
     * way to delete question by id.
     * deleteMapping
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void deleteQuestion(@PathVariable final Long id) {
        questionService.deleteQuestion(id);
    }
}
