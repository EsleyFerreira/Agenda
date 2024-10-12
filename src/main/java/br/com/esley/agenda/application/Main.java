package br.com.esley.agenda.application;

import br.com.esley.agenda.dao.ContactDAO;
import br.com.esley.agenda.model.Contacts;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ContactDAO contactDAO = new ContactDAO();
        Contacts contacts = new Contacts();

        contacts.setName("Eduardo Silva");
        contacts.setAge(55);
        contacts.setDataRegister(new Date());

        contactDAO.save(contacts);

        for(Contacts c : contactDAO.getContacts()){
            System.out.println("Contato: " + c.getName());
        }
    }
}