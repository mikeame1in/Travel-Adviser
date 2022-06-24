package com.amelin.traveladviser.domain.entity.geography;

import com.amelin.traveladviser.domain.entity.transport.TransportType;
import com.amelin.traveladviser.domain.search.StationCriteria;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Verifies functionality of the {@link Station} domain entity
 * @author Mike Amelin
 */
public class StationTest {
    private Station station;

    @Before
    public void setup() {
        City city = new City("Odessa");
        station = new Station(city, TransportType.AUTO);
    }

    @Test(expected = NullPointerException.class)
    public void testMatchCriteriaNotInitialized() {
        station.match(null);
    }

    @Test
    public void testMatchByNameSuccess() {
        assertTrue(station.match(StationCriteria.byName("Odessa")));
    }

    @Test
    public void testMatchByNameNotFound() {
        assertFalse(station.match(StationCriteria.byName("Kiev")));
    }
}
