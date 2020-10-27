package io.dsub.command.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// client
public class CommandDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Switch lightSwitch = new Switch();

        Command onCommand = new ToggleCommand(light);

        List<Light> lights = new ArrayList<>();

        IntStream.range(0, 4).forEach(
                i -> lightSwitch.storeAndExecute(onCommand));
    }
}
