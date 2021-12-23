package com.pamplemousse.pampleback.service;

import java.util.List;

import com.pamplemousse.pampleback.model.Response;

public interface ResponseService {
    /**
     * get all Responses in the db.
     * @return List<Response>.
     */
    List<Response> getAllResponses();

    /**
     * get one Response by his id.
     * @param id the id researched.
     * @return the researched Response.
     * @throws NotFoundException.
     */
    Response getResponseByid(Long id);

    /**
     * add an Response to the db.
     * @param response the nex Response.
     * @return the Response added.
     * @throws BadRequestException.
     */
    Response createResponse(Response response);

    /**
     * update an Response with new value.
     * @param response the update data for Response.
     * @param id       the id of Response to update.
     * @return the updated Response.
     * @throws BadRequestException.
     * @throws NotFoundException.
     */
    Response updateResponse(Response response, Long id);

    /**
     * delete the Response by his id.
     * @param id the id of the Response.
     * @throws NotFoundException.s
     */
    void deleteResponse(Long id);
}
