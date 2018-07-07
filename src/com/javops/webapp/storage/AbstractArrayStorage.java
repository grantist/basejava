package com.javops.webapp.storage;

import com.javops.webapp.exception.StorageException;
import com.javops.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected void newUpdate(Resume resume, Object index) {
        storage[(Integer) index] = resume;
    }

    @Override
    public List<Resume> newGetAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    public void newSave(Resume resume, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(resume, (Integer) index);
            size++;
        }
    }

    @Override
    public Resume newGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    public void newDelete(Object index) {
        deleteElement((Integer) index);
        size--;
        storage[size] = null;
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected abstract Integer getKey(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteElement(int index);

}