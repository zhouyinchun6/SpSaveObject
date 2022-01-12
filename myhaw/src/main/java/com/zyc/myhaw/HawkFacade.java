package com.zyc.myhaw;

import java.util.List;
import java.util.Map;
import java.util.Set;

interface HawkFacade {

    <T> boolean put(String key, T value);

    String getString(String key);

    String getString(String key, String defaultValue);

    boolean getBoolean(String key);

    boolean getBoolean(String key, boolean defaultValue);

    int getInt(String key);

    int getInt(String key, int defaultValue);

    long getLong(String key);

    long getLong(String key, long defaultValue);

    double getDouble(String key);

    double getDouble(String key, double defaultValue);

    <T> T getObject(String key, Class<T> tClass);

    <T> List<T> getList(String key, Class<T> tClass);

    <T> Set<T> getSet(String key, Class<T> tClass);

    <K, V> Map<K, V> getMap(String key, Class<K> kClass, Class<V> vClass);

    long count();

    boolean deleteAll();

    boolean delete(String key);

    boolean contains(String key);

    boolean isBuilt();

    void destroy();
}
