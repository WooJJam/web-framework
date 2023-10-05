package com.example.chap2_2nd.ex3;

import java.util.ArrayList;

public class ContactDAO {
    ArrayList<Contact> clistl;

    public ContactDAO() {
        clistl = new ArrayList<Contact>();
    }

    public void add(Contact contact) {
        clistl.add(contact);
    }

    public ArrayList<Contact> getList() {
        return clistl;
    }
}
