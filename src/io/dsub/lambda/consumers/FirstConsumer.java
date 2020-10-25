package io.dsub.lambda.consumers;

public interface FirstConsumer<T> {
    void accept(T t);
}
