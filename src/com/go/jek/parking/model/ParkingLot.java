package com.go.jek.parking.model;

import java.util.ArrayList;
import java.util.List;

import com.go.jek.parking.request.model.CreateParkingLotRequest;

/**
 * 
 * @author dheeraj
 *
 */
public class ParkingLot {

	/**
	 * 
	 */
	private static Slot parkingLots[] = null;

	/**
	 * 
	 * @param createParkingLotRequest
	 */
	public static int initializeParkingSlot(CreateParkingLotRequest createParkingLotRequest) {

		if (parkingLots != null) {
			System.out.println("Parking lot is already created");
			return -1;
		}
		parkingLots = new Slot[createParkingLotRequest.getNumberOfSlots() + 1];
		for (int i = 1; i < parkingLots.length; i++) {
			parkingLots[i] = null;
		}

		return 0;

	}

	/**
	 * 
	 * @param car
	 * @return
	 */
	public static int parkCar(Car car) {

		for (int i = 1; i < parkingLots.length; i++) {

			Integer slotNumber = i;
			if (parkingLots[slotNumber] == null) {
				Slot slot = new Slot(slotNumber, car);
				parkingLots[i] = slot;
				return i;
			}
		}

		return -1;

	}

	/**
	 * 
	 * @param slotNumber
	 * @return
	 */
	public static int leaveCar(Integer slotNumber) {
		if (parkingLots[slotNumber] == null) {
			return -1;
		}
		parkingLots[slotNumber] = null;
		return 0;
	}

	/**
	 * 
	 * @param color
	 * @return
	 */
	public static String getRegistrationNumberForColorSearchRequest(String color) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i < parkingLots.length; i++) {
			if (parkingLots[i] != null && parkingLots[i].getCar().getColor().equals(color)) {
				sb.append(parkingLots[i].getCar().getRegistrationNumber()).append(",");
			}
		}

		return sb.toString();
	}

	/**
	 * 
	 * @param color
	 * @return
	 */
	public static String findSlotNumberForColorRegistrationNumberRequest(String registrationNumber) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i < parkingLots.length; i++) {
			if (parkingLots[i] != null && parkingLots[i].getCar().getRegistrationNumber().equals(registrationNumber)) {
				sb.append(new Integer(i).toString()).append(",");
			}
		}

		return sb.toString();
	}

	public static String findSlotNumberForColorSearchRequest(String color) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i < parkingLots.length; i++) {
			if (parkingLots[i] != null && parkingLots[i].getCar().getColor().equals(color)) {
				sb.append(new Integer(i).toString()).append(",");
			}
		}

		return sb.toString();
	}

	public static List<String> getStatus() {
		List<String> statusList = new ArrayList<String>();

		statusList.add("No,Registration Slot No.,Colour");

		for (int i = 1; i < parkingLots.length; i++) {

			if (parkingLots[i] != null) {
				StringBuilder sb = new StringBuilder("");

				sb.append(new Integer(i).toString()).append(",").append(parkingLots[i].getCar().getRegistrationNumber())
						.append(",").append(parkingLots[i].getCar().getColor()).append(",");
				statusList.add(sb.toString());
			}
		}

		return statusList;
	}

}
