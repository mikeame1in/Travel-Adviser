package com.amelin.traveladviser.domain.utils;

import com.amelin.traveladviser.domain.exception.flow.InvalidParameterException;

public class Checks {
    /**
     * Verifies that specified check passed and throws exception otherwise
     * @param check
     * @param message
     * @throws InvalidParameterException
     */
    public static void checkParameter(boolean check, String message)
            throws InvalidParameterException {
        if (!check) {
            throw new InvalidParameterException(message);
        }
    }
}
