package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TRACTEL_RND on 04.05.2018.
 */
public class ListStorage extends AbstractStorage {

    List<Resume> list = new ArrayList<>();

    @Override
    public void save(Resume resume) {
        list.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        return get(uuid);
    }

    @Override
    public void update(Resume resume) {

        list.add(list.indexOf(resume), resume);
    }

    @Override
    public void delete(String uuid) {
        list.remove(uuid);
    }

}


