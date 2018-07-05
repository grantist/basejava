package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TRACTEL_RND on 20.06.2018.
 */
public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>();
        list.addAll(map.values());
        return list;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected String getKey(String key) {
        for ( String searchKey : map.keySet() ) {
            if (searchKey.equals(key)) {
                return key;
            }
        }
        return null;
    }

    @Override
    protected void newUpdate(Resume resume, Object key) {
        map.put((String) key, resume);
    }

    @Override
    protected void newSave(Resume resume, Object key) {
        map.put((String) key, resume);
    }

    @Override
    protected Resume newGet(Object key) {
        return (map.get(key));
    }

    @Override
    protected void newDelete(Object key) {
        map.remove(key);
    }

    @Override
    protected boolean isExist(Object key) {
        return map.containsKey(key);
    }
}
