package com.sap.cloud.lm.sl.common.util;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MapUtil {

    public static <K, V> Map<K, V> upcastUnmodifiable(Map<? extends K, ? extends V> map) {
        return unmodifiable(map);
    }

    public static <K, V> Map<K, V> upcast(Map<? extends K, ? extends V> map) {
        return map == null ? null : new TreeMap<>(map);
    }

    public static <K, V> Map<K, V> castUnmodifiable(Map<?, ?> map) {
        return unmodifiable(MapUtil.<K, V> cast(map));
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> cast(Map<?, ?> map) {
        return map == null ? null : new TreeMap<>((Map<? extends K, ? extends V>) map);
    }

    public static <K, V> Map<K, V> unmodifiable(Map<? extends K, ? extends V> map) {
        return map == null ? null : Collections.unmodifiableMap(map);
    }

    public static <K, V> void addNonNull(Map<K, V> env, K key, V value) {
        if (value != null) {
            env.put(key, value);
        }
    }

    public static <K, V> Map<K, V> mergeSafely(Map<K, V> original, Map<K, V> override) {
        Map<K, V> result = new TreeMap<K, V>();
        if (original != null) {
            result.putAll(original);
        }
        if (override != null) {
            result.putAll(override);
        }
        return result;
    }

    public static <K, V> Map<K, V> merge(Map<K, V> original, Map<K, V> override) {
        Map<K, V> result = new TreeMap<K, V>();
        result.putAll(original);
        result.putAll(override);
        return result;
    }

    public static <K, V> Map<K, V> asMap(K key, V value) {
        Map<K, V> result = new TreeMap<K, V>();
        result.put(key, value);
        return result;
    }

}
