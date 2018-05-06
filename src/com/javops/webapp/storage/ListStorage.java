package com.javops.webapp.storage;

import com.javops.webapp.exception.NotExistStorageException;
import com.javops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by TRACTEL_RND on 04.05.2018.
 */
public class ListStorage extends AbstractStorage {

    private List<Resume> storage = new ArrayList<>();
    private Iterator<Resume> iterator = storage.iterator();

    @Override
    public void save(Resume resume) {
        storage.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = storage.indexOf(uuid);
        if (index < 0) {
            ExistStorageException(uuid);
        }
        return storage.get(index);
    }

    @Override
    public void update(Resume resume) {

        storage.add(storage.indexOf(resume), resume);
    }

    @Override
    public void delete(String uuid) {
        while (iterator.hasNext()) {
            Resume resume = iterator.next();
            if (resume.getUuid().equals(uuid)) {
                iterator.remove();
            }
        }
    }

}


