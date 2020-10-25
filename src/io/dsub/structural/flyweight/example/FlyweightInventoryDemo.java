package io.dsub.structural.flyweight.example;

public class FlyweightInventoryDemo {
    public static void main(String[] args) {
        InventorySystem ims = new InventorySystem();

        ims.takeOrder("Roomba", 221);
        ims.takeOrder("Bose Headphones", 361);
        ims.takeOrder("Samsung TV", 432);
        ims.takeOrder("Samsung TV", 33);
        ims.takeOrder("Roomba", 563);
        ims.takeOrder("Bose Headphones", 222);
        ims.takeOrder("Roomba", 34);
        ims.takeOrder("Samsung TV", 47567);
        ims.takeOrder("Roomba", 35534);

        ims.process();

        System.out.println(ims.report());
    }
}
