package elevatormethod;

import java.util.Scanner;

public class ElevatorMethod {

    public static int con(int x) {
        System.out.println("Number confirmed");
        return x;
    }

    public static int move(int i) {
        int e1 = 1;
        int e2 = 3; //These are the initialization of the floors
        int e3 = 5;
        int e4 = 9;
        int userFloor; // This int will be the input

        System.out.println("What floor would you like to board at?");

        do {
            Scanner sc = new Scanner(System.in);
            userFloor = sc.nextInt(); //input of floor
            if (userFloor >= 1 && userFloor <= 9) {
                con(1);
            } else {
                inv(4);
            }

        } while (!(userFloor >= 1 && userFloor <= 9)); // This do-while checks if the input 1-9 is valid from the user

        int Diffe1 = (Math.abs(e1 - userFloor));
        int Diffe2 = (Math.abs(e2 - userFloor)); //This will determine the closest floor by difference
        int Diffe3 = (Math.abs(e3 - userFloor));
        int Diffe4 = (Math.abs(e4 - userFloor));
        int closestE = 0; // 

        if (Diffe1 < Diffe2 && Diffe1 < Diffe3 && Diffe1 < Diffe4) {
            closestE = e1;
        } else if (Diffe2 < Diffe1 && Diffe2 < Diffe3 && Diffe2 < Diffe4) { //Determination of the closest floor by seeing if each difference is less than the other differences.
            closestE = e2;
        } else if (Diffe3 < Diffe1 && Diffe3 < Diffe1 && Diffe3 < Diffe4) {
            closestE = e3;
        } else if (Diffe4 < Diffe1 && Diffe4 < Diffe2 && Diffe4 < Diffe3) {
            closestE = e4;
        } else {
            if (Diffe1 < Diffe2 && Diffe1 < Diffe3 && Diffe1 < Diffe4) {
                closestE = e1;
            } else if (Diffe2 == Diffe1 && Diffe2 == Diffe3 && Diffe2 == Diffe4) {
                closestE = e2;
            } else if (Diffe3 == Diffe1 && Diffe3 == Diffe1 && Diffe3 == Diffe4) {
                closestE = e3;
            } else if (Diffe4 == Diffe1 && Diffe4 == Diffe2 && Diffe4 == Diffe3) {
                closestE = e4;
            }
        }
        int mainDifference;// New variable for the difference

        mainDifference = (closestE - userFloor);

        if (mainDifference > 0) {
            System.out.println("Elevator is going down."); //So if the mainDifference is greater than 0, then the elevator will go up.
            for (int x = closestE; x >= userFloor; x--) {
                System.out.println("Elevator is at " + x + "...");
            }
            System.out.println("Elevator is now here!");
        } else if (mainDifference < 0) {
            System.out.println("Elevator is going up.");// If the mainDifference is less than 0, it'll go down.
            for (int x = closestE; x <= userFloor; x++) {
                System.out.println("Elevator is at " + x + "...");
            }
            System.out.println("The elevator is now here!");
        } else if (mainDifference == 0) {
            System.out.println("You are on the same floor.");// If the user inputs the current floor they are in, it'll display this output.
        }
        return i;
    }

    public static int des(int w) {
        int e1 = 1;
        int e2 = 3; //These are the initialization of the floors
        int e3 = 5;
        int e4 = 9;
        int userFloor;
        Scanner sc = new Scanner(System.in);
        do {
            userFloor = sc.nextInt(); //input of floor
            if (userFloor >= 1 && userFloor <= 9) {
                con(1);
            } else {
                System.out.println("Invalid Input");
            }

        } while (!(userFloor >= 1 && userFloor <= 9)); // This do-while checks if the input 1-9 is valid from the user

        int Diffe1 = (Math.abs(e1 - userFloor));
        int Diffe2 = (Math.abs(e2 - userFloor)); //This will determine the closest floor by difference
        int Diffe3 = (Math.abs(e3 - userFloor));
        int Diffe4 = (Math.abs(e4 - userFloor));
        int closestE = 0; // 

        System.out.println("Choose your destination floor.");

        do {
            userFloor = sc.nextInt();
            if (userFloor >= 1 && userFloor <= 9) { // This asks and checks the input of the destination.
                con(1);
            } else {
                inv(9);
            }

        } while (!(userFloor >= 1 && userFloor <= 9));

        if (Diffe1 < Diffe2 && Diffe1 < Diffe3 && Diffe1 < Diffe4) {
            closestE = e1;
        } else if (Diffe2 < Diffe1 && Diffe2 < Diffe3 && Diffe2 < Diffe4) { // This is bascially the same thing as above, but it is directed for the destination.
            closestE = e2;
        } else if (Diffe3 < Diffe1 && Diffe3 < Diffe1 && Diffe3 < Diffe4) {
            closestE = e3;
        } else if (Diffe4 < Diffe1 && Diffe4 < Diffe2 && Diffe4 < Diffe3) {
            closestE = e4;
        } else {
            if (Diffe1 < Diffe2 && Diffe1 < Diffe3 && Diffe1 < Diffe4) {
                closestE = e1;
            } else if (Diffe2 == Diffe1 && Diffe2 == Diffe3 && Diffe2 == Diffe4) {
                closestE = e2;
            } else if (Diffe3 == Diffe1 && Diffe3 == Diffe1 && Diffe3 == Diffe4) {
                closestE = e3;
            } else if (Diffe4 == Diffe1 && Diffe4 == Diffe2 && Diffe4 == Diffe3) {
                closestE = e4;
            }
        }

        int mainDifference;

        mainDifference = (closestE - userFloor);

        if (mainDifference > 0) {
            System.out.println("Elevator is going down."); //So if the mainDifference is greater than 0, then the elevator will go up.
            for (int x = closestE; x >= userFloor; x--) {
                System.out.println("Elevator is at " + x + "...");
            }
        } else if (mainDifference < 0) {
            System.out.println("Elevator is going up.");//If the mainDifference is less than 0, it'll go down.
            for (int x = closestE; x <= userFloor; x++) {
                System.out.println("Elevator is at " + x + "...");
            }
            System.out.println("You have reached your destination.");
        } else if (mainDifference == 0) {
            System.out.println("You are on the same floor."); // If the user inputs the current floor they are in, it'll display this output.
        }
        return w;
    }

    public static int inv(int o) {
        System.out.println("Invalid Input");
        return o;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // I named my scanner "sc"
        do {
            move(2);

            des(3);

        } while (true); // I put it as true so that it can loop

    }

}
