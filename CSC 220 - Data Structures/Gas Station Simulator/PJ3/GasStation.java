package PJ3;

import java.util.*;

//--------------------------------------------------------------------------
//
// Define simulation queues in a gas station. Queues hold references to Car &
// GasPump objects
//
// Car (FIFO) queue is used to hold waiting cars. If the queue is too long
// (i.e. >  carQSizeLimit), car goes away without entering car queue
//
// There are several gas pumps in a gas station. Use PriorityQueue to 
// hold BUSY gas pumps and FIFO queue to hold FREE gas pumps, 
// i.e. a pump that is FREE for the longest time should start be used first.
//
// To handle gasPump in PriorityQueue, we need to define comparator 
// for comparing 2 gasPump objects. Here is a constructor from Java API:
//
// 	PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 
//
// For priority queue, the default compare function is "natural ordering"
// i.e. for numbers, minimum value is returned first
//
// User can define own comparator class for PriorityQueue.
// For GasPump objects, we like to have smallest end busy interval time first.
//
// The following class define compare() for two busy gas pumps :

class BusyGasPumpComparator implements Comparator<GasPump> {
	// overide compare() method
	public int compare(GasPump o1, GasPump o2) {
		return o1.getEndIntervalTime() - o2.getEndIntervalTime();
	}
}

// DO NOT ADD NEW METHODS OR DATA FIELDS
class GasStation {

	// Private data fields:

	// define one priority queue
	private PriorityQueue<GasPump> busyGasPumpQ;

	// define two FIFO queues
	private Queue<Car> carQ;
	private Queue<GasPump> freeGasPumpQ;

	// define car queue size limit
	private int carQSizeLimit;

	// Constructor
	public GasStation() {
		carQSizeLimit = 0;
		// add statements
	}

	// Constructor
	public GasStation(int numGasPumps, int carQlimit, int startGasPumpID) {
		// use ArrayDeque to construct FIFO queue objects
		freeGasPumpQ = new ArrayDeque<GasPump>(numGasPumps);
		carQ = new ArrayDeque<Car>(carQlimit);

		// construct PriorityQueue object
		// overide compare() in Comparator to compare busy GasPump objects
		busyGasPumpQ = new PriorityQueue<GasPump>(numGasPumps, new BusyGasPumpComparator());

		carQSizeLimit = carQlimit;
		// initialize carQlimit

		// Construct GasPump objects and insert into FreeGasPumpQ

		for (int i = 0; i < numGasPumps; i++) {
			freeGasPumpQ.add(new GasPump(startGasPumpID + i));

		}

		// add statements
	}

	public GasPump removeFreeGasPumpQ() {
		// remove and return a free gasPump

		return freeGasPumpQ.poll();
	}

	public GasPump removeBusyGasPumpQ() {
		// remove and return a busy gasPump

		return busyGasPumpQ.poll();
	}

	public Car removeCarQ() {
		// remove and return a car

		return carQ.poll();
	}

	public void insertFreeGasPumpQ(GasPump gasPump) {
		// insert a free gasPump
		freeGasPumpQ.add(gasPump);
	}

	public void insertBusyGasPumpQ(GasPump gasPump) {
		busyGasPumpQ.add(gasPump);
		// insert a busy gasPump
	}

	public void insertCarQ(Car car) {
		// insert a car
		carQ.offer(car);
		// Add statements
	}

	public boolean emptyFreeGasPumpQ() {
		// is freeGasPumpQ empty?
		if (freeGasPumpQ.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean emptyBusyGasPumpQ() {
		// is busyGasPumpQ empty?
		if (busyGasPumpQ.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean emptyCarQ() {
		// is carQ empty?
		if (carQ.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public int numFreeGasPumps() {
		// get number of free gasPumps
		return freeGasPumpQ.size();
	}

	public int numBusyGasPumps() {
		// get number of busy gasPumps
		return busyGasPumpQ.size();
	}

	public int numWaitingCars() {
		// get number of cars

		return carQ.size();
	}

	public GasPump getFrontBusyGasPumpQ() {
		// get front of busy gasPumps
		// "retrieve" but not "remove"
		// Add statetments
		return busyGasPumpQ.peek();
	}

	public boolean isCarQTooLong() {
		// is carQ too long?
		// Add statetments
		if (carQ.size() >= carQSizeLimit) {
			return true;
		} else {
			return false;
		}
	}

	public void printStatistics() {
		System.out.println("\t# waiting cars        : " + numWaitingCars());
		System.out.println("\t# busy gas pumps      : " + numBusyGasPumps());
		System.out.println("\t# free gas pumps      : " + numFreeGasPumps());
	}

	public static void main(String[] args) {
		GasStation sc = new GasStation(4, 5, 1001);
		Car c1 = new Car(1, 18, 10);
		Car c2 = new Car(2, 33, 10);
		Car c3 = new Car(3, 21, 10);
		Car c4 = new Car(3, 37, 10);
		sc.insertCarQ(c1);
		sc.insertCarQ(c2);
		sc.insertCarQ(c3);
		System.out.println("" + sc.carQ);
		System.out.println("Remove car:" + sc.removeCarQ());
		System.out.println("Remove car:" + sc.removeCarQ());
		System.out.println("Remove car:" + sc.removeCarQ());

		System.out.println("" + sc.freeGasPumpQ);
		GasPump p1 = sc.removeFreeGasPumpQ();
		GasPump p2 = sc.removeFreeGasPumpQ();
		GasPump p3 = sc.removeFreeGasPumpQ();
		GasPump p4 = sc.removeFreeGasPumpQ();
		System.out.println("Remove free gas pump:" + p1);
		System.out.println("Remove free gas pump:" + p2);
		System.out.println("Remove free gas pump:" + p3);
		System.out.println("Remove free gas pump:" + p4);

		p1.switchFreeToBusy(c1, 13);
		p2.switchFreeToBusy(c2, 13);
		p3.switchFreeToBusy(c3, 13);
		p4.switchFreeToBusy(c4, 13);
		sc.insertBusyGasPumpQ(p1);
		sc.insertBusyGasPumpQ(p2);
		sc.insertBusyGasPumpQ(p3);
		sc.insertBusyGasPumpQ(p4);
		System.out.println("" + sc.busyGasPumpQ);
		p1 = sc.removeBusyGasPumpQ();
		p2 = sc.removeBusyGasPumpQ();
		p3 = sc.removeBusyGasPumpQ();
		p4 = sc.removeBusyGasPumpQ();
		System.out.println("Remove busy gas pump:" + p1);
		System.out.println("Remove busy gas pump:" + p2);
		System.out.println("Remove busy gas pump:" + p3);
		System.out.println("Remove busy gas pump:" + p4);

	}

};
