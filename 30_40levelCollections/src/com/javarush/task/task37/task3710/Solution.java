package com.javarush.task.task37.task3710;

import com.javarush.task.task37.task3710.decorators.RedShapeDecorator;
import com.javarush.task.task37.task3710.shapes.Circle;
import com.javarush.task.task37.task3710.shapes.Rectangle;
import com.javarush.task.task37.task3710.shapes.Shape;
import com.javarush.task.task37.task3710.shapes.Square;

/* 
Decorator
*/
public class Solution {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        Shape square  = new RedShapeDecorator(new Square());

        System.out.println("Simple circle");
        circle.draw();

        System.out.println("\nApplied RedShapeDecorator to the circle");
        redCircle.draw();

        System.out.println("\nApplied RedShapeDecorator to the rectangle");
        redRectangle.draw();
    }
}
