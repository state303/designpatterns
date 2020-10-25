package io.dsub.lambda.factory;

import java.util.function.Supplier;

public class PlayWithFactory {
    public static void main(String[] args) {
        CircleFactory factory = () -> new Circle();
        Circle circle = factory.newInstance();
        System.out.println("Circle = " + circle);
    }
}
