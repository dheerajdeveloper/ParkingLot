package com.go.jek.parking.request.model;

import com.go.jek.parking.model.ParkingLot;

/**
 * 
 * @author dheeraj
 *
 */

public class LeaveRequest extends Request {

	public LeaveRequest(String[] strings) {
		this.slotNumber = Integer.parseInt(strings[1]);
	}

	Integer slotNumber;

	@Override
	public void ProcessRequest() {

		ParkingLot.leaveCar(this.slotNumber);
		System.out.println("Slot number : " + this.slotNumber + " is empty.");

	}

}
