package com.amelin.traveladviser.domain.utils;

import com.amelin.traveladviser.domain.exception.flow.InvalidParameterException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckTest {
    @Test
    public void testCheckParameterGetException() {
        try {
            Checks.checkParameter(false, "test");
            assertTrue(false);
        } catch (Exception e) {
            assertSame(e.getClass(), InvalidParameterException.class);
            assertEquals(e.getMessage(), "test");
        }
    }

    @Test
    public void testCheckParameterNoException() {
        Checks.checkParameter(true, "test");
        assertTrue(true);
    }
}
