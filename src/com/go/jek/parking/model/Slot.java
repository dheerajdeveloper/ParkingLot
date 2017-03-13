package com.go.jek.parking.model;

public class Slot {

	Integer slotNumber;

	Car car;

	/**
	 * @return the slotNumber
	 */
	public Integer getSlotNumber() {
		return slotNumber;
	}

	/**
	 * @param slotNumber
	 *            the slotNumber to set
	 */
	public void setSlotNumber(Integer slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Slot(Integer slotNumber, Car car) {
		super();
		this.slotNumber = slotNumber;
		this.car = car;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((slotNumber == null) ? 0 : slotNumber.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		if (slotNumber == null) {
			if (other.slotNumber != null)
				return false;
		} else if (!slotNumber.equals(other.slotNumber))
			return false;
		return true;
	}

	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car
	 *            the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}

}
