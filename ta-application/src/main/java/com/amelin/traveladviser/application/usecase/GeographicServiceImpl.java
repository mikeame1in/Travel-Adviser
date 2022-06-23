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
        Stream<City> stream = cities.stream()
                .filter(city -> StringUtils.isEmpty(criteria.getCityName()) || city.getName().equals(criteria.getCityName()));

        Optional<Set<Station>> stations = stream.map(city -> city.getStations()).reduce((stations1, stations2) -> {
            Set<Station> newStations = new HashSet<>(stations2);
            newStations.addAll(stations1);
            return newStations;
        });
        if(!stations.isPresent()) {
            return Collections.emptyList();
        }
        return stations.get()
                .stream()
                .filter(station -> criteria.getTransportType() == null
                        || station.getTransportType() == criteria.getTransportType()).collect(Collectors.toList());
    }
}
