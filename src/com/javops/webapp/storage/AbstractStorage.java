package com.javops.webapp.storage;

import com.javops.webapp.exception.ExistStorageException;
import com.javops.webapp.exception.NotExistStorageException;
import com.javops.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger Log = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getKey(String key);

    protected abstract void newUpdate(Resume resume, SK key);

    protected abstract boolean isExist(SK key);

    protected abstract void newSave(Resume resume, SK key);

    protected abstract Resume newGet(SK key);

    protected abstract void newDelete(SK key);

    protected abstract List<Resume> newGetAll();

    @Override
    public void update(Resume resume) {
        Log.info("Update " + resume);
        SK key = getExistentKey(resume.getUuid());
        newUpdate(resume, key);
    }

    @Override
    public void save(Resume resume) {
        Log.info("Save " + resume);
        SK key = getNotExistentKey(resume.getUuid());
        newSave(resume, key);
    }

    @Override
    public void delete(String uuid) {
        Log.info("Delete " + uuid);
        SK key = getExistentKey(uuid);
        newDelete(key);
    }

    @Override
    public Resume get(String uuid) {
        Log.info("Get " + uuid);
        SK key = getExistentKey(uuid);
        return newGet(key);
    }

    @Override
    public List<Resume> getAllSorted() {
        Log.info("getAllSorted");
        List<Resume> list = newGetAll();
        Collections.sort(list);
        return list;
    }

    private SK getNotExistentKey(String uuid) {
        SK key = getKey(uuid);
        if (isExist(key)) {
            Log.warning("Resume with uuid = " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    private SK getExistentKey(String uuid) {
        SK key = getKey(uuid);
        if (!isExist(key)) {
            Log.warning("Resume with uuid = " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

}
