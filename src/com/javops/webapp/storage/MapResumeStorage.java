package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TRACTEL_RND on 07.07.2018.
 */
public class MapResumeStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getKey(String key) {
        return map.get(key);
    }

    @Override
    protected void newUpdate(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void newSave(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume newGet(Resume resume) {
        return resume;
    }

    @Override
    protected void newDelete(Resume resume) {
        map.remove((resume).getUuid());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected List<Resume> newGetAll() {
        return new ArrayList<>(map.values());
    }
}
