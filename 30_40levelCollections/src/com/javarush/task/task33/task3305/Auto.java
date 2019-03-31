package com.javarush.task.task33.task3305;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
//(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "className"
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property="className")


public abstract class Auto {
    protected String name;
    protected String owner;
    protected int age;
}