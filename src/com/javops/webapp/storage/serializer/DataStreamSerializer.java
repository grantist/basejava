package com.javops.webapp.storage.serializer;

import com.javops.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            writeCollection(dos, contacts.entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });

            writeCollection(dos, resume.getSections().entrySet(), entry -> {// имя секции
                switch (entry.getKey()) {
                    case PERSONAL:
                    case OBJECTIVE:
                        dos.writeUTF(((TextSection) entry.getValue()).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeCollection(dos, ((ListSection) entry.getValue()).getItems(), dos::writeUTF);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeCollection(dos, ((OrganizationSection) entry.getValue()).getOrganizations(), company -> {
                            dos.writeUTF(company.getHomePage().getName());
                            dos.writeUTF(company.getHomePage().getUrl());
                            writeCollection(dos, company.getPositions(), info -> {
                                writeDate(dos, info.getStartDate());
                                writeDate(dos, info.getEndDate());
                                dos.writeInt(info.getStartDate().getYear());
                                dos.writeInt(info.getStartDate().getMonth().getValue());
                                dos.writeInt(info.getEndDate().getYear());
                                dos.writeInt(info.getEndDate().getMonth().getValue());
                                dos.writeUTF(info.getTitle());
                                dos.writeUTF(info.getDescription());

                            });
                        });
                        break;
                }

            });

        }
    }

    private void writeDate(DataOutputStream dos, LocalDate ld) throws IOException {
        dos.writeInt(ld.getYear());
        dos.writeInt(ld.getMonth().getValue());
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            resume.setContacts(readContacts(dis));
            readCustomCollection(dis, () -> {
                String sectionName = dis.readUTF(); // имя секции
                switch (sectionName) {
                    case "PERSONAL":
                    case "OBJECTIVE":
                        resume.getSections().put(SectionType.valueOf(sectionName), new TextSection(dis.readUTF()));
                        break;
                    case "ACHIEVEMENT":
                    case "QUALIFICATIONS":
                        resume.getSections().put(SectionType.valueOf(sectionName), new ListSection(readList(dis, dis::readUTF)));

                    case "EXPERIENCE":
                    case "EDUCATION":
                        resume.getSections().put(SectionType.valueOf(sectionName), readCompanySection(dis));
                    default:
                        throw new IllegalStateException();
                }
            });
            return resume;
        }
    }

    private OrganizationSection readCompanySection(DataInputStream dis) throws IOException {
        return new OrganizationSection(readList(dis, () ->
                new Organization(new Link(dis.readUTF(), dis.readUTF()),
                        readList(dis, () ->
                                new Organization.Position(dis.readInt(), Month.of(dis.readInt()), dis.readInt(), Month.of(dis.readInt())
                                        , dis.readUTF(), dis.readUTF()))
                )));
    }

    private Map<ContactType, String> readContacts(DataInputStream in) throws IOException {
        Map<ContactType, String> map = new HashMap<>();
        readCustomCollection(in, () -> map.put(ContactType.valueOf(in.readUTF()), in.readUTF()));
        return map;
    }

    interface ItemCustomReader {
        void read() throws IOException;
    }

    interface ItemReader<T> {
        T read() throws IOException;
    }

    interface ItemWriter<T> {
        void write(T t) throws IOException;
    }

    private <T> List<T> readList(DataInputStream in, ItemReader<T> reader) throws IOException {
        int size = in.readInt();
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            list.add((T) reader.read());
        }
        return list;
    }

    private <T> void writeCollection(DataOutputStream out, Collection<T> items, ItemWriter<T> writer) throws IOException {
        out.writeInt(items.size());
        for (T item : items) {
            writer.write(item);
        }
    }

    private void readCustomCollection(DataInputStream in, ItemCustomReader reader) throws IOException {
        int count = in.readInt();
        for (int i = 0; i < count; i++) {
            reader.read();
        }

    }

}