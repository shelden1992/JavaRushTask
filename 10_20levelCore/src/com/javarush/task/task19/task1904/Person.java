package com.javarush.task.task19.task1904;

import java.util.Date;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName=middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate=birthDate;
    }

    public Person(String firstName, String middleName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", lastName, firstName, middleName, birthDate.toString());
    }
}
