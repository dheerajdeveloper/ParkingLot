package com.go.jek.parking.request.model;

import java.util.List;

import com.go.jek.parking.model.ParkingLot;

public class StatusRequest extends Request {

	public StatusRequest(String[] strings) {
	}

	@Override
	public void ProcessRequest() {
		List<String> statusList = ParkingLot.getStatus();
		for(String s : statusList){
			System.out.println(s);
		}
	}

}
