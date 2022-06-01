package com.amelin.traveladviser.application.usecase;

import com.amelin.traveladviser.application.port.GeographicService;
import com.amelin.traveladviser.domain.entity.geography.City;
import com.amelin.traveladviser.domain.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the {@link GeographicService}
 * @author Mike Amelin
 */
public class GeographicServiceImpl implements GeographicService {
    /**
     * Internal list of cities
     */
    private final List<City> cities;

    public GeographicServiceImpl() {
        this.cities = new ArrayList<City>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtils.getSafeList(cities);
    }

    @Override
    public void saveCity(City city) {
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }
}
