package com.javops.webapp.model;

import sun.security.pkcs11.wrapper.CK_SSL3_KEY_MAT_OUT;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Contacts {

    private String phone;
    private String skype;
    private String mail;

    public Contacts(String phone, String skype, String mail) {
        this.phone = phone;
        this.skype = skype;
        this.mail = mail;
    }

    public Contacts(String phone, String skype) {
        this.phone = phone;
        this.skype = skype;

    }

    public Contacts(String phone) {
        this.phone = phone;

    }

    public void show() {
        System.out.println(phone);
        System.out.println(skype);
        System.out.println(mail);
    }

    public String getPhone() {
        return phone;
    }

    public String getSkype() {
        return skype;
    }

    public String getMail() {
        return mail;
    }
}