package com.example.demo;

public class Truck extends Vehicle {
    private int axles;

    public Truck(String licensePlate, int axles) {
        super(licensePlate);
        this.axles = axles;
    }

    @Override
    public int getToll() {
        return 50 * axles; // Peaje calculado en función del número de ejes
    }
}