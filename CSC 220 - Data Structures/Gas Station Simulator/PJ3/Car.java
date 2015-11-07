// DO NOT ADD NEW METHODS OR DATA FIELDS!

package PJ3;

class Car {
	private int carId;
	private int serviceDuration;
	private int arrivalTime;

	Car() {
		carId = 0;
		serviceDuration = 0;
		arrivalTime = 0;
	}

	Car(int CID, int serviceTime, int arriveTime) {
		carId = CID;
		serviceDuration = serviceTime;
		arrivalTime = arriveTime;

	}

	int getServiceDuration() {
		// add statements
		return serviceDuration;
	}

	int getArrivalTime() {
		// add statements
		return arrivalTime;
	}

	int getCarId() {
		return carId;
	}

	public String toString() {
		return "" + carId + ":" + serviceDuration + ":" + arrivalTime;

	}

	public static void main(String[] args) {
		// quick check!
		Car mycar = new Car(20, 30, 40);
		System.out.println("Car Info:" + mycar);

	}
}
