package io.dsub.lambda.visitor;

import java.util.function.Function;

public interface VisitorBuilder<R> {
    // takes the type to visit, and function to be operated.
    // T = incoming type, R = returning type.
    <T> void register(Class<T> type, Function<T, R> function);
}
