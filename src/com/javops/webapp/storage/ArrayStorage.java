package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getKey(String uuid) {
        for ( int i = 0; i < size; i++ ) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insertElement(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    public void deleteElement(int index) {
        storage[index] = storage[size - 1];
    }
}