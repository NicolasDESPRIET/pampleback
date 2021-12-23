package com.pamplemousse.pampleback.exception.server;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class NotFoundException extends ResponseStatusException {

    /**
     * Constructor with message.
     * @param reason {@link com.pamplemousse.pampleback.exception.ExceptionMessageConstants }
     */
    public NotFoundException(final String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }

    /**
     * Constructor without message.
     */
    public NotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}