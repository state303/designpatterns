package io.dsub.lambda.registry;

import io.dsub.lambda.factory.Factory;

public class PlayWithSwitchRegistry {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        SwitchRegistry registry = new SwitchRegistry();
        Factory<Rectangle> rectangleFactory =
                (Factory<Rectangle>)registry.buildShapeFactory("rectangle");
        System.out.println("Rectangle: " + rectangleFactory.newInstance());
    }
}
