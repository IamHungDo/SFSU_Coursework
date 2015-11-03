package quadraticequationsolver;

import java.util.Scanner;

public class QuadraticEquationSolver {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int a;
        int b;
        int c;
//I started with delcaring these variables.

        System.out.println("Enter the value of a"); //these ask the user for the input.
        a = userInput.nextInt();
        System.out.println("Enter the value of b");
        b = userInput.nextInt();
        System.out.println("Enter the value of c");
        c = userInput.nextInt();

        char exp = 178; //This makes it print out as an exponent in the syysetm printout below

        System.out.println("Your quadratic equation is: " + a + "x" + exp + "+" + b + "x+" + c);
        double answer1 = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a); //Here I used math class
        double answer2 = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a); //quadratic equation

        System.out.println("The answer is: " + answer1 + "," + answer2); //answer output
    }

}
