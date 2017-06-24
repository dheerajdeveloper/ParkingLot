package com.go.jek.parking;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
			
			System.out.println("The file path is " +  filepath);
			parkingProcess.processFile(new File(filepath));
		}

	}

	private void processFile(File file) {
		System.out.println("Starting to read file " + file.getAbsolutePath());

		List<String> lines = new ArrayList<String>();
		try {

			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			while (s != null) {
				lines.add(s);
				s = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Exception while reading input file " + file.getAbsolutePath());
		}
		for (String line : lines) {

			String vals[] = line.split(" ");
			RequestType requestType = RequestType.get(vals[0]);

			if (requestType == null) {
				System.out.println(
						"The input request type " + vals[0] + " is not in the list of applicable request types");
				continue;
			}

			System.out.println("Processing line :" + line);

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
