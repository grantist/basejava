package com.javops.webapp.storage;

import com.javops.webapp.Config;
import com.javops.webapp.exception.ExistStorageException;
import com.javops.webapp.exception.NotExistStorageException;
import com.javops.webapp.model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.javops.webapp.storage.TestData.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = Config.get().getStorageDir();

    protected Storage storage;


    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "New Name");
        newResume.addContact(ContactType.MAIL, "mail1@google.com");
        newResume.addContact(ContactType.SKYPE, "NewSkype");
        newResume.addContact(ContactType.MOBILE, "+7 921 222-22-22");
        newResume.addSection(SectionType.PERSONAL, new TextSection("AAAA"));
        newResume.addSection(SectionType.OBJECTIVE, new TextSection("Developer"));
        newResume.addSection(SectionType.ACHIEVEMENT, new ListSection("Q1", "Q2", "Q3"));
        newResume.addSection(SectionType.EDUCATION, new OrganizationSection(
                new Organization("Institute", "www",
                        new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", "www"),
                        new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                new Organization("Organization12", "http://Organization12.ru")));
        newResume.addSection(SectionType.QUALIFICATIONS, new ListSection("F1", "F2", "F3"));
        newResume.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("Organization11", null,
                        new Organization.Position(2005, Month.JANUARY, "position1", null),
                        new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        storage.update(newResume);
        assertTrue(newResume.equals(storage.get(UUID_1)));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        List<Resume> sortedResumes = Arrays.asList(R1, R2, R3);
        Collections.sort(sortedResumes);
        assertEquals(sortedResumes, list);
    }

    @Test
    public void save() throws Exception {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(R1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());


    }
}