package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Moped slowRide = new Moped();
        slowRide.setColor("Red");
        slowRide.setFuelCapacity(5);


        Car car = new Car();
        car.setFuelCapacity(45);
        car.setColor("blue");

        SemiTruck semiTruck = new SemiTruck();
        semiTruck.setColor("Black");
        semiTruck.setCargoCapacity(134234);

        Hovercraft hovercraft = new Hovercraft();
        hovercraft.setColor("white");
        hovercraft.setModel("x5");


    }
}
