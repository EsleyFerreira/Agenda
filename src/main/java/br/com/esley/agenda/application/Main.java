package br.com.esley.agenda.application;

import br.com.esley.agenda.dao.ContactDAO;
import br.com.esley.agenda.model.Contacts;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Contacts contacts = new Contacts();
        contacts.setName("Camila Silva");
        contacts.setAge(55);
        contacts.setDataRegister(new Date());

        ContactDAO contactDAO = new ContactDAO();
        contactDAO.save(contacts);
    }
}