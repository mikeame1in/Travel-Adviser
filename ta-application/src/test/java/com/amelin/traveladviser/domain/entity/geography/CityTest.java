package com.amelin.traveladviser.domain.entity.geography;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CityTest {
    @Test
    public void testAddValidStationSuccess() {
        Station station = new Station();

        City city = new City();
        city.addStation(station);

        assertTrue(containsStation(city, station));
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }
}
