package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getKey(String uuid) {
        for ( int i = 0; i < list.size(); i++ ) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void newUpdate(Resume resume, Object key) {
        list.set((Integer) key, resume);
    }

    @Override
    public List<Resume> newGetAll() {
        return list;
    }

    @Override
    protected void newSave(Resume resume, Object key) {
        list.add(resume);
    }

    @Override
    protected Resume newGet(Object key) {
        return list.get((Integer) key);
    }

    @Override
    protected void newDelete(Object key) {
        list.remove(((Integer) key).intValue());
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return list;
    }

    @Override
    public int size() {
        return list.size();
    }
}

