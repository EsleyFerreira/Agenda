package br.com.esley.agenda.application;

import br.com.esley.agenda.dao.ContactDAO;
import br.com.esley.agenda.model.Contacts;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ContactDAO contactDAO = new ContactDAO();
        Contacts contacts = new Contacts();

        contacts.setName("João Pedro Almeida");
        contacts.setAge(55);
        contacts.setDataRegister(new Date());

//        contactDAO.save(contacts);

        // Atualizar
        Contacts c1 = new Contacts();
        c1.setName("João Pedro Almeida Silva");
        c1.setId(58);
        c1.setDataRegister(new Date());
        c1.setId(1);

//        contactDAO.update(c1);

        contactDAO.deleteByID(1);

        for(Contacts c : contactDAO.getContacts()){
            System.out.println("Contato: " + c.getName());
        }
    }
}