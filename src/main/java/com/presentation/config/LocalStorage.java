package com.presentation.config;

import java.util.HashMap;

public class LocalStorage {
    private HashMap<String, Object> map;

    private static LocalStorage instance;

    public static LocalStorage getInstance() {
        if (instance == null) {
            instance = new LocalStorage();
        }

        return instance;
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void set(String key, Object value) {
        map.put(key, value);
    }

    private LocalStorage() {
        map = new HashMap<>();
    }
}
