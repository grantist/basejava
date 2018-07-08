package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    @Override
    protected Integer getKey(String uuid) {
        Resume key = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, key, RESUME_COMPARATOR);
    }

    @Override
    public void insertElement(Resume resume, int index) {
        int newIndex = -index - 1;
        System.arraycopy(storage, newIndex, storage, newIndex + 1, size - newIndex);
        storage[newIndex] = resume;
    }

    @Override
    public void deleteElement(int index) {
        int newSize = size - index - 1;
        if (newSize > 0) {
            System.arraycopy(storage, index + 1, storage, index, newSize);
        }
    }
}