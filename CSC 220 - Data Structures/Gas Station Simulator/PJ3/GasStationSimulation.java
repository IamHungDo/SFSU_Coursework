package PJ3;

import java.util.*;
import java.io.*;

// You may add new functions or data in this class 
// You may modify any functions or data members here
// You must use Car, GasPump and GasStation
// to implement your simulator

class GasStationSimulation {

	// input parameters
	private int numGasPumps, carQLimitation;
	private int simulationTime, dataSource;
	private int chancesOfArrival, maxDuration;

	// statistical data
	private int numGoAway, numServed, totalWaitingTime, totalArrival;

	// internal data
	private int carIdCounter;
	private GasStation gasStationObj; // Gas station object
	private Scanner dataFile; // get car data from file
	private Random dataRandom; // get car data using random function
	private Car somecar;
	private GasPump someGP;
	Scanner sc = new Scanner(System.in);
	// most recent car arrival info, see getCarData()
	private boolean anyNewArrival;
	private int serviceDuration;

	// initialize data fields
	private GasStationSimulation() {
		// add statements
		simulationTime = 0;
	}

	private void getUserParameters() {
		System.out.println("Enter maximum simulation time");
		simulationTime = sc.nextInt();
		System.out.println("Enter max duration of car service");
		maxDuration = sc.nextInt();
		System.out.println("Enter the chances of a new car");
		chancesOfArrival = sc.nextInt();
		System.out.println("Enter number of gas pumps");
		numGasPumps = sc.nextInt();
		System.out.println("Enter car queue size limit");
		carQLimitation = sc.nextInt();
		System.out.println(
				"Would you like to get car data from a file or random number generator? Choose 1 for File or 0 for the generator");
		dataSource = sc.nextInt();

		if (dataSource == 1) {
			try {
				System.out.println("Type the file name:");
				String fileInput = sc.next();
				File fileData = new File(fileInput);
				dataFile = new Scanner(fileData);
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
			}

		}
		// read input parameters from user
		// setup dataFile or dataRandom
		// add statements
	}

	// this method is called for each unit simulation time
	private void getCarData() {
		if (dataSource == 1) {
			if (dataFile.hasNext()) {
				int a = Integer.parseInt(dataFile.next());
				int b = Integer.parseInt(dataFile.next());
				anyNewArrival = (((a % 100) + 1) <= chancesOfArrival);
				serviceDuration = (b % maxDuration) + 1;
			}

		} else {
			dataRandom = new Random();
			anyNewArrival = ((dataRandom.nextInt(100) + 1) <= chancesOfArrival);
			serviceDuration = dataRandom.nextInt(maxDuration) + 1;

		}

		// get next car data : from file or random number generator
		// set anyNewArrival and serviceDuration
		// add statements
	}

	private void doSimulation() {
		// add statements
		gasStationObj = new GasStation(numGasPumps, carQLimitation, 1);

		// Initialize GasStation

		// Time driver simulation loop
		for (int currentTime = 0; currentTime < simulationTime; currentTime++) {

			// Step 1: any new car enters the gas station?
			getCarData();

			// Step 1.1: setup car data
			if (anyNewArrival) {
				if (gasStationObj.isCarQTooLong()) {
					numGoAway++;
					System.out.println("Car leaves because the queue was too long.");
				} else {
					somecar = new Car(carIdCounter, serviceDuration, currentTime);
					totalArrival++;
					gasStationObj.insertCarQ(somecar);
					System.out.println("Car " + totalArrival + " has arrived!");
					// Step 1.2: check car waiting queue too long?
				}
			} else {
				System.out.println("\tNo new car!");
			}

			// Step 2: free busy pumps, add to free pumpQ
			if (!gasStationObj.emptyBusyGasPumpQ()) {
				if (currentTime >= gasStationObj.getFrontBusyGasPumpQ().getEndIntervalTime()) {
					if (gasStationObj.numFreeGasPumps() < numGasPumps) {
						GasPump btp = gasStationObj.removeBusyGasPumpQ();
						Car tempcar = btp.switchBusyToFree();
						gasStationObj.insertFreeGasPumpQ(btp);
					}
				}
			}
			// Step 3: get free pumps to serve waiting cars
			if (gasStationObj.numFreeGasPumps() != 0 && !gasStationObj.emptyCarQ()) {
				GasPump fp = gasStationObj.removeFreeGasPumpQ();
				Car tempscar = gasStationObj.removeCarQ();
				gasStationObj.insertBusyGasPumpQ(fp);
				fp.switchFreeToBusy(tempscar, currentTime);
				numServed++;
			}

			if (anyNewArrival) {
				carIdCounter++;
			}
			if (!gasStationObj.emptyCarQ()) {
				totalWaitingTime++;
			}

		}
	} // end simulation loop

	// clean-up

	private void printStatistics() {
		// add statements into this method!
		System.out.println("****End of simulation report****");
		System.out.println("\t" + " have arrived         :" + totalArrival);
		System.out.println("\t" + " have gone away       :" + numGoAway);
		System.out.println("\t" + " have been served     :" + numServed);
		System.out.println("****Current gaspump info****");
		;
		gasStationObj.printStatistics();

		System.out.println("\tTotal waiting time      : " + totalWaitingTime);
		System.out.println("\tAverage waiting time    : " + (totalWaitingTime / numServed));

		System.out.println("****Busy Gas Pump info****");
		while (!gasStationObj.emptyBusyGasPumpQ()) {
			GasPump tempgas = gasStationObj.removeBusyGasPumpQ();
			tempgas.printStatistics();
		}
		System.out.println("****Free Gas Pump Info****");
		while (!gasStationObj.emptyFreeGasPumpQ()) {
			GasPump tempgas1 = gasStationObj.removeFreeGasPumpQ();
			tempgas1.printStatistics();
		}
		// print out simulation results
		// see the given example in project statement
		// you need to display all free and busy tellers

	}

	// *** main method to run simulation ****
	public static void main(String[] args) {
		GasStationSimulation gas_station_simulation = new GasStationSimulation();
		gas_station_simulation.getUserParameters();
		gas_station_simulation.doSimulation();
		gas_station_simulation.printStatistics();
	}

}
