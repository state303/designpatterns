package io.dsub.behavioral.mediator.example;

public class MediatorDemo {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Light bedroomLight = new Light("bedroom");
        Light kitchenLight = new Light("kitchen");

        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        Command turnAllLightsCommand = new TurnOnAllLightsCommand(mediator);
        turnAllLightsCommand.execute();

        Command turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);
        turnOffAllLightsCommand.execute();
    }
}
