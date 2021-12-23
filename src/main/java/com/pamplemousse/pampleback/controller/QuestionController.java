package com.pamplemousse.pampleback.controller;

import java.util.List;

import com.pamplemousse.pampleback.model.Question;
import com.pamplemousse.pampleback.model.Response;
import com.pamplemousse.pampleback.service.QuestionService;
import com.pamplemousse.pampleback.service.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questions")
public class QuestionController {
    /**
     * QuestionService questionService.
     */
    private QuestionService questionService;

    /**
     * ResponseService responseService.
     */
    private ResponseService responseService;

    /**
     * Controller of the questionController.
     * @param questionService
     * @param responseService
     */
    @Autowired
    public QuestionController(final QuestionService questionService, final ResponseService responseService) {
        this.questionService = questionService;
        this.responseService = responseService;
    }

    /**
     * way to get all questions with their response.
     * getMapping.
     * @return List<Question>
     */
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /**
     * way to get all responses without their question.
     * getMapping.
     * @return List<Response>
     */
    @GetMapping(path = "/responses")
    public List<Response> getAllResponses() {
        return responseService.getAllResponses();
    }

    /**
     * way to get one question by his id.
     * getMapping
     * @param id
     * @return Type
     */
    @GetMapping(path = "/{id}")
    public Question getQuestionById(@PathVariable final Long id) {
        return questionService.getQuestionByid(id);
    }

    /**
     * way to get one response by his id.
     * getMapping
     * @param id
     * @return Type
     */
    @GetMapping(path = "/responses/{id}")
    public Response getResponseById(@PathVariable final Long id) {
        return responseService.getResponseByid(id);
    }

    /**
     * way to get one question by his ennonce.
     * getMapping
     * @param ennonce
     * @return question
     */
    @GetMapping(path = "/ennonce/{ennonce}")
    public Question getQuestionByEnnonce(@PathVariable final String ennonce) {
        return questionService.getQuestionByEnnonce(ennonce);
    }

    /**
     * way to create an question and it response.
     * postMapping.
     * @param question
     * @return questionCreated
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Question createQuestion(@RequestBody final Question question) {
        Response response = responseService.createResponse(question.getResponse());
        return questionService.createQuestion(question, response.getId());
    }

    /**
     * way to update the whole question and it response.
     * @param question
     * @param qId
     * @param rId
     * @return the whole question and it response.
     */
    @PutMapping(path = "/{qId}/{rId}")
    public Question updateWholeQuestion(@RequestBody final Question question, @PathVariable final Long qId,
            @PathVariable final Long rId) {
        Response response = responseService.updateResponse(question.getResponse(), rId);
        question.setResponse(response);
        return questionService.updateQuestion(question, qId);
    }

    /**
     * way to update only the question.
     * @param question
     * @param qId
     * @return the question updated and it response.
     */
    @PutMapping(path = "/{qId}")
    public Question updateOnlyQuestion(@RequestBody final Question question, @PathVariable final Long qId) {
        return questionService.updateQuestion(question, qId);
    }

    /**
     * way to update only the response.
     * @param response
     * @param rId
     * @return the response updated.
     */
    @PutMapping(path = "/{rId}")
    public Response updateOnlyResponse(@RequestBody final Response response, @PathVariable final Long rId) {
        return responseService.updateResponse(response, rId);
    }

    /**
     * way to delete question and it response if cascade work.
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void deleteQuestion(@PathVariable final Long id) {
        questionService.deleteQuestion(id);
    }
}
