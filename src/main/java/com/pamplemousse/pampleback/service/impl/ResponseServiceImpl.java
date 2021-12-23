package com.pamplemousse.pampleback.service.impl;

import java.util.List;

import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.exception.server.NotFoundException;
import com.pamplemousse.pampleback.model.Response;
import com.pamplemousse.pampleback.repository.ResponseRepository;
import com.pamplemousse.pampleback.service.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService {


    private ResponseRepository responseRepository;

    @Autowired
    public ResponseServiceImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Response> getAllResponses() {
        List<Response> list = responseRepository.findAll();
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponseByid(Long id) {
        Response response = responseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.RESPONSE_NOT_FOUND_IN_DB));
        return response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response createResponse(Response response) {
        return responseRepository.save(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response updateResponse(Response response, Long id) {
        responseRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.RESPONSE_NOT_FOUND_IN_DB));
        response.setId(id);
        return responseRepository.save(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteResponse(Long id) {
        Response response = responseRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ExceptionMessageConstants.RESPONSE_NOT_FOUND_IN_DB));
        responseRepository.delete(response);
    }
    
}
