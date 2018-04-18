package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.*;

/**
 * Created by TRACTEL_RND on 04.04.2018.
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume r) {
        Arrays.sort(storage);
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist.");
        } else {
            storage[index] = r;
        }
    }

    @Override
    public void save(Resume r) {
        Arrays.sort(storage);
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
    public void delete(String uuid) {
        Arrays.sort(storage);
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
    public Resume[] getAll() {
        Arrays.sort(storage);
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return binarySearch(storage, 0, size, searchKey);
    }


}
