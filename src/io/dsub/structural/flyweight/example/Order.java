package io.dsub.structural.flyweight.example;

public class Order {
    private final int orderNumber;
    private final Item item;

    public Order(int orderNumber, Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    }

    // this is where the actual processing happens.
    // in real life code, we may take much complex implementation within this part.
    void processOrder() {
        System.out.println("Processing " + orderNumber + "(" + item + ")");
    }
}
