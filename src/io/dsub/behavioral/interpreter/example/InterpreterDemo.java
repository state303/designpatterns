package io.dsub.behavioral.interpreter.example;

public class InterpreterDemo {
    static Expression buildInterpreterTree() {
        Expression terminal1 = new TerminalExpression("Lions");
        Expression terminal2 = new TerminalExpression("Tigers");
        return new OrExpression(terminal1, terminal2);
    }

    public static void main(String[] args) {
        String context = "Lions";
        Expression define = buildInterpreterTree();
        System.out.println(context + " is " + define.interpret(context));
    }
}
