package com.pamplemousse.pampleback.exception.server;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class InternalServerErrorException extends ResponseStatusException {

    /**
     * Constructor with message.
     * @param reason {@link com.pamplemousse.pampleback.exception.ExceptionMessageConstants }
     */
    public InternalServerErrorException(String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }

    /**
     * Constructor without message.
     */
    public InternalServerErrorException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
