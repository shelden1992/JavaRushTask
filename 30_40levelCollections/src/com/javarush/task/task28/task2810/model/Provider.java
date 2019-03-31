package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

public class Provider {  //контекст
    private Strategy strategy;


 public List<Vacancy> getJavaVacancies(String searchString){
     return strategy.getVacancies(searchString);
 }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy=strategy;
    }

    public Provider(Strategy strategy) {
        this.strategy=strategy;
    }
}
