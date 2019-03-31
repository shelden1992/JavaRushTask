package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class GreenShareDecorator extends ShapeDecorator implements Shape{
    public GreenShareDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }


    public void setColor (Shape shape){
        System.out.printf("green color for %s", shape.getClass().getSimpleName());


    }

    @Override
    public void draw() {
        setColor(super.decoratedShape);
        super.draw();
    }
}
