package io.dsub.lambda.factory;

import java.awt.*;
import java.util.List;

public class PlayWithFactory {
    public static void main(String[] args) {
        Factory<Circle> factory1 = Factory.createFactory(Circle::new, Color.RED);
        Factory<Circle> factory2 = Factory.createFactory(Circle::new);

        Circle circle = factory1.newInstance();
        System.out.println("Circle = " + circle);

        List<Circle> list=  factory1.create5Circles();
        System.out.println("list = " + list);
    }
}
