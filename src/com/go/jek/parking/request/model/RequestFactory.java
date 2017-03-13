package com.go.jek.parking.request.model;

import com.go.jek.parking.enums.RequestType;

/**
 * 
 * @author dheeraj
 *
 */
public class RequestFactory {

	public static Request get(RequestType requestType, String[] strings) {
		switch (requestType) {
		case CREATE_PARKING_LOT:
			return new CreateParkingLotRequest(strings);
		case LEAVE:
			return new LeaveRequest(strings);
		case PARK:
			return new ParkRequest(strings);
		case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
			return new RegistrationNumberForColorSearchRequest(strings);
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			return new SlotNumberForColorRegistrationNumberRequest(strings);
		case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
			return new SlotNumberForColorSearchRequest(strings);
		case STATUS:
			return new StatusRequest(strings);

		}

		return null;
	}

}
