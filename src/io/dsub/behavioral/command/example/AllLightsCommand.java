package io.dsub.behavioral.command.example;

import java.util.List;

public class AllLightsCommand implements Command {

    private final List<Light> lights;

    public AllLightsCommand(List<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.forEach(light -> {
            if (light.isOn()) {
                light.toggle();
            }
        });
    }
}
