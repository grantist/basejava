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
        storage[size] = resume;
    }

    public void deleteElement(int index) {
        storage[index] = storage[size - 1];
    }
}