package com.example.demo;

public class Motorbike extends Vehicle {
    public Motorbike(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public int getToll() {
        return 50; // Peaje fijo para motos
    }
}