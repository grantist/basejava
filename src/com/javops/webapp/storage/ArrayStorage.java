package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void insertElement(Resume resume, int index) {
        storage[size - index - 1] = resume;
        size++;

    }

    public void deleteElement(String uuid) {
        storage[getIndex(uuid)] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }
}