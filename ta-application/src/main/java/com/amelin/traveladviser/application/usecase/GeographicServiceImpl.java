package com.amelin.traveladviser.application.usecase;

import com.amelin.traveladviser.application.port.GeographicService;
import com.amelin.traveladviser.domain.entity.geography.City;
import com.amelin.traveladviser.domain.entity.geography.Station;
import com.amelin.traveladviser.domain.search.StationCriteria;
import com.amelin.traveladviser.domain.search.range.RangeCriteria;
import com.amelin.traveladviser.domain.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Default implementation of the {@link GeographicService}
 * @author Mike Amelin
 */
public class GeographicServiceImpl implements GeographicService {
    /**
     * Internal list of cities
     */
    private final List<City> cities;

    /**
     * Auto-increment counter for entity id generation
     */
    private int counter = 0;

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
            city.setId(++counter);
            cities.add(city);
        }
    }

    @Override
    public Optional<City> findCityById(final int id) {
        return cities.stream().filter(city -> city.getId() == id).findFirst();
    }

    @Override
    public List<Station> searchStations(final StationCriteria criteria, final RangeCriteria rangeCriteria) {
        Set<Station> stations = new HashSet<>();
        for (City city: cities) {
            stations.addAll(city.getStations());
        }

        return stations.stream().filter(station -> station.match(criteria)).collect(Collectors.toList());
    }
}
