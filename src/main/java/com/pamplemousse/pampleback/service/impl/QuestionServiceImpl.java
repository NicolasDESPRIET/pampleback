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

    /**
     * QuestionRepository.
     */
    private QuestionRepository questionRepository;

    /**
     * ResponseRepository.
     */
    private ResponseRepository responseRepository;

    /**
     * Constructor of the service.
     * @param questionRepository
     * @param responseRepository
     */
    @Autowired
    public QuestionServiceImpl(final QuestionRepository questionRepository, final ResponseRepository responseRepository) {
        this.questionRepository = questionRepository;
        this.responseRepository = responseRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Question> getAllQuestions() {
        List<Question> list = questionRepository.findAll();
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Question getQuestionByEnnonce(final String ennonce) {
        Question question = questionRepository.findByEnnonce(ennonce)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.QUESTION_NOT_FOUND_IN_DB));
        return question;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Question getQuestionByid(final Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.QUESTION_ID_NOT_FOUND_IN_DB));
        return question;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Question createQuestion(final Question question, final Long responseId) {
        Optional<Question> existingQuestion = questionRepository.findByEnnonce(question.getEnnonce());
        if (!existingQuestion.isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.QUESTION_ENNONCE_USED_IN_DB);
        }
        Response response = responseRepository.findById(responseId)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.RESPONSE_NOT_FOUND_IN_DB));
        question.setResponse(response);
        return questionRepository.save(question);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Question updateQuestion(final Question question, final Long id) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteQuestion(final Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.QUESTION_ID_NOT_FOUND_IN_DB));
        questionRepository.delete(question);
    }

}
