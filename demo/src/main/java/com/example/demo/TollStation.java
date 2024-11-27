package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TollStation {
    String name;
    String city;
    int collectedTolls;
    private List<Vehicle> vehicles;

    //Constructores

    public TollStation() {
        this.vehicles = new ArrayList<>();
    }

    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
        this.collectedTolls = 0;
        this.vehicles = new ArrayList<>();
    }

    //getters y setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCollectedTolls() {
        return collectedTolls;
    }

    public void setCollectedTolls(int collectedTolls) {
        this.collectedTolls = collectedTolls;
    }

    //Lista de vehículos que se iran agregando con el registerVehicle
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    //Método para ir regstrando vehículos una vez pasen por el peaje
    public void registerVehicle(Vehicle vehicle) {
        int toll = vehicle.getToll();
        collectedTolls += toll;
        vehicles.add(vehicle);
    }

    // Método para imprimir todo
    public void printSummary() {
        System.out.println("Toll station " + name + " in " + city + ":");
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle: " + vehicle.getLicensePlate() + ", Type: " + vehicle.getClass().getSimpleName() + ", toll: $" + vehicle.getToll());
        }
        System.out.println("Total collected: $" + collectedTolls);
    }


}
