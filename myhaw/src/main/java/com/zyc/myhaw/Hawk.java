package com.zyc.myhaw;

import android.content.Context;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Secure, simple key-value storage for Android.
 */
public final class Hawk {

    Hawk() {

    }

    private HawkFacade hawkFacade;

    /**
     * This will init the hawk without password protection.
     *
     * @param context is used to instantiate context based objects.
     *                ApplicationContext will be used
     */
    static HawkBuilder init(Context context, String spFileName) {
        HawkUtils.checkNull("Context", context);
        return new HawkBuilder(context, spFileName);
    }

    void build(HawkBuilder hawkBuilder) {
        hawkFacade = new DefaultHawkFacade(hawkBuilder);
    }

    /**
     * Saves any type including any collection, primitive values or custom objects
     *
     * @param key   is required to differentiate the given data
     * @param value is the data that is going to be encrypted and persisted
     * @return true if the operation is successful. Any failure in any step will return false
     */
    public <T> boolean put(String key, T value) {
        return hawkFacade.put(key, value);
    }


    public String getString(String key) {
        return hawkFacade.getString(key);
    }

    public String getString(String key, String defaultValue) {
        return hawkFacade.getString(key, defaultValue);
    }


    public boolean getBoolean(String key) {
        return hawkFacade.getBoolean(key);
    }


    public boolean getBoolean(String key, boolean defaultValue) {
        return hawkFacade.getBoolean(key, defaultValue);
    }


    public int getInt(String key) {
        return hawkFacade.getInt(key);
    }

    public int getInt(String key, int defaultValue) {
        return hawkFacade.getInt(key, defaultValue);
    }


    public long getLong(String key) {
        return hawkFacade.getLong(key);
    }

    public long getLong(String key, long defaultValue) {
        return hawkFacade.getLong(key, defaultValue);
    }


    public double getDouble(String key) {
        return hawkFacade.getDouble(key);
    }

    public double getDouble(String key, double defaultValue) {
        return hawkFacade.getDouble(key, defaultValue);
    }


    public <T> T getObject(String key, Class<T> tClass) {
        return hawkFacade.getObject(key, tClass);
    }


    public <T> List<T> getList(String key, Class<T> tClass) {
        return hawkFacade.getList(key, tClass);
    }


    public <T> Set<T> getSet(String key, Class<T> tClass) {
        return hawkFacade.getSet(key, tClass);
    }


    public <K, V> Map<K, V> getMap(String key, Class<K> kClass, Class<V> vClass) {
        return hawkFacade.getMap(key, kClass, vClass);
    }


    /**
     * Size of the saved data. Each key will be counted as 1
     *
     * @return the size
     */
    public long count() {
        return hawkFacade.count();
    }

    /**
     * Clears the storage, note that crypto data won't be deleted such as salt key etc.
     * Use resetCrypto in order to deleteAll crypto information
     *
     * @return true if deleteAll is successful
     */
    public boolean deleteAll() {
        return hawkFacade.deleteAll();
    }

    /**
     * Removes the given key/value from the storage
     *
     * @param key is used for removing related data from storage
     * @return true if delete is successful
     */
    public boolean delete(String key) {
        return hawkFacade.delete(key);
    }

    /**
     * Checks the given key whether it exists or not
     *
     * @param key is the key to check
     * @return true if it exists in the storage
     */
    public boolean contains(String key) {
        return hawkFacade.contains(key);
    }

    /**
     * Use this method to verify if Hawk is ready to be used.
     *
     * @return true if correctly initialised and built. False otherwise.
     */
    public boolean isBuilt() {
        return hawkFacade.isBuilt();
    }

    public void destroy() {
        hawkFacade.destroy();
    }

}
