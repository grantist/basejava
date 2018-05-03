package com.javops.webapp.storage;

import com.javops.webapp.exception.ExistStorageException;
import com.javops.webapp.exception.NotExistStorageException;
import com.javops.webapp.exception.StorageException;
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
    } //template method

    public void clear() {   //template method
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {  //template method
        return Arrays.copyOfRange(storage, 0, size);
    }


    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else if (size == storage.length) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            throw new NotExistStorageException(resume.getUuid());

        } else {
            storage[index] = resume;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (getIndex(uuid) < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid) { //template method
        int index = getIndex(uuid);
        if (getIndex(uuid) < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract int getIndex(String uuid);


}
