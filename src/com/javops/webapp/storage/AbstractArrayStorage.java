package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by TRACTEL_RND on 04.04.2018.
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;//количество элементов в массиве

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (getIndex(uuid) == -1) {
            System.out.println("Resume " + uuid + " not exist.");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    public abstract void save(Resume r);

    public abstract void update(Resume r);

    public abstract void delete(String uuid);


}
