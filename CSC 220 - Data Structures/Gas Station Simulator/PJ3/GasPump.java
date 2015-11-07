// DO NOT ADD NEW METHODS OR DATA FIELDS!

package PJ3;

class GasPump {

	// start time and end time of current interval
	private int startIntervalTime;
	private int endIntervalTime;

	// pump id and current car which is served by this gas pump
	private int pumpId;
	private Car currentCar;

	// for keeping statistical data
	private int totalFreeTime;
	private int totalBusyTime;
	private int totalCars;

	// Constructor
	GasPump() {
		startIntervalTime = 0;
	}

	// Constructor with gas pump id
	GasPump(int gasPumpId) {
		pumpId = gasPumpId;
	}

	int getPumpId() {
		return pumpId;
	}

	Car getCurrentCar() {
		// add statements
		return currentCar;
	}

	// need this to setup priority queue for Busy pumps

	int getEndIntervalTime() {
		// return end time of busy interval
		// add statements
		return endIntervalTime;
	}

	// State transition : FREE interval -> BUSY interval:
	void switchFreeToBusy(Car currentCar, int currentTime) {
		// Main goal : switch from free interval to busy interval
		//
		// end free interval, start busy interval
		// steps : update totalFreeTime
		// set Busy interval - startIntervalTime , endIntervalTime, currentCar,
		// update totalCars

		// add statements

		endIntervalTime = currentTime;
		totalFreeTime += (endIntervalTime - startIntervalTime);
		startIntervalTime = endIntervalTime;
		endIntervalTime = startIntervalTime + currentCar.getServiceDuration();
		this.currentCar = currentCar;
		totalCars++;

	}

	// State transition : BUSY interval -> FREE interval:
	Car switchBusyToFree() {

		// Main goal : switch from busy interval to free interval
		//
		// end busy interval, start free interval
		// steps : update totalBusyTime
		// set Free interval - startIntervalTime
		// return currentCar

		totalBusyTime += (endIntervalTime - startIntervalTime);
		startIntervalTime = endIntervalTime;

		return currentCar;
	}

	// use this method at the end of simulation to update gas pump data in free
	// and busy queues
	void setEndSimulationTime(int endsimulationtime, int intervalType) {
		// for end of simulation
		// set endIntervalTime to endsimulationtime,
		// for FREE interval, update totalFreeTime
		// for BUSY interval, update totalBusyTime

		endIntervalTime = endsimulationtime;
		if (startIntervalTime >= endIntervalTime) {
			totalFreeTime += (endsimulationtime - startIntervalTime);
		} else {
			totalBusyTime += (endsimulationtime - startIntervalTime);

		}
	}

	// functions for printing statistics :
	void printStatistics() {
		// print gasPump statistics, see project statement

		System.out.println("\t\tGasPump ID           : " + pumpId);
		System.out.println("\t\tTotal free time      : " + totalFreeTime);
		System.out.println("\t\tTotal service time   : " + totalBusyTime);
		System.out.println("\t\tTotal # of cars      : " + totalCars);
		if (totalCars > 0)
			System.out.format("\t\tAverage service time : %.2f%n\n", (totalBusyTime * 1.0) / totalCars);
	}

	public String toString() {
		return "GasPump:" + pumpId + ":" + startIntervalTime + "-" + endIntervalTime + ":Car:" + currentCar;
	}

	public static void main(String[] args) {
		Car mycar = new Car(15, 30, 40);
		GasPump mypump = new GasPump(5);
		mypump.switchFreeToBusy(mycar, 45);
		System.out.println(mypump);

	}

};
