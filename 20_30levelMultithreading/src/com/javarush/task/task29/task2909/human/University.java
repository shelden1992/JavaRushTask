package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private List<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public University(String name, int age) {
//        super(name, age, 0);
//    }

    public Student getStudentWithAverageGrade(double midl) {

        for (int i = 0; i <students.size();) {
            if (students.get(i).getAverageGrade() == midl)
                return students.get(i);
            else  i++;

        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double min = 0;
        int index = 0;
        Student student = null;

        for (Student stud:students
             ) {
            if (stud.getAverageGrade()>min){
                min= stud.getAverageGrade();
                student = stud;
            }
            

        }

//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getAverageGrade() > min) {
//                min = students.get(i).getAverageGrade(); // и давай еще запомним его индекс
//                index = i;
//
//
//            }
//            return students.get(index);

//        }
//        return students.get();
        return student;

    }

    //    public void getStudentWithMinAverageGradeAndExpel() {
//        //TODO:
//    }
    public Student getStudentWithMinAverageGrade() {
        double max = Double.MAX_VALUE;
        int index = 0;
        Student stud = null;

        for (Student studen: students
             ) {
           if (studen.getAverageGrade()<max)
           {max= studen.getAverageGrade();
           stud = studen;}


        }
        return stud;

//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getAverageGrade() < max) {
//                max = students.get(i).getAverageGrade(); // и давай еще запомним его индекс
//                index = i;
//
//
//            }
//            return students.get(index);
//
//        }


    }

    public void expel(Student student) {
        students.remove(student);

    }
}