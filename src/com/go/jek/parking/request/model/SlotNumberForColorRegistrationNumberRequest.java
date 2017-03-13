package com.go.jek.parking.request.model;

import com.go.jek.parking.model.ParkingLot;

/**
 * 
 * @author dheeraj
 *
 */

public class SlotNumberForColorRegistrationNumberRequest extends Request {
	public SlotNumberForColorRegistrationNumberRequest(String[] strings) {

		this.color = strings[1];
	}

	String color;

	@Override
	public void ProcessRequest() {

		String s = (ParkingLot.findSlotNumberForColorRegistrationNumberRequest(this.color));

		if (s.isEmpty()) {
			System.out.println("Not found");
		}

		System.out.println(s);

	}

}
