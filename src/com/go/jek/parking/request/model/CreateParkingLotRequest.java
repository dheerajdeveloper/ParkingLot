package com.go.jek.parking.request.model;

import com.go.jek.parking.model.ParkingLot;

/**
 * 
 * @author dheeraj
 *
 */
public class CreateParkingLotRequest extends Request {

	Integer numberOfSlots;

	public CreateParkingLotRequest(String[] strings) {
		/**
		 * create_parking_lot 6
		 * 
		 */
		numberOfSlots = Integer.parseInt(strings[1]);
	}

	/**
	 * @return the numberOfSlots
	 */
	public Integer getNumberOfSlots() {
		return numberOfSlots;
	}

	/**
	 * @param numberOfSlots
	 *            the numberOfSlots to set
	 */
	public void setNumberOfSlots(Integer numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}

	@Override
	public void ProcessRequest() {
		int res = ParkingLot.initializeParkingSlot(this);
		if (res == 0) {
			System.out.println("Created a parking lot with " + this.numberOfSlots + " slots");
		}
	}

}
