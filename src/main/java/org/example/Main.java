package org.example;

class HotDrink {
    private String name;
    private int volume;

    public HotDrink(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}

class HotBeverage extends HotDrink {
    private int temperature;

    public HotBeverage(String name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

interface VendingMachine {
    HotDrink getProduct(String name, int volume);
    HotBeverage getProduct(String name, int volume, int temperature);
}

class HotBeverageMachine implements VendingMachine {
    public HotDrink getProduct(String name, int volume) {
        return new HotDrink(name, volume);
    }
    public HotBeverage getProduct(String name, int volume, int temperature) {
        return new HotBeverage(name, volume, temperature);
    }
}

public class Main {
    public static void main(String[] args) {
        HotDrink tea = new HotDrink("Tea", 200);
        HotBeverage coffee = new HotBeverage("Coffee", 250, 80);
        HotBeverageMachine vendingMachine = new HotBeverageMachine();

        HotDrink product1 = vendingMachine.getProduct("Tea", 200);
        HotBeverage product2 = vendingMachine.getProduct("Coffee", 250, 80);

        System.out.println(product1.getName()); //tea
        System.out.println(product1.getVolume());

        System.out.println(product2.getName()); //coffee
        System.out.println(product2.getVolume());
        System.out.println(product2.getTemperature());
    }
}