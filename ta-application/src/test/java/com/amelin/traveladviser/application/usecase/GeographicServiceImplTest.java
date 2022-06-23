package com.amelin.traveladviser.application.usecase;

import com.amelin.traveladviser.application.port.GeographicService;
import com.amelin.traveladviser.domain.entity.geography.City;
import com.amelin.traveladviser.domain.entity.geography.Station;
import com.amelin.traveladviser.domain.entity.transport.TransportType;
import com.amelin.traveladviser.domain.search.StationCriteria;
import com.amelin.traveladviser.domain.search.range.RangeCriteria;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Contain unit-tests for {@link GeographicServiceImpl}
 * @author Mike Amelin
 */
public class GeographicServiceImplTest {
    private static final int DEFAULT_CITY_ID = 1;
    private GeographicService service;

    @Before
    public void setup() {
        service = new GeographicServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<City> cities = service.findCities();
        assertTrue(cities.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess() {
        City city = new City("Kiev");
        service.saveCity(city);

        List<City> cities = service.findCities();
        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getName(), "Kiev");
    }

    @Test
    public void testFindCityByIdSuccess() {
        City city = new City("Kiyv");
        service.saveCity(city);

        Optional<City> foundCity = service.findCityById(DEFAULT_CITY_ID);
        assertTrue(foundCity.isPresent());
        assertEquals(foundCity.get().getId(), DEFAULT_CITY_ID);
    }

    @Test
    public void testFindCityByIdNotFound() {
        Optional<City> foundCity = service.findCityById(DEFAULT_CITY_ID);
        assertFalse(foundCity.isPresent());
    }

    @Test
    public void testSearchStationsByCityNameSuccess() {
        City city = new City("Odessa");
        city.setId(DEFAULT_CITY_ID);
        city.addStation(TransportType.AUTO);
        city.addStation(TransportType.RAILWAY);
        service.saveCity(city);

        List<Station> stations = service
                .searchStations(StationCriteria.byName("Odessa"), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertEquals(2, stations.size());
        assertEquals(stations.get(0).getCity(), city);
    }

    @Test
    public void testSearchStationsByNameNotFound() {
        List<Station> stations = service
                .searchStations(StationCriteria.byName("Odessa"), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertTrue(stations.isEmpty());
    }

    @Test
    public void testSearchStationsByTransportTypeSuccess() {
        City city = new City("Odessa");
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
        City city2 = new City("Kiev");
        city2.setId(2);
        city2.addStation(TransportType.AUTO);
        service.saveCity(city2);

        List<Station> stations = service
                .searchStations(new StationCriteria(TransportType.AUTO),new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertEquals(stations.size(), 2);
    }

    @Test
    public void testSearchStationsByTransportTypeNotFound() {
        City city = new City("Odessa");
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
        City city2 = new City("Kiev");
        city2.setId(2);
        city2.addStation(TransportType.RAILWAY);
        service.saveCity(city2);

        List<Station> stations = service
                .searchStations(new StationCriteria(TransportType.AVIA),new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertTrue(stations.isEmpty());
    }
}
