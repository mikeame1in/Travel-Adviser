package com.amelin.traveladviser.app.rest.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.amelin.traveladviser.app.rest.service.base.BaseResource;
import com.amelin.traveladviser.application.dto.CityDTO;
import com.amelin.traveladviser.application.port.GeographicService;
import com.amelin.traveladviser.application.transform.Transformer;
import com.amelin.traveladviser.application.transform.impl.SimpleDTOTransformer;
import com.amelin.traveladviser.application.usecase.GeographicServiceImpl;
import com.amelin.traveladviser.domain.entity.geography.City;
import com.amelin.traveladviser.domain.entity.transport.TransportType;
import org.apache.commons.lang3.math.NumberUtils;

@Path("cities")
/**
 * {@link CityResource} is REST web-service that handles city-related requests
 * @author Mike Amelin
 */
public class CityResource extends BaseResource {
    /**
     * Underlying source of data
     */
    private final GeographicService service;

    /**
     * DTO <-> Entity transformer
     */
    private final Transformer transformer;

    public CityResource() {
        this.transformer = new SimpleDTOTransformer();
        this.service = new GeographicServiceImpl();

        City city = new City("Odessa");
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * Returns all the existing cities
     * @return
     */
    public List<CityDTO> findCities() {
        return service.findCities().stream().map(city -> transformer.transform(city, CityDTO.class))
                .collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    /**
     * Saves new city instance
     */
    public void saveCity(CityDTO cityDTO) {
        service.saveCity(transformer.untransform(cityDTO, City.class));
    }

    @Path("/{cityId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * Returns city with specified identifier
     */
    public Response findCityById(@PathParam("cityId") final String cityId) {
        if (!NumberUtils.isNumber(cityId)) {
            return BAD_REQUEST;
        }
        Optional<City> city = service.findCityById(NumberUtils.toInt(cityId));
        if (!city.isPresent()) {
            return NOT_FOUND;
        }
        return ok(transformer.transform(city.get(), CityDTO.class));
    }
}
