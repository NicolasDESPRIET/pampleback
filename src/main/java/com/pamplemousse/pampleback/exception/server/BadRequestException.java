package com.pamplemousse.pampleback.exception.server;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class BadRequestException extends ResponseStatusException {

    /**
     * Constructor with message.
     * @param reason {@link com.pamplemousse.pampleback.exception.ExceptionMessageConstants }
     */
    public BadRequestException(final String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }

    /**
     * Constructor without message.
     */
    public BadRequestException() {
        super(HttpStatus.BAD_REQUEST);
    }
}
