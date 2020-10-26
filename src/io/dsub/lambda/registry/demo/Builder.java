package io.dsub.lambda.registry.demo;

import io.dsub.lambda.factory.Factory;

@FunctionalInterface
public interface Builder<T> {
    void register(String label, Factory<T> factory);
}
