package bankatmswitch;

import java.util.Scanner; //For this project, I will rely mostly on scanner for input.

public class BankATMSwitch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int check = 500; // These values are the current balance the user holds.
        int save = 1000;

        System.out.println("Welcome to The Main Menu!");// Main menu
        System.out.println("Checking Balance: $500");
        System.out.println("Savings Balance: $1000");
        System.out.println("Check Balance (c)" + " Deposit (d)" + " Withdraw (w)");
        System.out.println("What would you like to do today? Press 1 to access your checking account. Press 2 to access your savings account"); // Asks user the options.

        char option; // I declared option for the nested switch statement
        int bankoption;
        int deposit;
        int withdrawal;
        bankoption = sc.nextInt(); // This determines whether it is savings or checkings

        switch (bankoption) {
            case 1: //This is checkings
                System.out.println("You have chosen checking account. " + "Please choose an option: " + "Check Balance (c)" + " Deposit (d)" + " Withdraw (w)");
                option = sc.next().charAt(0); // The letter that that will trigger the cases.
                switch (option) { // This is a switch within a switch. I nested them as if it is an if-else statement.
                    case 'c':
                        System.out.println("Your current balance is: " + '$' + check);

                        break;
                    case 'd':
                        System.out.println("How much would you like to deposit?");
                        deposit = sc.nextInt(); //This is how much they'll deposit
                        System.out.println("Your new balance is " + '$' + (check + deposit));
                        break;
                    case 'w':
                        System.out.println("How much would you like to withdraw?");
                        withdrawal = sc.nextInt();
                        if (withdrawal >= 10) { //This is the limit of how much they can withdraw
                            System.out.print("Your new balance is " + '$' + (check - withdrawal)); //Takes checking balance and subtracts only if it satisfies the expression.
                        } else {
                            System.out.println("You must withdraw more than $10");
                        }
                        break;

                    default:
                        break; //This is here if they input something else other than the three letters.
                }

                break;

            case 2: // If case one isn't excuted, then case two will, which is savings.
                System.out.println("You have chosen savings account. " + "Please choose an option: " + "Check Balance (c)" + " Deposit (d)" + " Withdraw (w)");
                option = sc.next().charAt(0);
                switch (option) { // This a switch within a switch. Often called nesting.
                    case 'c':
                        System.out.println("Your current balance is " + '$' + save);
                        break;
                    case 'd':
                        System.out.println("How much would you like to deposit");
                        deposit = sc.nextInt();
                        System.out.println("Your new balance is " + '$' + (save + deposit));
                        break;
                    case 'w':
                        System.out.println("How much would you like to withdraw?");
                        withdrawal = sc.nextInt();
                        if (withdrawal >= 100) {
                            System.out.print("Your new balance is " + '$' + (save - withdrawal));
                        } else {
                            System.out.println("You must withdraw more than $100");
                        }
                        break;

                    default:
                        break; //This is here if they input something else other than the three letters.

                }
                break;

            default:
                break; // This last break here is if they put a number other than 1 and 2

        }

    }

}
