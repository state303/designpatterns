package io.dsub.lambda.registry;

import io.dsub.lambda.factory.Factory;

public class SwitchRegistry {
    public Factory<? extends Shape> buildShapeFactory(String shape) {
        switch (shape) {
            case "square" : return Square::new;
            case "triangle" : return Triangle::new;
            case "rectangle" : return Rectangle::new;
            default:
                throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }
}
