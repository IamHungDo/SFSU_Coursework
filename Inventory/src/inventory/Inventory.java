package inventory;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Inventory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] items = new String[10];
        items[0] = "notebook";
        items[1] = "pen";
        items[2] = "paper";
        items[3] = "glue";
        items[4] = "scissors";
        items[5] = "erasers";
        items[6] = "crayons";
        items[7] = "backpack";
        items[8] = "binder";
        items[9] = "ruler";

        int[] quantity = new int[10];
        quantity[0] = 44;
        quantity[1] = 988;
        quantity[2] = 3821;
        quantity[3] = 100;
        quantity[4] = 3;
        quantity[5] = 253;
        quantity[6] = 42;
        quantity[7] = 2;
        quantity[8] = 80;
        quantity[9] = 90;

        double[] price = new double[10];
        price[0] = 4.99;
        price[1] = 0.45;
        price[2] = 0.11;
        price[3] = 0.99;
        price[4] = 1.99;
        price[5] = 0.50;
        price[6] = 0.20;
        price[7] = 9.99;
        price[8] = 2.99;
        price[9] = 0.75;

        System.out.println("Welcome to the Gator bookstore inventory!");
        System.out.println("What would you like to do today?");
        System.out.println("[p] Print inventory");
        System.out.println("[c] Check for low inventory");
        System.out.println("[v] Total inventory value");
        System.out.println("[e] Exit");

        boolean whatever = true;
        while (whatever) {

            String option;
            option = sc.nextLine();
            double sum = 0;
            DecimalFormat sd = new DecimalFormat("0.00");

            switch (option) {
                case "p":
                    System.out.println("Your current inventory consists of:");
                    for (int x = 0; x < items.length; x++) {
                        System.out.println(items[x] + ", " + quantity[x] + ", " + "$" + price[x]);
                    }
                    break;
                case "c":
                    System.out.println("The following items are low in stock:");
                    for (int x = 0; x <= 9; x++) {
                        if (quantity[x] < 5) {
                            System.out.println(items[x] + ", " + quantity[x] + ", " + "$" + price[x]);
                        }
                    }
                    break;
                case "v":
                    System.out.print("Your total inventory value is: ");
                    for (int x = 0; x <= 9; x++) {
                        double[] totalvalue = new double[10];
                        totalvalue[x] = quantity[x] * price[x];
                        for (int j = 0; j <= 9; j++) {
                            sum += totalvalue[j];
                        }
                    }
                    String sdd = sd.format(sum);
                     {
                        System.out.println("$" + sdd);
                    }
                    break;
                case "e":
                    whatever = false;
                    System.out.println("You have exit the program.");

                    break;
                default:
                    System.out.println("Invalid input");
                    break;

            }

        }

    }
}
