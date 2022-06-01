package com.amelin.traveladviser.domain.exception.base;

import com.amelin.traveladviser.domain.exception.base.AppException;

/**
 * Signals about exceptional cases in the application logic
 * @author Mike Amelin
 */
public class FlowException extends AppException {
    private static final long serialVersionUID = -2889607185988464072L;

    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlowException(String message) {
        super(message);
    }
}
