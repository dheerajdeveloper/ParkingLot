package com.go.jek.parking.model;

/**
 * 
 * @author dheeraj
 *
 */

public class Car {

	public Car(String string, String string2) {
		this.registrationNumber = string;
		this.color = string2;
	}

	String registrationNumber;
	String color;

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber
	 *            the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

}
