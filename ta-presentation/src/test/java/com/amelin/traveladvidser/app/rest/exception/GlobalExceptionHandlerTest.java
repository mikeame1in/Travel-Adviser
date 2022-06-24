package com.amelin.traveladvidser.app.rest.exception;

import com.amelin.traveladviser.app.rest.exception.GlobalExceptionHandler;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static org.junit.Assert.assertEquals;

/**
 * Verifies that {@link com.amelin.traveladviser.app.rest.exception.GlobalExceptionHandler}
 * correctly handles application exception
 * @author Mike Amelin
 */
public class GlobalExceptionHandlerTest {
    /**
     * Current exception handler
     */
    private ExceptionMapper<Exception> handler;

    @Before
    public void setup() {
        handler = new GlobalExceptionHandler();
    }

    @Test
    public void testToResponseReturnServerError() {
        Exception exception = new Exception("test");
        Response response = handler.toResponse(exception);
        assertEquals(response.getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }
}
