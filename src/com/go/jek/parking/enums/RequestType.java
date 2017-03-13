package com.go.jek.parking.enums;

/**
 * 
 * @author dheeraj
 *
 */
public enum RequestType {

	CREATE_PARKING_LOT("create_parking_lot"), PARK("park"), LEAVE("leave"), STATUS(
			"status"), REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR(
					"registration_numbers_for_cars_with_colour"), SLOT_NUMBERS_FOR_CARS_WITH_COLOUR(
							"slot_numbers_for_cars_with_colour"), SLOT_NUMBER_FOR_REGISTRATION_NUMBER(
									"slot_number_for_registration_number");

	String val;

	private RequestType(String s) {
		val = s;
	}

	String getValue() {
		return val;
	}

	public static RequestType get(String s) {
		for (RequestType type : RequestType.values()) {
			if (type.val.equals(s)) {
				return type;
			}
		}

		return null;
	}

}
