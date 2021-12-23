package com.pamplemousse.pampleback.service.impl;

import java.util.List;
import java.util.Optional;

import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.exception.server.NotFoundException;
import com.pamplemousse.pampleback.model.Question;
import com.pamplemousse.pampleback.model.Response;
import com.pamplemousse.pampleback.repository.QuestionRepository;
import com.pamplemousse.pampleback.repository.ResponseRepository;
import com.pamplemousse.pampleback.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    private ResponseRepository responseRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, ResponseRepository responseRepository) {
        this.questionRepository = questionRepository;
        this.responseRepository = responseRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> list = questionRepository.findAll();
        return list;
    }

    @Override
    public Question getQuestionByEnnonce(String ennonce) {
        Question question = questionRepository.findByEnnonce(ennonce)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.QUESTION_NOT_FOUND_IN_DB));
        return question;
    }

    @Override
    public Question getQuestionByid(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.QUESTION_ID_NOT_FOUND_IN_DB));
        return question;
    }

    @Override
    public Question createQuestion(Question question, Long response_id) {
        Optional<Question> existingQuestion = questionRepository.findByEnnonce(question.getEnnonce());
        if (!existingQuestion.isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.QUESTION_ENNONCE_USED_IN_DB);
        }
        Response response = responseRepository.findById(response_id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.RESPONSE_NOT_FOUND_IN_DB));
        question.setResponse(response);
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question, Long id) {
        Optional<Question> questionNameTest = questionRepository.findByEnnonce(question.getEnnonce());
        if (!questionNameTest.isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.QUESTION_ENNONCE_USED_IN_DB);
        }

        responseRepository.findById(question.getResponse().getId())
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.RESPONSE_NOT_FOUND_IN_DB));

        questionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.QUESTION_ID_NOT_FOUND_IN_DB));
        question.setId(id);
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.QUESTION_ID_NOT_FOUND_IN_DB));
        questionRepository.delete(question);
    }

}
