package com.go.jek.parking;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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

		} else {
			String filepath = args[0];
			parkingProcess.processFile(new File(filepath));
		}

	}

	private void processFile(File file) {

		List<String> lines = new ArrayList<String>();
		for (String line : lines) {
			String vals[] = line.split(",");
			RequestType requestType = RequestType.get(vals[0]);

			if (requestType == null) {
				System.out.println(
						"The input request type " + vals[0] + " is not in the list of applicable request types");
			}

			processLine(line);
		}
	}

	private void startInteractiveProcess() {
		System.out.println("Input args are empty. Initializing interactive shell");

		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		while (true) {
			if (line != null && !line.isEmpty()) {
				if (line.equals("EXIT")) {
					System.out.println("Stopping the process.");
					scanner.close();

					return;
				}

				processLine(line);

			}
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
