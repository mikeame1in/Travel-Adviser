package com.amelin.traveladviser.application.transform.impl;

import com.amelin.traveladviser.application.dto.base.BaseDTO;
import com.amelin.traveladviser.application.transform.Transformer;
import com.amelin.traveladviser.domain.entity.base.AbstractEntity;
import com.amelin.traveladviser.domain.utils.Checks;
import com.amelin.traveladviser.domain.utils.ReflectionUtil;

public class SimpleDTOTransformer implements Transformer {
    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(final T entity, final Class<P> clz) {
        checkParams(entity, clz);

        P dto = ReflectionUtil.createInstance(clz);
        ReflectionUtil.copyFields(entity, dto,
                ReflectionUtil.findSimilarFields(entity.getClass(), clz));
        dto.transform(entity);

        return dto;
    }

    private void checkParams(final Object param, final Class<?> clz) {
        Checks.checkParameter(param != null, "Source transformation object is not initialized");
        Checks.checkParameter(clz != null, "No class is defined for transformation");
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(final P dto, final Class<T> clz) {
        checkParams(dto, clz);

        T entity = ReflectionUtil.createInstance(clz);

        ReflectionUtil.copyFields(dto, entity,
                ReflectionUtil.findSimilarFields(dto.getClass(), clz));
        dto.untransform(entity);

        return entity;
    }
}
