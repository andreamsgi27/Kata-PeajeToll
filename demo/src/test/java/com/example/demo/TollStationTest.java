package com.example.demo;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TollStationTest {
    
    @Test
	void registerVehicleListIs3Size() {
		List<Vehicle> vehicles = new ArrayList<>();
		Vehicle moto = new Motorbike("MOT-123");
		vehicles.add(moto);
		Vehicle coche = new Car("CAR-123");
		vehicles.add(coche);
		Vehicle camion = new Truck("TRU-123", 4);
		vehicles.add(camion);

		assertThat(vehicles).hasSize(3);
	}

	@Test
	void collectedTollsTotal() {
		TollStation tollStation = new TollStation();
		Vehicle moto = new Motorbike("MOT-123");
		Vehicle coche = new Car("CAR-123");
		Vehicle camion = new Truck("TRU-123", 4);

		tollStation.registerVehicle(camion);
		tollStation.registerVehicle(coche);
		tollStation.registerVehicle(moto);
		assertThat(tollStation.getCollectedTolls()).isEqualTo(350);
	}

	@Test
	void tollStationCollectedtruck(){
		TollStation tollStation = new TollStation();
		Vehicle camion = new Truck("TRU-123", 2);
		tollStation.setName("Peajes Antonio");
		tollStation.setCity("Madrid");
		tollStation.registerVehicle(camion);
		assertThat(tollStation.getCollectedTolls()).isEqualTo(100);
	}

	@Test
	void tollStationCollectedCar(){
		TollStation tollStation = new TollStation();
		Vehicle coche = new Car("CAR-123");
		tollStation.setName("Peajes Antonio");
		tollStation.setCity("Madrid");
		tollStation.registerVehicle(coche);
		assertThat(tollStation.getCollectedTolls()).isEqualTo(100);
	}

	@Test
	void tollStationCollectedMoto(){
		TollStation tollStation = new TollStation();
		Vehicle moto = new Motorbike("MOT-123");
		tollStation.setName("Peajes Antonio");
		tollStation.setCity("Madrid");
		tollStation.registerVehicle(moto);
		assertThat(tollStation.getCollectedTolls()).isEqualTo(50);
	}

	@Test
	void tollStationAtrs(){
		TollStation tollStation = new TollStation();
		tollStation.setName("Peajes Antonio");
		tollStation.setCity("Madrid");
		tollStation.setCollectedTolls(10000);
		assertThat(tollStation.getName()).isEqualTo("Peajes Antonio");
		assertThat(tollStation.getCity()).isEqualTo("Madrid");
		assertThat(tollStation.getCollectedTolls()).isEqualTo(10000);

		Vehicle moto = new Motorbike("MOT-123");
		tollStation.registerVehicle(moto);

		assertThat(tollStation.getCollectedTolls()).isEqualTo(10050);
		assertThat(tollStation.getVehicles()).isEqualTo(List.of(moto));

	}

	@Test
	void tollStationConstructorInitialization() {
    	TollStation tollStation = new TollStation("Peajes Antonio", "Madrid");

    	assertThat(tollStation.getName()).isEqualTo("Peajes Antonio");
    	assertThat(tollStation.getCity()).isEqualTo("Madrid");

    	assertThat(tollStation.getCollectedTolls()).isEqualTo(0);

    	assertThat(tollStation.getVehicles()).isEmpty();
	}

	@Test
	void vehicleGetLicensePlate(){
		Vehicle car = new Car("CAR-123");
        assertThat(car.getLicensePlate()).isEqualTo("CAR-123");
	}

	@Test
	void printSummary(){
		TollStation tollStation = new TollStation("Peajes Antonio", "Madrid");
		Vehicle car = new Car("CAR-123");
		Vehicle moto = new Motorbike("MOT-123");
		tollStation.registerVehicle(car);
		tollStation.registerVehicle(moto);

		String result = tollStation.printSummary();

		assertEquals(result, "Toll station Peajes Antonio in Madrid:\n" +
						"Vehicle: CAR-123, Type: Car, toll: $100\n" +
						"Vehicle: MOT-123, Type: Motorbike, toll: $50\n" +
						"Total collected: $150");


	}




    
}
