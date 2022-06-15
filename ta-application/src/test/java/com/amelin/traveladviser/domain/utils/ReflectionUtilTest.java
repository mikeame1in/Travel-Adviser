package com.amelin.traveladviser.domain.utils;

import com.amelin.traveladviser.domain.exception.flow.InvalidParameterException;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Verifies functionality of the {@link ReflectionUtil} unit
 * @author Mike Amelin
 */
public class ReflectionUtilTest {
    @Test
    public void createInstanceSuccess() {
        Object value = ReflectionUtil.createInstance(Source.class);
        assertNotNull(value);
    }

    @Test
    public void findSimilarFieldsSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertNotNull(fields);
        assertTrue(fields.contains("value"));
    }

    @Test
    public void copyFieldsSuccess() {
        Source source = new Source();
        source.setValue(10);
        Destination destination = new Destination();
        List<String> fields = ReflectionUtil.findSimilarFields(source.getClass(), destination.getClass());

        ReflectionUtil.copyFields(source, destination, fields);
        assertEquals(destination.getValue(), 10);
    }

    @Test(expected = InvalidParameterException.class)
    public void copyFieldsDestinationNullFailure() {
        Source source = new Source();
        ReflectionUtil.copyFields(source, null, Collections.emptyList());
    }
}

class Source {
    private int value;
    private String text;

    public void setValue(int value) { this.value = value; }
}

class Destination {
    private int value;

    public int getValue() {
        return value;
    }
}


