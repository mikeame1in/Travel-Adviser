package com.amelin.traveladviser.application.port;

import com.amelin.traveladviser.domain.entity.geography.City;

import java.util.List;

/**
 * Entry point to perform operations
 * over geographic entities
 * @author Mike Amelin
 */
public interface GeographicService {
    /**
     * Returns list of existing cities
     * @return
     */
    List<City> findCities();

    /**
     * Saves specified city instance
     * @param city
     */
    void saveCity(City city);
}
