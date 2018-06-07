package com.javops.webapp.storage;

import com.javops.webapp.exception.NotExistStorageException;
import com.javops.webapp.model.Resume;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by TRACTEL_RND on 04.06.2018.
 */
public class AbstractArrayStorageTest {

    public Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";


    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void save() throws Exception {
        String UUID_4 = "uuid4";
        assertEquals(3, storage.size());
        storage.save(new Resume(UUID_4));
        assertEquals(4, storage.size());
    }

    @Test(expected = NullPointerException.class)
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
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void getAll() throws Exception {
        Resume[] expected = new Resume[]{new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        assertArrayEquals(storage.getAll(), expected);
    }

    @Test
    public void update() throws Exception {
        assertEquals(storage.size(), 3);
        storage.update(new Resume(UUID_1));
        assertEquals(storage.size(), 3);
        assertEquals(storage.get(UUID_1), new Resume(UUID_1));
    }

    @Test
    public void get() throws Exception {
        storage.get("uuid1");
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

}