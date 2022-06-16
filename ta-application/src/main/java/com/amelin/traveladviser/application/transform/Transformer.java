package com.amelin.traveladviser.application.transform;

import com.amelin.traveladviser.application.dto.base.BaseDTO;
import com.amelin.traveladviser.domain.entity.base.AbstractEntity;

/**
 * Represents transformation engine to convert business entities
 * into DTO objects
 * @author Mike Amelin
 */
public interface Transformer {
    /**
     * Converts specified entity into DTO object
     * @param entity
     * @param clz
     * @return
     */
    <T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clz);

    /**
     * Converts specified DTO object into business entity
     * @param dto
     * @param clz
     * @return
     */
    <T extends AbstractEntity, P extends  BaseDTO<T>> T untransform(P dto, Class<T> clz);

}
