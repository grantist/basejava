package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

/**
 * Created by TRACTEL_RND on 20.06.2018.
 */
public class MapStorage extends AbstractStorage {

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected void insertElement(Resume resume, int index) {

    }

    @Override
    protected void deleteElement(int index) {

    }
}
