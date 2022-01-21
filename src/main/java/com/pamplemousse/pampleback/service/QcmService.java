package com.pamplemousse.pampleback.service;

import java.util.List;

import com.pamplemousse.pampleback.dto.QcmFromClientDto;
import com.pamplemousse.pampleback.dto.QcmToClientNoRDto;
import com.pamplemousse.pampleback.model.Qcm;
import com.pamplemousse.pampleback.model.Question;

public interface QcmService {
    /**
     * get all Qcm in the db.
     * @return List<Qcm>
     */
    List<Qcm> getAllQcm();

    /**
     * Get all qcm without response values.
     * @return List<QcmToClientNoRDto>
     */
    List<QcmToClientNoRDto> getAllQcmNoR();

    /**
     * Get one qcm by his id.
     * @param id 
     * @return Qcm
     */
    Qcm getOneById(Long id);

    /**
     * get on qcm by his id without response value.
     * @param id
     * @return QcmToClientNoRDto
     */
    QcmToClientNoRDto getOneByIdnoR(Long id);

    /**
     * Get one qcm by his name.
     * @param name
     * @return Qcm
     */
    Qcm getOneByName(String name);

    /**
     * create qcm from QcmFromClientDto, no question
     * @param qcmFromClientDto the data of the qcm without question
     * @return Qcm created
     */
    Qcm createQcm(QcmFromClientDto qcmFromClientDto);

    /**
     * update the qcm with new data qcmFromClientDto, witout udpate question.
     * @param qcmFromClientDto
     * @param id
     * @return Qcm udapted
     */
    Qcm updateQcm(QcmFromClientDto qcmFromClientDto, Long id);

    /**
     * delete qcm by his id.
     * @param id
     */
    void deleteQcm(Long id);

    /**
     * Add question in the Qcm
     * @param id the id of the Qcm
     * @param question the question
     * @return Qcm
     */
    Qcm addQuestion(Long id, Question question);

    /**
     * remove question in the Qcm
     * @param id the id of the qcm
     * @param question the question
     * @return Qcm
     */
    Qcm removeQuestion(Long id, Question question);
}
