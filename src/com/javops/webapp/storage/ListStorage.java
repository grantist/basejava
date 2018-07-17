package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
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
    protected void newUpdate(Resume resume, Integer key) {
        list.set(key, resume);
    }

    @Override
    public List<Resume> newGetAll() {
        return new ArrayList<>(list);
    }

    @Override
    protected void newSave(Resume resume, Integer key) {
        list.add(resume);
    }

    @Override
    protected Resume newGet(Integer key) {
        return list.get(key);
    }

    @Override
    protected void newDelete(Integer key) {
        list.remove(key.intValue());
    }

    @Override
    protected boolean isExist(Integer key) {
        return key != null;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }
}

