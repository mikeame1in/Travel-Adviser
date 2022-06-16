package com.amelin.traveladviser.application.transform.impl;

import com.amelin.traveladviser.application.dto.CityDTO;
import com.amelin.traveladviser.application.transform.Transformer;
import com.amelin.traveladviser.domain.entity.geography.City;
import com.amelin.traveladviser.domain.exception.flow.InvalidParameterException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer} unit
 * @author Mike Amelin
 */
public class SimpleDTOTransformerTest {
    private Transformer transformer;

    @Before
    public void setup() {
        transformer = new SimpleDTOTransformer();
    }

    @Test
    public void testTransformCitySuccess() {
        City city = new City("Kiyv");
        city.setId(1);
        city.setRegion("KO");
        city.setDistrict("None");

        CityDTO dto = transformer.transform(city, CityDTO.class);
        assertNotNull(dto);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected = InvalidParameterException.class)
    public void testTransformNullCityFailure() {
        transformer.transform(null, CityDTO.class);
    }

    @Test(expected = InvalidParameterException.class)
    public void testTransformNullDTOClassFailure() {
        transformer.transform(new City("Kiyv"), null);
    }

    @Test
    public void testUnTransformCitySuccess() {
        CityDTO dto = new CityDTO();
        dto.setId(1);
        dto.setName("Kiyv");
        dto.setRegion("KO");
        dto.setDistrict("None");

        City city = transformer.untransform(dto, City.class);
        assertNotNull(city);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected = InvalidParameterException.class)
    public void testUnTransformNullCityFailure() {
        transformer.untransform(null, City.class);
    }

    @Test(expected = InvalidParameterException.class)
    public void testUnTransformNullEntityClassFailure() {
        transformer.untransform(new CityDTO(), null);
    }
}
