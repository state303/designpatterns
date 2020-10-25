package io.dsub.structural.bridge.example1;

public class Shape2BridgeDemo {
    public static void main(String[] args) {
        Color blue = new Blue();
        Shape square = new Square(blue);

        Color red = new Red();
        Shape circle = new Circle(red);

        square.applyColor();
        circle.applyColor();

        Shape greenSquare = new Square(new Green());
        greenSquare.applyColor();
    }
}
