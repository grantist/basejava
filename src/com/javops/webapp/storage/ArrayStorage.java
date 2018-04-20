package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist.");
        } else if (size == storage.length) {
            System.out.println("Storage overflow.");
        } else {
            storage[size] = r;
            size++;
        }

    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist.");

        } else {
            storage[index] = r;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (getIndex(uuid) == -1) {
            System.out.println("Resume " + uuid + " not exist.");
        } else {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }


}
