package simplestatistics;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class SimpleStatistics {

    public static double[] getUserInput(double i) { // This array here takes the user input and puts them in a double array.

        double[] meep = null;

        do {
            Scanner sc = new Scanner(System.in);

            double[] numbers = new double[(int) i];

            for (double x = 0; x < numbers.length; x++) {
                System.out.println("Enter a number");

                boolean flag = false;
                while (!flag) {
                    try {
                        numbers[(int) x] = sc.nextDouble();  // This gets every number they input.
                        flag = true;
                    } catch (InputMismatchException ex) {
                        System.out.println("Only integers are allowed. Try Again");
                        sc.nextLine();
                    }
                }

                meep = numbers.clone();
            }

        } while (!(i < 10));
        return meep;

    }

    public static void arithmeticMean(double x[]) { //This takes the numbers in the array, adds them, then divide by the length.
        double sum = 0;
        for (double i : x) {
            sum += i;
        }
        double totalval = sum / x.length;
        System.out.println("The arithmetic mean is: " + totalval);

    }

    public static void geometricMean(double x[]) { // This takes the numbers in the array and figures out the geometric mean by using the math.pow class.
        double sum = 1.0;
        for (int i = 0; i < x.length; i++) {
            sum *= x[i];
        }
        sum = Math.pow(sum, 1.0 / (double) x.length);
        System.out.println("The geometric mean is: " + sum);
    }

    public static void minAndmax(double x[]) { // This figures out the min and max by using for loop to figure out which number is larger than the other.

        double large = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] > large) {
                large = x[i];
            }
        }
        System.out.println("The largest number is: " + large);

        double small = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] < small) {
                small = x[i];
            }
        }
        System.out.println("The smaller number is: " + small);
    }

    public static void scaleUp(double x[], int i) { // This takes every number and multiplies it with the given number by the user.

        double sum = 0;
        for (int p = 0; p < x.length; p++) {
            sum = x[p] * i;
            System.out.println(sum);
        }

    }

    public static void scaleDown(double x[], int i) { //This takes every number and divides it with the given number by the user.

        double sum = 0;
        for (int p = 0; p < x.length; p++) {
            sum = x[p] / i;

            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        FileReader file = new FileReader("/Users/HungDo/Documents/numbers.txt");
        BufferedReader reader = new BufferedReader(file);
        String text = "";
        String line = reader.readLine();
        while (line != null) {
            text += line;
            line = reader.readLine();
        }
        System.out.println(text);

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        double arraysize = 0;
        boolean meeps = true;

        System.out.println("How many numbers would you like to input?"); // This determines how much numbers the user wants to input.
        double[] num = new double[(int) arraysize];
        do {

            try {

                do {
                    arraysize = sc.nextDouble();
                    if (arraysize < 10) {
                        num = getUserInput(arraysize);
                    } else {
                        System.out.println("Keep the number below 10");
                    } // I've limit it to 10 due to convenience.
                } while (!(arraysize < 10));

                meeps = false;
            } catch (InputMismatchException ex) {
                System.out.println("Only integers are allowed. Try again");
                System.out.println("How many numbers would you like to input?"); // This exception is if they input letters.
                sc.nextLine();

            }
        } while (meeps);

        System.out.println("What would you like to do? Arithmetic Mean [1], Geometric Mean [2], Min and Max [3], ScaleUp [4], or ScaleDown [5]");
        boolean moo = true; // 
        while (moo) {
            int meep;

            try { // I put this whole switch statement in a try and catch to catch the letters.
                meep = sc.nextInt();
                boolean beep = false;
                while (!beep) {
                    switch (meep) {
                        case 1:
                            arithmeticMean(num);
                            System.out.println("You may choose another option. Arithmetic Mean [1], Geometric Mean [2], Min and Max [3], ScaleUp [4], or ScaleDown [5] If not, press [6] to exit"); // Corresponds with arithmeticMean.
                            beep = true;
                            break;
                        case 2:
                            geometricMean(num);
                            System.out.println("You may choose another option. Arithmetic Mean [1], Geometric Mean [2], Min and Max [3], ScaleUp [4], or ScaleDown [5] If not, press [6] to exit"); // Corresponds with geometricMean.
                            beep = true;
                            break;
                        case 3:
                            minAndmax(num);
                            System.out.println("You may choose another option. Arithmetic Mean [1], Geometric Mean [2], Min and Max [3], ScaleUp [4], or ScaleDown [5] If not, press [6] to exit"); // Corresponds with minAndmax.
                            beep = true;
                            break;
                        case 4:
                            System.out.println("What number would you like to multiply by?"); // Corresponds with scapeUp
                            int o;
                            boolean flag = false;
                            while (!flag) {
                                try {
                                    o = sc.nextInt();
                                    scaleUp(num, o);
                                    flag = true;
                                } catch (InputMismatchException ex) {
                                    System.out.println("The scaling factor must be at least 1 and not a letter");
                                    sc.nextLine();
                                }
                            }
                            System.out.println("You may choose another option. Arithmetic Mean [1], Geometric Mean [2], Min and Max [3], ScaleUp [4], or ScaleDown [5] If not, press [6] to exit");
                            beep = true;
                            break;

                        case 5:
                            System.out.println("What number would you like to divide by?");  //Corresponds with scaleDown.
                            int k;
                            boolean chirp = false;
                            while (!chirp) {

                                try {
                                    k = sc.nextInt();
                                    if (k > 0 || k < 0) {
                                        scaleDown(num, k);
                                        chirp = true;
                                    } else if (k == 0) {
                                        throw new IllegalArgumentException("Invalid Input");
                                    }
                                } catch (IllegalArgumentException ex) {
                                    System.out.println("You cannot divide by 0");
                                    sc.nextLine();
                                }
                            }
                            System.out.println("You may choose another option. Arithmetic Mean [1], Geometric Mean [2], Min and Max [3], ScaleUp [4], or ScaleDown [5]"
                                    + " If not, press [6] to exit");
                            beep = true;
                            break;

                        case 6:
                            System.out.println("You have exit the program."); //Exits the program.
                            moo = false;
                            beep = true;
                            break;
                        default:
                            System.out.println("Enter the correct letter. Integers are not accepted ");
                            break;
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("You must input a number between 1-5");
                sc.nextLine();
            }

        }
    }
}
