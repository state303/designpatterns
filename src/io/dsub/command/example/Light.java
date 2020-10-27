package io.dsub.command.example;

// receiver
public class Light {

    private boolean isOn = false;

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

}
