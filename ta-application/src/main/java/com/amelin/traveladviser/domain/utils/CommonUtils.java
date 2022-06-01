package com.amelin.traveladviser.domain.utils;

import com.amelin.traveladviser.domain.entity.geography.Station;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Contains utility functions of the general purpose
 * @author Mike Amelin
 */
public class CommonUtils {
    /**
     * Returns not-null unmodifiable copy of the source set
     * @param source
     * @return
     * @param <T>
     */
    public static <T> Set<T> getSafeSet(Set<T> source) {
        return Collections.unmodifiableSet(Optional.ofNullable(source).orElse(Collections.emptySet()));
    }

    /**
     * Returns not-null unmodifiable copy of the source list
     * @param source
     * @return
     * @param <T>
     */
    public static <T> List<T> getSafeList(List<T> source) {
        return Collections.unmodifiableList(Optional.ofNullable(source).orElse(Collections.emptyList()));
    }
}
