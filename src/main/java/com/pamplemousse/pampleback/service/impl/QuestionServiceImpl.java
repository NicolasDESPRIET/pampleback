package com.pamplemousse.pampleback.service.impl;

 import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pamplemousse.pampleback.dto.QuestionNoResponseDto;
import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.exception.server.NotFoundException;
import com.pamplemousse.pampleback.mapper.QuestionMapper;
import com.pamplemousse.pampleback.model.Question;
import com.pamplemousse.pampleback.repository.QuestionRepository;
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
     * questionMapper.
     */
    private QuestionMapper questionMapper;

    /**
     * constructor of the service.
     * 
     * @param questionRepository
     * @param questionMapper
     */
    @Autowired
    public QuestionServiceImpl(final QuestionRepository questionRepository, final QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
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
    public Question getQuestionByEnonce(final String enonce) {
        Question question = questionRepository.findByEnonce(enonce)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.QUESTION_NOT_FOUND_IN_DB));
        return question;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Question createQuestion(final Question question) {
        if (!questionRepository.findByEnonce(question.getEnonce()).isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.QUESTION_ENNONCE_USED_IN_DB);
        }
        return questionRepository.save(question);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Question updateQuestion(final Question question, final Long id) {
        Optional<Question> questionEnnonce = questionRepository.findByEnonce(question.getEnonce());
        if (!questionEnnonce.isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.QUESTION_ENNONCE_USED_IN_DB);
        }
        if (question.getId() != id) {
            throw new BadRequestException(ExceptionMessageConstants.QUESTION_ID_ERROR);
        }
        question.setId(id);
        Question questionUpdated = questionRepository.save(question);
        return questionUpdated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteQuestion(final Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.QUESTION_ID_NOT_FOUND_IN_DB));
        questionRepository.delete(question);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionNoResponseDto getQuestionByIdNoResponseValue(final Long id) {
        Question question = getQuestionByid(id);
        QuestionNoResponseDto questionNoResponseDto = questionMapper.questionToQuestionNoResponseDto(question);
        List<String> list = new ArrayList<String>();
        question.getResponses().keySet().stream().forEach(x -> list.add(x));
        questionNoResponseDto.setResponsesList(list);
        return questionNoResponseDto;
    }

}
