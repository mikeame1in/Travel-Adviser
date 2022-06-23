package com.amelin.traveladviser.domain.search;

import com.amelin.traveladviser.domain.entity.transport.TransportType;

/**
 * Filtering criteria for search station operation
 * @author Mike Amelin
 */
public class StationCriteria {
    private String cityName;
    private TransportType transportType;
    /**
     * Station's address: street, zipCode, building number
     */
    private String address;

    public StationCriteria(final String name) {
        this.cityName = name;
    }

    public StationCriteria(final TransportType transportType) {
        this.transportType = transportType;
    }

    /**
     * Returns filtering criteria to search stations that contains
     * specified name parameter
     * @param name
     * @return
     */
    public static StationCriteria byName(String name) {
        return new StationCriteria(name);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
