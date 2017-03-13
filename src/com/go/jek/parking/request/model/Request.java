package com.go.jek.parking.request.model;

import com.go.jek.parking.enums.RequestType;

/**
 * 
 * @author dheeraj
 *
 */

public abstract class Request {

	RequestType requestType;

	public abstract void ProcessRequest();

}
