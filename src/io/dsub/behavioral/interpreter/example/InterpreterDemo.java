package io.dsub.behavioral.interpreter.example;

public class InterpreterDemo {
    static Expression buildInterpreterTree() {
        Expression terminal1 = null;

        return terminal1;
    }

    public static void main(String[] args) {
        String context = "Lions";
        Expression define = buildInterpreterTree();
        System.out.println(context + " is " + define.interpret(context));
    }
}
