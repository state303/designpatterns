package io.dsub.lambda.consumers;

@FunctionalInterface
public interface SecondConsumer<T> {
    void accept(T t);

    // we must provide a concrete method if we want extra functionality

    default SecondConsumer<T> andThen(SecondConsumer<T> other) {
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
