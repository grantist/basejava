package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            insertElement(r, index);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            deleteElement(uuid);
        }
    }

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