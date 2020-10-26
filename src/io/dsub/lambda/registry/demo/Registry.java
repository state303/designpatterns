package io.dsub.lambda.registry.demo;

import io.dsub.lambda.factory.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Registry<T> {
    Factory<? extends T> buildShapeFactory(String shape);

    static <T> Registry<T> createRegistry(
            Consumer<Builder<T>> consumer, Function<String, Factory<T>> errFunc) {

        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder = map::put;
        consumer.accept(builder);

        return shape -> map.computeIfAbsent(shape, errFunc);
    }
}
