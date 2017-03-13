package com.go.jek.parking.request.model;

import com.go.jek.parking.model.ParkingLot;

/**
 * 
 * @author dheeraj
 *
 */

public class RegistrationNumberForColorSearchRequest extends Request {
	public RegistrationNumberForColorSearchRequest(String[] strings) {
		this.color = strings[1];
	}

	String color;

	@Override
	public void ProcessRequest() {

		String s = (ParkingLot.getRegistrationNumberForColorSearchRequest(this.color));

		if (s.isEmpty()) {
			System.out.println("Not found");
		}

		System.out.println(s);
	}

}
