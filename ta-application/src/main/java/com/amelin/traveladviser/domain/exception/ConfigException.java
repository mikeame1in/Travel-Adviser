package com.amelin.traveladviser.domain.exception;

import com.amelin.traveladviser.domain.exception.base.AppException;

/**
 * Signals about incorrect configuration settings/parameters
 * @author Mike Amelin
 */
public class ConfigException extends AppException {
    private static final long serialVersionUID = -2177284893894040026L;

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(String message) {
        super(message);
    }
}
