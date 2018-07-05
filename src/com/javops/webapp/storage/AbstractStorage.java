package com.javops.webapp.storage;

import com.javops.webapp.exception.ExistStorageException;
import com.javops.webapp.exception.NotExistStorageException;
import com.javops.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getKey(String key);

    protected abstract void newUpdate(Resume resume, Object key);

    protected abstract void newSave(Resume resume, Object key);

    protected abstract Resume newGet(Object key);

    protected abstract void newDelete(Object key);

    protected abstract boolean isExist(Object key);


    private Object getNotExistentKey(String uuid) {
        Object key = getKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    private Object getExistentKey(String uuid) {
        Object key = getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    public void save(Resume resume) {
        Object key = getNotExistentKey(resume.getUuid());
        newSave(resume, key);
    }

    public void update(Resume resume) {
        Object key = getExistentKey(resume.getUuid());
        newUpdate(resume, key);
    }


    public void delete(String uuid) {
        Object key = getExistentKey(uuid);
        newDelete(key);
    }

    public Resume get(String uuid) {
        Object key = getExistentKey(uuid);
        return newGet(key);
    }
}
