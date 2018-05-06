package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TRACTEL_RND on 04.05.2018.
 */
public class MapStorage extends AbstractStorage {

    Map<String, Resume> storage = new HashMap<>();

    @Override
    public void save(Resume resume) {

    }

    @Override
    public Resume get(String uuid) {

        return null;
    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    public void delete(String uuid) {

    }

}
