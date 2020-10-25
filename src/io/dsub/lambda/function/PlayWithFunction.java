package io.dsub.lambda.function;

public class PlayWithFunction {
    public static void main(String[] args) {
        Function<Meteor, Integer> readCelsius = Meteor::getTemperature;
        Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d/5d + 32d;

        Function<Meteor, Double> readFahrenheit = readCelsius.andThen(celsiusToFahrenheit);

        double result = readFahrenheit.apply(new Meteor());
        System.out.println(result);

        readFahrenheit = celsiusToFahrenheit.compose(readCelsius);
        System.out.println("Meteor is: " + readFahrenheit.apply(new Meteor()));

        Function<String, String> identity = Function.identity();

        String s = "Hello";
        System.out.println(System.identityHashCode(s) + " and " + System.identityHashCode(identity.apply(s)));
    }
}
