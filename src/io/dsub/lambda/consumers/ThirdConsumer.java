package io.dsub.lambda.consumers;

import java.util.Objects;

public interface ThirdConsumer<T> {
    void accept(T t);

    default ThirdConsumer<T> andThen(ThirdConsumer<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
