package com.pamplemousse.pampleback.controller;

import java.util.List;

import com.pamplemousse.pampleback.dto.QcmFromClientDto;
import com.pamplemousse.pampleback.dto.QcmToClientNoRDto;
import com.pamplemousse.pampleback.model.Qcm;
import com.pamplemousse.pampleback.model.Question;
import com.pamplemousse.pampleback.service.QcmService;
import com.pamplemousse.pampleback.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("qcm")
public class QcmController {
    
    /**
     * QcmService qcmService.
     */
    private QcmService qcmService;

    /**
     * QuestionService questionService.
     */
    private QuestionService questionService;

    /**
     * Constructor of the controller.
     * @param qcmService
     * @param questionService
     */
    @Autowired
    public QcmController(QcmService qcmService, QuestionService questionService) {
        this.qcmService = qcmService;
        this.questionService = questionService;
    }

    @GetMapping
    public List<Qcm> getAllQcm(){
        return qcmService.getAllQcm();
    }

    @GetMapping(path = "/nor")
    public List<QcmToClientNoRDto> getAllQcmNoR(){
        return qcmService.getAllQcmNoR();
    }

    @GetMapping(path = "/{id}")
    public Qcm getOneById(@PathVariable final Long id) {
        return qcmService.getOneById(id);
    }

    @GetMapping(path = "/nor/{id}")
    public QcmToClientNoRDto getOneByIdNoR(@PathVariable final Long id) {
        return qcmService.getOneByIdnoR(id);
    }

    @GetMapping(path = "/name/{name}")
    public Qcm getOneByName(@PathVariable final String name) {
        return qcmService.getOneByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Qcm createQcm(@RequestBody final QcmFromClientDto qcmFromClientDto) {
        return qcmService.createQcm(qcmFromClientDto);
    }

    @PutMapping(path = "/{id}")
    public Qcm updateQcm(@PathVariable final Long id, @RequestBody final QcmFromClientDto qcmFromClientDto) {
        return qcmService.updateQcm(qcmFromClientDto, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteQcm(@PathVariable final Long id) {
        qcmService.deleteQcm(id);
    }

    @PutMapping(path = "{qcmId}/add/{id}")
    public Qcm addQuestionToQcmById(@PathVariable final Long qcmId, @PathVariable final Long id) {
        Question question = questionService.getQuestionByid(id);
        return qcmService.addQuestion(id, question);
    }

    @PutMapping(path = "{qcmId}/remove/{id}")
    public Qcm removeQuestionToQcmById(@PathVariable final Long qcmId, @PathVariable final Long id) {
        Question question = questionService.getQuestionByid(id);
        return qcmService.removeQuestion(id, question);
    }
}
