package io.dsub.behavioral.command.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// client
public class CommandDemo {
    private static final List<Light> lights = new ArrayList<>();

    public static void main(String[] args) {
        Light light = new Light();
        Switch lightSwitch = new Switch();

        Command onCommand = new ToggleCommand(light);
        Command allLightsCommand = new AllLightsCommand(lights);

        IntStream.range(0, 4).forEach(
                i -> lightSwitch.storeAndExecute(onCommand));
    }
}
