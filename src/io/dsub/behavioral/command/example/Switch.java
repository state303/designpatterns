package io.dsub.behavioral.command.example;

// invoker
public class Switch {

    public void storeAndExecute(Command command) {
        command.execute();
    }

}
