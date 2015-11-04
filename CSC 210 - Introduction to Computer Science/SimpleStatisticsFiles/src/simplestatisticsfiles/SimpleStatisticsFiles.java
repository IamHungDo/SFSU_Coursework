package simplestatisticsfiles;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleStatisticsFiles {

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

    public static double[] numScaleUp(double o[], int x) {
        double sum = 0;
        double[] num3 = new double[4];
        for (int p = 0; p < o.length; p++) {
            sum = o[p] * x;
            System.out.println(sum);
            num3[p] = sum;
        }
        return num3;
    }

    public static void scaleDown(double x[], int i) { //This takes every number and divides it with the given number by the user.

        double sum = 0;
        for (int p = 0; p < x.length; p++) {
            sum = x[p] / i;

            System.out.println(sum);
        }
    }

    public static double[] getInput(String inputFile) throws Exception {
        String text = "";
        Scanner fc = new Scanner(new File("C:\\Users\\Hung\\Desktop\\" + inputFile)); //This lets the user choose what txt file to choose from.
        Scanner sc = new Scanner(System.in);

        FileReader file = new FileReader("C:\\Users\\Hung\\Desktop\\" + inputFile);
        BufferedReader reader = new BufferedReader(file);
        String line = reader.readLine();
        while (line != null) {
            text += line;
            line = reader.readLine();
        }

        double[] num1 = new double[4];
        for (int i = 0; i < num1.length; i++) {
            num1[i] = fc.nextDouble();
        }
        return num1;
    }

    public static void writeOutput(String outputFile, double[] numScaledUp) throws Exception {
        PrintWriter writer = new PrintWriter("C:\\Users\\Hung\\Desktop\\newnumbers.txt");
        writer.println(numScaledUp[0]);
        writer.println(numScaledUp[1]);
        writer.println(numScaledUp[2]); //What I did here is write the array values in the note pad.
        writer.println(numScaledUp[3]);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Press [a] for files. Press [b] for number input");
        Scanner sc = new Scanner(System.in);
        String d;

        do {
            d = sc.nextLine();
            if ("a".equals(d)) { // This here determines whether you want to write to a file or just produce numbers.
                for (int i = 0; i < args.length; i++) {
                    System.out.println(args[i]);
                }
                double[] num2 = new double[4]; // This creates a new array for the new numbers produced from getinput.
                try {
                    System.out.println("Type in the file you would like to open. Example: numbers.txt");
                    String filein = sc.nextLine();
                    System.out.println("File comfirmed");
                    num2 = getInput(filein);

                } catch (FileNotFoundException ex) {
                    System.out.println("File not found. Try again"); // This catches all the exceptions it produces.
                    sc.nextLine();
                } catch (IOException ee) {
                    System.out.println("File not found. Try again");
                    sc.nextLine();
                } catch (Exception ex) {
                    Logger.getLogger(SimpleStatisticsFiles.class.getName()).log(Level.SEVERE, null, ex);
                }
                double[] num3 = new double[4];
                num3 = numScaleUp(num2, 5);
                writeOutput("newnumbers.txt", num3);

                System.out.println("File Write Complete");
                System.exit(0);

            } else if ("b".equals(d)) {

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

            } else {
                System.out.println("Not a valid input. Try again");
            }
        } while (!("a".equals(d) && "b".equals(d)));
    }
}
