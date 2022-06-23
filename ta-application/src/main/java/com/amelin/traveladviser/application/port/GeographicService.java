package com.amelin.traveladviser.application.port;

import com.amelin.traveladviser.domain.entity.geography.City;
import com.amelin.traveladviser.domain.entity.geography.Station;
import com.amelin.traveladviser.domain.search.StationCriteria;
import com.amelin.traveladviser.domain.search.range.RangeCriteria;

import java.util.List;
import java.util.Optional;

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

    /**
     * Returns city with specified identifier. If no city is found then empty optional
     * is returned
     * @param id
     * @return
     */
    Optional<City> findCityById(int id);

    /**
     * Returns all the stations that match specified criteria
     * @param criteria
     * @param rangeCriteria
     * @return
     */
    List<Station> searchStations(StationCriteria criteria, RangeCriteria rangeCriteria);
}
