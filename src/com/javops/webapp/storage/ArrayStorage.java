package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];

    }

    @Override
    protected void insertElement(Resume resume, int index) {
        storage[size] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */


}
