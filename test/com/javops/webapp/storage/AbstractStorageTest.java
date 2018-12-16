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
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = Config.get().getStorageDir();

    protected Storage storage;

    private static final String UUID_1 = UUID.randomUUID().toString();
    private static final String UUID_2 = UUID.randomUUID().toString();
    private static final String UUID_3 = UUID.randomUUID().toString();
    private static final String UUID_4 = UUID.randomUUID().toString();

    private static final Resume R1;
    private static final Resume R2;
    private static final Resume R3;
    private static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");

        R4.addContact(ContactType.PHONE, "44444");
        R4.addContact(ContactType.SKYPE, "Skype");

        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", null,
                                new Organization.Position(2005, Month.JANUARY, "position1", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", "www",
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", "www"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));

        R2.addContact(ContactType.MAIL, "mail2@ya.ru");
        R2.addContact(ContactType.PHONE, "22222");
        R2.addSection(SectionType.OBJECTIVE, new TextSection("Objective2"));
        R2.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R2.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment21", "Achivment22", "Achivment23"));
        R2.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R2.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization21", "http://Organization22.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content2"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content22"))));
        R2.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", "wwww",
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", "www"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization22", "http://Organization23.ru")));
        R3.addContact(ContactType.MAIL, "mail3@ya.ru");
        R3.addContact(ContactType.PHONE, "33333");
        R3.addSection(SectionType.OBJECTIVE, new TextSection("Objective3"));
        R3.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R3.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment31", "Achivment32", "Achivment33"));
        R3.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R3.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization31", "http://Organization32.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content3"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content33"))));
        R3.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", "nnnn",
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", "hhh"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization31", "www")));
    }


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