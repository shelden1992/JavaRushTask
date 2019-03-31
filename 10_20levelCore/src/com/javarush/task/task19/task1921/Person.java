package com.javarush.task.task19.task1921;

import java.util.Date;

public class Person {
    private String name;
    private Date birthDate;

    public void setName(String name) {
        this.name=name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate=birthDate;
    }

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
