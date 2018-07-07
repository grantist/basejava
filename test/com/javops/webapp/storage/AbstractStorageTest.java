package com.javops.webapp.storage;

import com.javops.webapp.exception.ExistStorageException;
import com.javops.webapp.exception.NotExistStorageException;
import com.javops.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by TRACTEL_RND on 04.06.2018.
 */
public abstract class AbstractStorageTest {

    public Storage storage;

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";


    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1, "A"));
        storage.save(new Resume(UUID_2, "B"));
        storage.save(new Resume(UUID_3, "C"));
    }

    @Test
    public void save() throws Exception {
        String UUID_4 = "uuid4";
        assertEquals(3, storage.size());
        storage.save(new Resume(UUID_4));
        assertEquals(4, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        assertEquals(storage.size(), 3);
        storage.delete(UUID_1);
        assertEquals(storage.size(), 2);
        storage.get(UUID_1);

    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(list, Arrays.asList(new Resume(UUID_1, "A"), new Resume(UUID_2, "B"), new Resume(UUID_3, "B")));
    }


    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "D");
        storage.update(newResume);
        assertTrue(newResume == storage.get(UUID_1));
    }

    @Test
    public void get() throws Exception {
        assertEquals(new Resume(UUID_1, "A"), storage.get(new Resume(UUID_1, "A").getUuid()));
        assertEquals(new Resume(UUID_2, "B"), storage.get(new Resume(UUID_2, "B").getUuid()));
        assertEquals(new Resume(UUID_3, "C"), storage.get(new Resume(UUID_3, "C").getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = ExistStorageException.class)
    public void ExistException() throws Exception {
        storage.save(new Resume(UUID_3, "D"));
    }

}