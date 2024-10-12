package br.com.esley.agenda.model;

import java.util.Date;

public class Contacts {
    private int id;
    private String name;
    private int age;
    private Date registrationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDataRegister() {
        return registrationDate;
    }

    public void setDataRegister(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}