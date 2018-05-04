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

    private List<Resume> list = new ArrayList<>();
    private Iterator<Resume> iterator = list.iterator();

    @Override
    public void save(Resume resume) {
        list.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = list.indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    @Override
    public void update(Resume resume) {

        list.add(list.indexOf(resume), resume);
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


