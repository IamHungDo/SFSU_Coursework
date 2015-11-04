package extra.credit;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ExtraCredit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int e1 = 1;
        int e2 = 3;
        int e3 = 5;
        int e4 = 9;
        boolean derp = true;

        do {

            boolean meep = true;
            int newUserFloor = 0;
            do {
                try {
                    String input = JOptionPane.showInputDialog(null, "Enter the floor you would like to board at");
                    int userFloor = Integer.parseInt(input);
                    if (userFloor >= 1 && userFloor <= 9) {
                        System.out.println("Number confirmed!");
                        newUserFloor = userFloor;
                        meep = false;
                    } else {
                        System.out.println("Invalid Input");
                        input = JOptionPane.showInputDialog(null, "Number out of range. Enter a number between 1-9");
                        userFloor = Integer.parseInt(input);
                        throw new IllegalArgumentException();

                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Not an input. Try again");

                } catch (IllegalArgumentException ex) {
                    System.out.println("Try again");

                }
            } while (meep);

            int Diffe1 = (Math.abs(e1 - newUserFloor));
            int Diffe2 = (Math.abs(e2 - newUserFloor));
            int Diffe3 = (Math.abs(e3 - newUserFloor));
            int Diffe4 = (Math.abs(e4 - newUserFloor));
            int closestE = 0;

            if (Diffe1 < Diffe2 && Diffe1 < Diffe3 && Diffe1 < Diffe4) {
                closestE = e1;
            } else if (Diffe2 < Diffe1 && Diffe2 < Diffe3 && Diffe2 < Diffe4) {
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
            mainDifference = (closestE - newUserFloor);
            if (mainDifference > 0) {
                System.out.println("Elevator is going down.");
                for (int x = closestE; x >= newUserFloor; x--) {
                    System.out.println("Elevator is at " + x + "...");
                }
                System.out.println("Elevator is now here!");
            } else if (mainDifference < 0) {
                System.out.println("Elevator is going up.");
                for (int x = closestE; x <= newUserFloor; x++) {
                    System.out.println("Elevator is at " + x + "...");
                }
                System.out.println("The elevator is now here!");
            } else if (mainDifference == 0) {
                System.out.println("You are on the same floor.");
            }

            System.out.println("Choose your destination floor.");

            boolean deep = true;
            do {
                try {
                    String input = JOptionPane.showInputDialog(null, "Enter your destination");
                    int userFloor = Integer.parseInt(input);
                    if (userFloor >= 1 && userFloor <= 9) {
                        System.out.println("Number confirmed!");
                        newUserFloor = userFloor;
                        deep = false;
                    } else {
                        System.out.println("Invalid Input");
                        input = JOptionPane.showInputDialog(null, "Number out of range. Enter a number between 1-9");
                        userFloor = Integer.parseInt(input);
                        throw new IllegalArgumentException();

                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Not an input. Try again");

                } catch (IllegalArgumentException ex) {
                    System.out.println("Try again");

                }
            } while (deep);

            if (Diffe1 < Diffe2 && Diffe1 < Diffe3 && Diffe1 < Diffe4) {
                closestE = e1;
            } else if (Diffe2 < Diffe1 && Diffe2 < Diffe3 && Diffe2 < Diffe4) {
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

            mainDifference = (closestE - newUserFloor);

            if (mainDifference > 0) {
                System.out.println("Elevator is going down.");
                for (int x = closestE; x >= newUserFloor; x--) {
                    System.out.println("Elevator is at " + x + "...");
                }
            } else if (mainDifference < 0) {
                System.out.println("Elevator is going up.");
                for (int x = closestE; x <= newUserFloor; x++) {
                    System.out.println("Elevator is at " + x + "...");
                }
                System.out.println("You have reached your destination.");
            } else if (mainDifference == 0) {
                System.out.println("You are on the same floor.");
            }

            String beep = JOptionPane.showInputDialog(null, "Would you like another elevator ride? yes/no");

            if ("yes".equals(beep) || "Yes".equals(beep)) {
                derp = true;
            } else {
                derp = false;
            }

        } while (derp);

    }
}
