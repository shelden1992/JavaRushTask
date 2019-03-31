package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator implements Shape {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    private void setBorderColor(Shape borderColor) {
        System.out.printf("Setting border color for %s to red.", borderColor.getClass().getSimpleName());
    }

    @Override
    public void draw() {
        setBorderColor(super.decoratedShape);
        super.draw();
    }
}
