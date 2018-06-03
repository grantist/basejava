package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import static java.util.Arrays.*;


public class SortedArrayStorage extends AbstractArrayStorage {

    public void insertElement(Resume resume, int index) {
        int newIndex = -index - 1;
        System.arraycopy(storage, newIndex, storage, newIndex + 1, size - newIndex);
        storage[newIndex] = resume;
    }

    public void deleteElement(String uuid) {
        storage[getIndex(uuid)] = storage[size];
        storage[size] = null;

    }


    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return binarySearch(storage, 0, size, searchKey);
    }

}