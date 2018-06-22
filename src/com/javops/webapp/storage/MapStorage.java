package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

/**
 * Created by TRACTEL_RND on 20.06.2018.
 */
public class MapStorage extends AbstractStorage {


    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected Object getKey(String key) {
        return null;
    }

    @Override
    protected void newUpdate(Resume resume, Object key) {

    }

    @Override
    protected void newSave(Resume resume, Object key) {

    }

    @Override
    protected Resume newGet(Object key) {
        return null;
    }

    @Override
    protected void newDelete(Object key) {

    }

    @Override
    protected boolean isExist(Object key) {
        return false;
    }
}
