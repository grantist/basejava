package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.Arrays;

import static java.util.Arrays.*;


public class SortedArrayStorage extends AbstractArrayStorage {

    public void insertElement(Resume resume, int index) {
        int newIndex = -index - 1;
        System.arraycopy(storage, newIndex, storage, newIndex + 1, size - newIndex);
        storage[newIndex] = resume;
        size++;

    }

    public void deleteElement(String uuid) {
        storage[getIndex(uuid)] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

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

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return binarySearch(storage, 0, size, searchKey);
    }


}