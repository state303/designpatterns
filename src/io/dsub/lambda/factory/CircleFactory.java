package io.dsub.lambda.factory;

import java.util.function.Supplier;

/**
 * As Supplier interface comes from JDK, we cannot directly modify it.
 * Instead, we extend it then add desired functionality into it.
 */
@FunctionalInterface
public interface CircleFactory extends Supplier<Circle> {
    default Circle newInstance() {
        return get();
    }
}
