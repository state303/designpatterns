package io.dsub.behavioral.visitor.demo;

public interface AtvPartVisitor {
    default <T extends AtvPart> void visit(T item) {

    }
}
