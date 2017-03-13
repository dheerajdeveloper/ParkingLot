package com.go.jek.parking;

import java.util.Scanner;

import com.go.jek.parking.enums.RequestType;
import com.go.jek.parking.request.model.Request;
import com.go.jek.parking.request.model.RequestFactory;

/**
 * 
 * @author dheeraj
 *
 */

public class ParkingProcess {

	public static void main(String[] args) {

		ParkingProcess parkingProcess = new ParkingProcess();
		if (args == null || args.length == 0) {
			parkingProcess.startInteractiveProcess();

		}

		RequestType requestType = RequestType.get(args[0]);

		if (requestType == null) {
			System.out.println("The input request type " + args[0] + " is not in the list of applicable request types");
		}

	}

	private void startInteractiveProcess() {
		System.out.println("Input args are empty. Initializing interactive shell");

		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		while (true) {
			if (line == null || line.isEmpty() || line.equals("EXIT")) {
				System.out.println("Stopping the process.");
				scanner.close();

				return;
			}

			processLine(line);

			line = scanner.nextLine();
		}

	}

	private void processLine(String line) {
		String vals[] = line.split(" ");

		RequestType requestType = RequestType.get(vals[0]);
		if (requestType == null) {
			System.out.println("The input request type " + vals[0] + " is not in the list of applicable request types");
			return;
		}

		Request request = RequestFactory.get(requestType, line.split(" "));
		request.ProcessRequest();

	}

}
