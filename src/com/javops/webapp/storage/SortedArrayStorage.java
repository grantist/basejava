package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.Arrays;

import static java.util.Arrays.*;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getKey(String uuid) {
        Resume key = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, key);
    }

    public void insertElement(Resume resume, int index) {
        int newIndex = -index - 1;
        System.arraycopy(storage, newIndex, storage, newIndex + 1, size - newIndex);
        storage[newIndex] = resume;
    }

    public void deleteElement(int index) {
        int newSize = size - index - 1;
        if (newSize > 0) {
            System.arraycopy(storage, index + 1, storage, index, newSize);
        }
    }

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return binarySearch(storage, 0, size, searchKey);
    }
}