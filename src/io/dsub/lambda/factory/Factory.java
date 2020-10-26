package io.dsub.lambda.factory;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * As Supplier interface comes from JDK, we cannot directly modify it.
 * Instead, we extend it then add desired functionality into it.
 */
@FunctionalInterface
public interface Factory<T> extends Supplier<T> {

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    static <T, R> Factory<T> createFactory(Function<R, T> constructor, R r) {
        return () -> constructor.apply(r);
    }

    default T newInstance() {
        return get();
    }

    default List<T> create5Circles() {
        return IntStream.range(0, 5)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    }
}