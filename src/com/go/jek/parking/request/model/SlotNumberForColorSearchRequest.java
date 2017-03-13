package com.go.jek.parking.request.model;

import com.go.jek.parking.model.ParkingLot;

/**
 * 
 * @author dheeraj
 *
 */

public class SlotNumberForColorSearchRequest extends Request {
	public SlotNumberForColorSearchRequest(String[] strings) {
		this.color = strings[1];
	}

	String color;

	@Override
	public void ProcessRequest() {

		String s = (ParkingLot.findSlotNumberForColorSearchRequest(this.color));

		if (s.isEmpty()) {
			System.out.println("Not found");
		}

		System.out.println(s);
	}

}
