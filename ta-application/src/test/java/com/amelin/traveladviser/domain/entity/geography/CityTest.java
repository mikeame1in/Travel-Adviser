package com.amelin.traveladviser.domain.entity.geography;

import com.amelin.traveladviser.domain.entity.transport.TransportType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CityTest {
    private City city;
    private Station station;
    @Before
    public void setup() {
        this.city = new City("Kiev");
    }

    @Test
    public void testAddValidStationSuccess() {
        Station station = city.addStation(TransportType.AUTO);

        assertTrue(containsStation(city, station));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullStationFailure() {
        city.addStation(null);

        assertTrue(false);
    }

    @Test
    public void testRemoveStationSuccess() {
        Station station = city.addStation(TransportType.AVIA);
        city.removeStation(station);

        assertTrue(city.getStations().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullStationFailure() {
        city.removeStation(null);

        assertTrue(false);
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }
}
