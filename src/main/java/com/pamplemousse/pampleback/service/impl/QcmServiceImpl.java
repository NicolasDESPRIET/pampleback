package com.pamplemousse.pampleback.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pamplemousse.pampleback.dto.QcmFromClientDto;
import com.pamplemousse.pampleback.dto.QcmToClientNoRDto;
import com.pamplemousse.pampleback.dto.QuestionNoResponseDto;
import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.exception.server.NotFoundException;
import com.pamplemousse.pampleback.mapper.QcmMapper;
import com.pamplemousse.pampleback.model.Qcm;
import com.pamplemousse.pampleback.model.Question;
import com.pamplemousse.pampleback.repository.QcmRepository;
import com.pamplemousse.pampleback.service.QcmService;
import com.pamplemousse.pampleback.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QcmServiceImpl implements QcmService {

    /**
     * QcmRepository qcmRepository.
     */
    private QcmRepository qcmRepository;

    /**
     * QcmMapper qcmMapper.
     */
    private QcmMapper qcmMapper;

    /**
     * QuestionService questionService.
     */
    private QuestionService questionService;

    /**
     * Constructor of the service.
     *
     * @param qcmRepository
     * @param qcmMapper
     */
    @Autowired
    public QcmServiceImpl(QcmRepository qcmRepository, QcmMapper qcmMapper, QuestionService questionService) {
        this.qcmRepository = qcmRepository;
        this.qcmMapper = qcmMapper;
        this.questionService = questionService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Qcm> getAllQcm() {
        return qcmRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<QcmToClientNoRDto> getAllQcmNoR() {
        List<Qcm> lQcms = getAllQcm();
        List<QcmToClientNoRDto> lClientNoRDtos = new ArrayList<QcmToClientNoRDto>();
        lQcms.stream().forEach(qcm -> {
            lClientNoRDtos.add(getOneByIdnoR(qcm.getId()));
        });

        return lClientNoRDtos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Qcm getOneById(Long id) {
        Qcm qcm = qcmRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.QCM_ID_NOT_FOUND_IN_DB));
        return qcm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QcmToClientNoRDto getOneByIdnoR(Long id) {
        Qcm qcm = getOneById(id);
        QcmToClientNoRDto qcmToClientNoRDto = qcmMapper.qcmToQcmToClientNoRDto(qcm);
        List<QuestionNoResponseDto> list = new ArrayList<QuestionNoResponseDto>();
        qcm.getQcmQuestion().stream().forEach((question) -> {
            list.add(questionService.getQuestionByIdNoResponseValue(question.getId()));
        });
        qcmToClientNoRDto.setQcmQuestion(list);
        return qcmToClientNoRDto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Qcm getOneByName(String name) {
        Qcm qcm = qcmRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.QCM_NOT_FOUND_IN_DB));
        return qcm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Qcm createQcm(QcmFromClientDto qcmFromClientDto) {
        if (!qcmRepository.findByName(qcmFromClientDto.getName()).isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.QCM_NAME_USED_IN_DB);
        }
        Qcm qcm = qcmMapper.qcmFromClientDtoToQcm(qcmFromClientDto);
        qcm.setQcmQuestion(new ArrayList<Question>());
        return qcmRepository.save(qcm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Qcm updateQcm(QcmFromClientDto qcmFromClientDto, Long id) {
        Qcm qcm = getOneById(id);
        if (!qcmRepository.findByName(qcmFromClientDto.getName()).isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.QCM_NAME_USED_IN_DB);
        }
        qcmMapper.updateQcmFromDto(qcmFromClientDto, qcm);
        if (qcm.getQcmQuestion() == null ){
            qcm.setQcmQuestion(new ArrayList<Question>());
        }
        return qcmRepository.save(qcm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteQcm(Long id) {
        Qcm qcm = getOneById(id);
        qcmRepository.delete(qcm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Qcm addQuestion(Long id, Question question) {
        Qcm qcm = getOneById(id);
        qcm.getQcmQuestion().add(question);
        return qcmRepository.save(qcm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Qcm removeQuestion(Long id, Question question) {
        Qcm qcm = getOneById(id);
        qcm.getQcmQuestion().remove(question);
        return qcmRepository.save(qcm);
    }
}
