package com.javops.webapp.storage;

import com.javops.webapp.exception.ExistStorageException;
import com.javops.webapp.exception.NotExistStorageException;
import com.javops.webapp.exception.StorageException;
import com.javops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by TRACTEL_RND on 04.04.2018.
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public void save(Resume resume) {
        if (!ExistStorageException(resume.getUuid()) && (size == storage.length)) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(resume, getIndex(resume.getUuid()));
            size++;
        }
    }

    public void update(Resume resume) {
        if (!NotExistStorageException(resume.getUuid())) {
            storage[getIndex(resume.getUuid())] = resume;
        }
    }

    public void delete(String uuid) {
        if (!NotExistStorageException(uuid)) {
            fillDeletedElement(getIndex(uuid));
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid) {
        if (!NotExistStorageException(uuid)) {
            return storage[getIndex(uuid)];
        }
        return null;
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume resume, int index);

    // protected abstract int getIndex(String uuid);


}
