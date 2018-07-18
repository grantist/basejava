package com.javops.webapp.model;

import sun.security.pkcs11.wrapper.CK_SSL3_KEY_MAT_OUT;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Contacts {

    private String phone;
    private String mail;
    private String skype;
    private Map<ContactType, String> contacts = new HashMap<>();

    public Contacts(String phone, String mail, String skype) {
        this.phone = phone;
        this.mail = mail;
        this.skype = skype;
        contacts.put(ContactType.MAIL, mail);
        contacts.put(ContactType.PHONE, phone);
        contacts.put(ContactType.Skype, skype);
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getSkype() {
        return skype;
    }

    public void show() {
        for (Map.Entry entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}