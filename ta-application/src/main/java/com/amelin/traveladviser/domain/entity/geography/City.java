package com.amelin.traveladviser.domain.entity.geography;

import com.amelin.traveladviser.domain.entity.base.AbstractEntity;
import com.amelin.traveladviser.domain.entity.transport.TransportType;
import com.amelin.traveladviser.domain.utils.CommonUtils;

import java.util.*;

/**
 * Any locality that contains transport stations
 * @author Mike Amelin
 */
public class City extends AbstractEntity {
    private String name;
    /**
     * Name of the district where city is placed
     */
    private String district;
    /**
     * Name of the region where district is located
     * Region is top-level area in the country
     */
    private String region;
    /**
     * Set of transport stations that is linked to this
     * locality
     */
    private Set<Station> stations;

    public City() {
    }

    public City(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<Station> getStations() {
        // Defensive programming, chapter 33
        return CommonUtils.getSafeSet(stations);
    }

    /**
     * Adds specified station to the city station list
     * @param transportType
     */
    public Station addStation(final TransportType transportType) {
        if (stations == null) {
            stations = new HashSet<>();
        }
        Station station = new Station(this, transportType);
        stations.add(station);

        return station;
    }

    /**
     * Removes specified station from the city station list
     * @param station
     */
    public void removeStation(final Station station) {
        Objects.requireNonNull(station, "station parameter is not initialized");
        if (stations == null) {
            return;
        }
        stations.remove(station);
    }
}
