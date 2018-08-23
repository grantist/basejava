package com.javops.webapp.storage;

import com.javops.webapp.exception.ExistStorageException;
import com.javops.webapp.exception.NotExistStorageException;
import com.javops.webapp.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by TRACTEL_RND on 04.06.2018.
 */
public abstract class AbstractStorageTest {

    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final Resume R1;
    private static final Resume R2;
    private static final Resume R3;


    static {
        LocalDate start = LocalDate.of(2017, Month.NOVEMBER, 30);
        LocalDate end = LocalDate.of(2019, Month.NOVEMBER, 30);

        LocalDate start1 = LocalDate.of(3020, Month.NOVEMBER, 15);
        LocalDate end1 = LocalDate.of(3000, Month.NOVEMBER, 15);

        //Filling Resume 1
        R1 = new Resume(UUID_1, "Name1");
        R1.addContact(ContactType.MAIL, "yandex@ya.ru");
        R1.addContact(ContactType.PHONE, "894568899922");
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective"));
        R1.addSection(SectionType.PERSONAL, new TextSection("Personal"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("A1", "A2", "A3"));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection("C++", "C#", "Java"));
        R1.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("YANDEX", "www.yandex.ru",
                        new Organization.Position(start1, end1, "Pos1", "Job1"))));

        R1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", "www.yyy.ru",
                                new Organization.Position(start, end, "Pos2", "Job2"), new Organization.Position(start, end, "pppp", "dddddd"))));
        //Filling Resume 2
        R2 = new Resume(UUID_2, "Name2");
        R2.addContact(ContactType.MAIL, "mail@ya.ru");
        R2.addContact(ContactType.PHONE, "8568899922");
        R2.addSection(SectionType.OBJECTIVE, new TextSection("Objective"));
        R2.addSection(SectionType.PERSONAL, new TextSection("Personal"));
        R2.addSection(SectionType.ACHIEVEMENT, new ListSection("B1", "B2", "B3"));
        R2.addSection(SectionType.QUALIFICATIONS, new ListSection("C++++", "C###", "Java"));
        R2.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("GOOGLE", "www.google.ru",
                        new Organization.Position(start1, end1, "Pos2", "Job2"))));

        R2.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Univercity", "www.bbb.ru",
                                new Organization.Position(start, end, "Pos2", "Job2"), new Organization.Position(start, end, "Doctor", "Treating"))));

//Filling Resume 3
        R3 = new Resume(UUID_3, "Name3");
        R3.addContact(ContactType.MAIL, "yahoo@ya.ru");
        R3.addContact(ContactType.PHONE, "68899922");
        R3.addSection(SectionType.OBJECTIVE, new TextSection("Objective"));
        R3.addSection(SectionType.PERSONAL, new TextSection("Personal"));

        R3.addSection(SectionType.ACHIEVEMENT, new ListSection("C1", "C2", "C3"));
        R3.addSection(SectionType.QUALIFICATIONS, new ListSection("SQL", "Scala", "Kotlin"));
        R3.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("Microsoft", "www.mm.ru",
                        new Organization.Position(start1, end1, "Pos3", "Job3"))));
        R3.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("MGU", "www.mgu.ru",
                                new Organization.Position(start, end, "Pos3", "Job3"), new Organization.Position(start, end, "Bachelor", "Teaching"))));
    }

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1, "A"));
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
        assertEquals(list, Arrays.asList(new Resume(UUID_1, "A"), new Resume(UUID_2, "B"), new Resume(UUID_3, "C")));
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