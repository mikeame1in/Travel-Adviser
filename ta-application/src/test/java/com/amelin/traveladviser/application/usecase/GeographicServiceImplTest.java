package com.amelin.traveladviser.application.usecase;

import com.amelin.traveladviser.application.port.GeographicService;
import com.amelin.traveladviser.domain.entity.geography.City;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Contain unit-tests for {@link GeographicServiceImpl}
 * @author Mike Amelin
 */
public class GeographicServiceImplTest {
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
    public void test() {
        City city1 = new City("Odessa");
        City city2 = new City("Kiev");
        City city3 = new City("Leiv");

        service.saveCity(city1);
        service.saveCity(city2);
        service.saveCity(city3);

        List<City> cities = service.findCities();

        for (City city: cities) {
            System.out.println(city.getName());
        }
    }
}
