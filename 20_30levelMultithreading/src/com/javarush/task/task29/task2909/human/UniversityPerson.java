package com.javarush.task.task29.task2909.human;

public class UniversityPerson extends Human{
    private University university;
    String name;
    int age;

    public UniversityPerson(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }


    public University getUniversity() {

        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
