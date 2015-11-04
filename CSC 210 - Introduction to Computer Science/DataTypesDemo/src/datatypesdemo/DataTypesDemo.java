package datatypesdemo;

import java.util.Scanner;

public class DataTypesDemo {

    public static void main(String[] args) {

        int number1;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Is your number 2 or 1?");
        number1 = userInput.nextInt();

        if (number1 == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }

}
