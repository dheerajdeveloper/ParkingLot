package com.go.jek.parking.request.model;

import com.go.jek.parking.model.Car;
import com.go.jek.parking.model.ParkingLot;

/**
 * 
 * @author dheeraj
 *
 */

public class ParkRequest extends Request {

	public ParkRequest(String[] strings) {
		/*
		 * park KA-01-HH-1234 White
		 * 
		 */
		car = new Car(strings[1], strings[2]);
	}

	Car car;

	@Override
	public void ProcessRequest() {
		int response = ParkingLot.parkCar(this.car);

		if (response == -1) {
			System.out.println("Sorry, parking lot is full");
			return;
		}

		System.out.println("Allocated slot number: " + response);

	}
}
