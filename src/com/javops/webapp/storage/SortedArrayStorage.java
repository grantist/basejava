package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import static java.util.Arrays.*;


public class SortedArrayStorage extends AbstractArrayStorage {

    public void insertElement(Resume resume, int index) {
        int newIndex = -index - 1;
        System.arraycopy(storage, newIndex, storage, newIndex + 1, size - newIndex);
        storage[newIndex] = resume;
    }

    public void deleteElement(int index) {
        int newIndex = size - index - 1;
        if (newIndex > 0) {
            System.arraycopy(storage, index + 1, storage, index, newIndex);
        }
    }


    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return binarySearch(storage, 0, size, searchKey);
    }

}