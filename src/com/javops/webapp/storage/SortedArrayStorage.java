package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import static java.util.Arrays.*;

/**
 * Created by TRACTEL_RND on 04.04.2018.
 */
public class SortedArrayStorage extends AbstractArrayStorage {

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

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist.");
        } else {
            storage[index] = r;
        }
    }

    @Override
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

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return binarySearch(storage, 0, size, searchKey);
    }


}
