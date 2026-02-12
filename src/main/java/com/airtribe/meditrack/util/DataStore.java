package com.airtribe.meditrack.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DataStore<T> {

    private final Map<Integer, T> store = new HashMap<>();

    // Save object
    public void save(int id, T object) {
        store.put(id, object);
    }

    // Find by ID
    public T findById(int id) {
        return store.get(id);
    }

    // Return all objects
    public Collection<T> findAll() {
        return store.values();
    }

    // Delete by ID (optional)
    public void delete(int id) {
        store.remove(id);
    }
}

