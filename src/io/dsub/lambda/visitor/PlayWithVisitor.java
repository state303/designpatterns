package io.dsub.lambda.visitor;

import java.util.function.Consumer;

public class PlayWithVisitor {
    public static void main(String[] args) {

        // toy classes
        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();

        // we already know the type of class to be performed as we delivered the class.
        Consumer<VisitorBuilder<String>> consumer =
                Visitor.<Car, String>forType(Car.class).execute((Car c) -> "Visiting car: " + c)
                        .forType(Engine.class).execute(e -> "Visiting engine: " + e)
                        .forType(Body.class).execute(b -> "Visiting body: " + b);

        Visitor<String> visitor = Visitor.of(consumer);

        String visitedCar = visitor.visit(car);
        System.out.println(visitedCar);
        String visitedEngine = visitor.visit(engine);
        System.out.println(visitedEngine);
        String visitedBody = visitor.visit(body);
        System.out.println(visitedBody);

        String expect = visitor.visit(null);
//        visitor.visit(body);

    }
}
