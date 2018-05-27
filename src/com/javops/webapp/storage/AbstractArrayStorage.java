package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 3;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

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

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index <= -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index <= -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteElement(String uuid);
}