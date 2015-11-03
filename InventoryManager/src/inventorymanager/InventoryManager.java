package inventorymanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InventoryManager {

    static public void printInventory(Item[] mitems) {
        for (int x = 0; x < mitems.length; x++) {
            System.out.println(mitems[x].getName() + " " + mitems[x].getQuantity() + " " + mitems[x].getPricePerUnit());
        }

    }

    static public void checkLowInventory(Item[] citems) {
        for (int x = 0; x < citems.length; x++) {
            if (citems[x].getQuantity() < 5) {
                System.out.println(citems[x].getName() + " " + citems[x].getQuantity() + " " + citems[x].getPricePerUnit());
            } else {
                System.out.println("There are no items with quantity less than 5");
                break;
            }

        }
    }

    static public void totalInventoryValue(Item[] titems) {
        double sum = 0;

        for (int x = 0; x < titems.length; x++) {
            double total;
            total = titems[x].getQuantity() * titems[x].getPricePerUnit();
            sum += total;
        }
        System.out.println("$" + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner fc = null;
        try {
            fc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        String a;
        String b;
        String c;
        String[] list1 = new String[10];
        int[] list2 = new int[10];
        double[] list3 = new double[10];

        while (fc.hasNext()) {
            for (int x = 0; x < list1.length; x++) {
                a = fc.next();
                list1[x] = a;
                b = fc.next();
                int d = Integer.parseInt(b);
                list2[x] = d;
                c = fc.next();
                double e = Double.parseDouble(c);
                list3[x] = e;

            }
        }

        Item i1 = new Item(list1[0], list2[0], list3[0]);
        Item i2 = new Item(list1[1], list2[1], list3[1]);
        Item i3 = new Item(list1[2], list2[2], list3[2]);
        Item i4 = new Item(list1[3], list2[3], list3[3]);
        Item i5 = new Item(list1[4], list2[4], list3[4]);
        Item i6 = new Item(list1[5], list2[5], list3[5]);
        Item i7 = new Item(list1[6], list2[6], list3[6]);
        Item i8 = new Item(list1[7], list2[7], list3[7]);
        Item i9 = new Item(list1[8], list2[8], list3[8]);
        Item i10 = new Item(list1[9], list2[9], list3[9]);

        Item[] items = new Item[10];
        items[0] = i1;
        items[1] = i2;
        items[2] = i3;
        items[3] = i4;
        items[4] = i5;
        items[5] = i6;
        items[6] = i7;
        items[7] = i8;
        items[8] = i9;
        items[9] = i10;
        System.out.println("Welcome to Inventory Mananger. Print Inventory [p] Check for Low Inventory [c]\n" + "Total Inventory Value [v] Exit the program [e]");

        boolean meep = true;
        while (meep) {
            String option;
            option = sc.nextLine();

            switch (option) {
                case "p":
                    printInventory(items);
                    System.out.println("Choose another option. If not, press [e] to exit");
                    break;

                case "c":
                    checkLowInventory(items);
                    System.out.println("Choose another option. If not, press [e] to exit");
                    break;
                case "v":
                    totalInventoryValue(items);
                    System.out.println("Choose another option. If not, press [e] to exit");
                    break;
                case "e":
                    System.out.println("You have exit the program");
                    meep = false;
                    break;
                default:
                    System.out.println("Enter the correct input");
                    break;

            }

        }

    }

}
