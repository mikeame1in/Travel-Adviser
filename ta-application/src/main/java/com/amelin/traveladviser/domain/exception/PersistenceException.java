package com.amelin.traveladviser.domain.exception;

import com.amelin.traveladviser.domain.exception.base.AppException;

/**
 * Signals about data access layer unexpected situations
 * @author Mike Amelin
 */
public class PersistenceException extends AppException {
    private static final long serialVersionUID = -7889716045779735512L;

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(String message) {
        super(message);
    }
}
