package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    View view;
    Provider[] providers;

    public Model(View view, Provider... providers) {

        if (providers == null|| providers.length==0 || view == null) {
            throw new IllegalArgumentException("View or array of providers must be not null");
        }
        this.providers=providers;
        this.view=view;


    }

    public void selectCity(String city) {

//        for (Provider pr:providers
//             ) {
//            if (pr!=null){
//                view.update(pr.getJavaVacancies(city).stream().collect(Collectors.toList()));
//            }
//
//        }


        view.update(Arrays.stream(providers).map(f -> f.getJavaVacancies(city)).flatMap(Collection::stream).collect(Collectors.toList()));
    }
}
