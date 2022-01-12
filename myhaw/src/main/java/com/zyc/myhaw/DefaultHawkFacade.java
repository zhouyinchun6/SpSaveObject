package com.zyc.myhaw;


import java.util.List;
import java.util.Map;
import java.util.Set;

class DefaultHawkFacade implements HawkFacade {

    private final Storage storage;
    private final Converter converter;
    private final LogInterceptor logInterceptor;

    public DefaultHawkFacade(HawkBuilder builder) {
        storage = builder.getStorage();
        converter = builder.getConverter();
        logInterceptor = builder.getLogInterceptor();
    }

    @Override
    public <T> boolean put(String key, T value) {
        // Validate
        HawkUtils.checkNull("Key", key);

        // If the value is null, delete it
        if (value == null) {
            return delete(key);
        }

        // 1. Convert to text
        String plainText = converter.toString(value);
        if (plainText == null) {
            return false;
        }

        // 4. Save to the storage
        if (storage.put(key, plainText)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getString(String key) {
        return getString(key, null);
    }

    @Override
    public String getString(String key, String defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        // 1. Get serialized text from the storage
        String plainText = storage.get(key);

        // 2. DataInfo
        DataInfo dataInfo = new DataInfo(DataInfo.TYPE_OBJECT, plainText, String.class, null);

        // 4. Convert the text to original data along with original type
        String result = null;
        try {
            result = converter.fromString(plainText, dataInfo);
        } catch (Exception e) {
            log("Hawk.get -> Converter failed");
        }
        return result == null ? defaultValue : result;
    }

    @Override
    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        // 1. Get serialized text from the storage
        String plainText = storage.get(key);

        // 2. DataInfo
        DataInfo dataInfo = new DataInfo(DataInfo.TYPE_OBJECT, plainText, Boolean.class, null);

        // 4. Convert the text to original data along with original type
        Boolean result = null;
        try {
            result = converter.fromString(plainText, dataInfo);
        } catch (Exception e) {
            log("Hawk.get -> Converter failed");
        }
        return result == null ? defaultValue : result;
    }

    @Override
    public int getInt(String key) {
        return getInt(key, 0);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        // 1. Get serialized text from the storage
        String plainText = storage.get(key);

        // 2. DataInfo
        DataInfo dataInfo = new DataInfo(DataInfo.TYPE_OBJECT, plainText, Integer.class, null);

        // 4. Convert the text to original data along with original type
        Integer result = null;
        try {
            result = converter.fromString(plainText, dataInfo);
        } catch (Exception e) {
            log("Hawk.get -> Converter failed");
        }
        return result == null ? defaultValue : result;
    }

    @Override
    public long getLong(String key) {
        return getLong(key, 0);
    }

    @Override
    public long getLong(String key, long defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        // 1. Get serialized text from the storage
        String plainText = storage.get(key);

        // 2. DataInfo
        DataInfo dataInfo = new DataInfo(DataInfo.TYPE_OBJECT, plainText, Long.class, null);

        // 4. Convert the text to original data along with original type
        Long result = null;
        try {
            result = converter.fromString(plainText, dataInfo);
        } catch (Exception e) {
            log("Hawk.get -> Converter failed");
        }
        return result == null ? defaultValue : result;
    }

    @Override
    public double getDouble(String key) {
        return getDouble(key, 0);
    }

    @Override
    public double getDouble(String key, double defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        // 1. Get serialized text from the storage
        String plainText = storage.get(key);

        // 2. DataInfo
        DataInfo dataInfo = new DataInfo(DataInfo.TYPE_OBJECT, plainText, Double.class, null);

        // 4. Convert the text to original data along with original type
        Double result = null;
        try {
            result = converter.fromString(plainText, dataInfo);
        } catch (Exception e) {
            log("Hawk.get -> Converter failed");
        }
        return result == null ? defaultValue : result;
    }

    @Override
    public <T> T getObject(String key, Class<T> tClass) {
        if (key == null) {
            return null;
        }

        // 1. Get serialized text from the storage
        String plainText = storage.get(key);

        // 2. DataInfo
        DataInfo dataInfo = new DataInfo(DataInfo.TYPE_OBJECT, plainText, tClass, null);

        // 4. Convert the text to original data along with original type
        T result = null;
        try {
            result = converter.fromString(plainText, dataInfo);
        } catch (Exception e) {
            log("Hawk.get -> Converter failed");
        }
        return result;
    }

    @Override
    public <T> List<T> getList(String key, Class<T> tClass) {
        if (key == null) {
            return null;
        }

        // 1. Get serialized text from the storage
        String plainText = storage.get(key);

        // 2. DataInfo
        DataInfo dataInfo = new DataInfo(DataInfo.TYPE_LIST, plainText, tClass, null);

        // 4. Convert the text to original data along with original type
        List<T> result = null;
        try {
            result = converter.fromString(plainText, dataInfo);
        } catch (Exception e) {
            log("Hawk.get -> Converter failed");
        }
        return result;
    }

    @Override
    public <T> Set<T> getSet(String key, Class<T> tClass) {
        if (key == null) {
            return null;
        }

        // 1. Get serialized text from the storage
        String plainText = storage.get(key);

        // 2. DataInfo
        DataInfo dataInfo = new DataInfo(DataInfo.TYPE_SET, plainText, tClass, null);

        // 4. Convert the text to original data along with original type
        Set<T> result = null;
        try {
            result = converter.fromString(plainText, dataInfo);
        } catch (Exception e) {
            log("Hawk.get -> Converter failed");
        }
        return result;
    }

    @Override
    public <K, V> Map<K, V> getMap(String key, Class<K> kClass, Class<V> vClass) {
        if (key == null) {
            return null;
        }

        // 1. Get serialized text from the storage
        String plainText = storage.get(key);

        // 2. DataInfo
        DataInfo dataInfo = new DataInfo(DataInfo.TYPE_MAP, plainText, kClass, vClass);

        // 4. Convert the text to original data along with original type
        Map<K, V> result = null;
        try {
            result = converter.fromString(plainText, dataInfo);
        } catch (Exception e) {
            log("Hawk.get -> Converter failed");
        }
        return result;
    }


    @Override
    public long count() {
        return storage.count();
    }

    @Override
    public boolean deleteAll() {
        return storage.deleteAll();
    }

    @Override
    public boolean delete(String key) {
        return storage.delete(key);
    }

    @Override
    public boolean contains(String key) {
        return storage.contains(key);
    }

    @Override
    public boolean isBuilt() {
        return true;
    }

    @Override
    public void destroy() {
    }

    private void log(String message) {
        logInterceptor.onLog(message);
    }
}
