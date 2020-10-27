package io.dsub.lambda.factory;

import java.awt.*;
import java.util.List;

public class PlayWithFactory {
    public static void main(String[] args) {
        Factory<Circle> circleFactory = Factory.createFactory(Circle::new, Color.RED);

        // basically the same as () -> new Circle()ck
        Factory<Circle> otherFactory = Factory.createFactory(Circle::new);

        Circle circle = circleFactory.newInstance();
        System.out.println("Circle = " + circle);

        List<Circle> list=  circleFactory.create5Circles();
        System.out.println("list = " + list);

        System.out.println(otherFactory.newInstance());
    }
}
