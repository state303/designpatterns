package io.dsub.behavioral.mediator.example;

public class TurnOffAllLightsCommand implements Command {
    private final Mediator mediator;

    public TurnOffAllLightsCommand(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        this.mediator.turnOnAllLights();;
    }
}
