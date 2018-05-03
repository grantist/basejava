package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    void clear();

    Resume get(String uuid);

    Resume[] getAll();

    int size();

    void save(Resume resume);

    void update(Resume resume);

    void delete(String uuid);
}
