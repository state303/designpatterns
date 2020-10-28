package io.dsub.behavioral.mediator.example;
public class Light {

    private final String name;
    private boolean isOn = false;

    public Light(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void toggle() {
        if (isOn) {
            off();
        } else {
            on();
        }
    }

    public void on() {
        isOn = true;
        System.out.println("Light switched on.");
    }

    public void off() {
        isOn = false;
        System.out.println("Light switched off.");
    }

    public String getName() {
        return name;
    }
}
