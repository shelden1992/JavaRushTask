package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

public interface Strategy {  //Он будет отвечать за получение данных с сайта.
    // Будет какой-то метод/ы для получения данных с сайта
    public   List<Vacancy> getVacancies(String searchString);
}
