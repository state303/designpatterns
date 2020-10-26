package io.dsub.lambda.registry.demo;

import io.dsub.lambda.factory.Factory;
import io.dsub.lambda.registry.Rectangle;
import io.dsub.lambda.registry.Shape;
import io.dsub.lambda.registry.Square;
import io.dsub.lambda.registry.Triangle;

import java.util.function.Consumer;

public class PlayWithRegistryBuilder {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Consumer<Builder<Shape>> consumer1 =
                builder -> builder.register("rectangle", Rectangle::new); // just a registration
        Consumer<Builder<Shape>> consumer2 =
                builder -> builder.register("triangle", Triangle::new); // just a registration
        Consumer<Builder<Shape>> consumer3 =
                builder -> builder.register("square", Square::new);

        Consumer<Builder<Shape>> initializer = consumer1.andThen(consumer2).andThen(consumer3);

        Registry<Shape> registry = Registry.createRegistry(initializer, s -> {
            throw new IllegalArgumentException("Unknown shape " + s);
        });

        Factory<Rectangle> buildRectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        Rectangle rectangle = buildRectangleFactory.newInstance();

        Factory<Triangle> buildTriangleFactory = (Factory<Triangle>) registry.buildShapeFactory("triangle");
        Triangle triangle = buildTriangleFactory.newInstance();

        Factory<Square> buildSquareFactory = (Factory<Square>) registry.buildShapeFactory("square");
        Square square = buildSquareFactory.newInstance();

        System.out.println("Rectangle = " + rectangle);
        System.out.println("Triangle = " + triangle);
        System.out.println("Square = " + square);
    }
}
