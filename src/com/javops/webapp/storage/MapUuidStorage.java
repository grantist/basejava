package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.*;

/**
 * Created by TRACTEL_RND on 20.06.2018.
 */
public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getKey(String uuid) {
        return uuid;
    }

    @Override
    protected void newUpdate(Resume resume, Object uuid) {

        map.put((String) uuid, resume);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey(uuid);
    }

    @Override
    protected void newSave(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected Resume newGet(Object uuid) {
        return (map.get(uuid));
    }

    @Override
    protected void newDelete(Object uuid) {
        map.remove(uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> newGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
