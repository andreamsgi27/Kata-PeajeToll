package com.example.demo;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public int getToll() {
        return 100; // Peaje fijo para coches
    }
}
