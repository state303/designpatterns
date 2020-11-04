package io.dsub.behavioral.visitor.demo;

public interface AtvPart {
    default void accept(AtvPartVisitor visitor) {
        visitor.visit(this);
    }
}
