package simplechess;

import java.util.Scanner;

public class SimpleChess {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        String[][] chessboard = new String[8][8];
        for (String[] chessboard1 : chessboard) {
            for (int col = 0; col < chessboard1.length; col++) { // This code here fills every single element in the 8x8 with empty squares.
                chessboard1[col] = "\u25A1";
            }
        }

        chessboard[0][0] = "\u2656"; // This list replaces the desired empty sqaures with the chess peices.
        chessboard[0][1] = "\u2658";
        chessboard[0][2] = "\u2657";
        chessboard[0][3] = "\u2654";
        chessboard[0][4] = "\u2655";
        chessboard[0][5] = "\u2657";
        chessboard[0][6] = "\u2658";
        chessboard[0][7] = "\u2656";
        chessboard[1][0] = "\u2659";
        chessboard[1][1] = "\u2659";
        chessboard[1][2] = "\u2659";
        chessboard[1][3] = "\u2659";
        chessboard[1][4] = "\u2659";
        chessboard[1][5] = "\u2659";
        chessboard[1][6] = "\u2659";
        chessboard[1][7] = "\u2659";
        chessboard[6][0] = "\u265F";
        chessboard[6][1] = "\u265F";
        chessboard[6][2] = "\u265F";
        chessboard[6][3] = "\u265F";
        chessboard[6][4] = "\u265F";
        chessboard[6][5] = "\u265F";
        chessboard[6][6] = "\u265F";
        chessboard[6][7] = "\u265F";
        chessboard[7][0] = "\u265C";
        chessboard[7][1] = "\u265E";
        chessboard[7][2] = "\u265D";
        chessboard[7][3] = "\u265B";
        chessboard[7][4] = "\u265A";
        chessboard[7][5] = "\u265D";
        chessboard[7][6] = "\u265E";
        chessboard[7][7] = "\u265C";

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your side. White [w] Black [b] "); // To get the user input, I use scanner.

        boolean hah;

        do {
            String side;
            do {
                side = sc.nextLine();
                if ("b".equals(side)) {
                    System.out.println("You have chosen the black side"); //This determines what side the player is on.
                    break;
                } else if ("w".equals(side)) {
                    System.out.println("You have chosen the white side");
                    break;
                } else {
                    System.out.println("Invalid input. Try again");
                }

            } while ("b".equals(side) || "w".equals(side));

            for (int x = 0; x < chessboard.length; x++) {
                System.out.print(chessboard[0][x] + " ");
            } // This displays the chess board
            System.out.println(" ");
            for (int x = 0; x < chessboard.length; x++) {
                System.out.print(chessboard[1][x] + " ");
            }
            System.out.println(" ");
            for (int x = 0; x < chessboard.length; x++) {
                System.out.print(chessboard[2][x] + " ");
            }
            System.out.println(" ");
            for (int x = 0; x < chessboard.length; x++) {
                System.out.print(chessboard[3][x] + " ");
            }
            System.out.println(" ");
            for (int x = 0; x < chessboard.length; x++) {
                System.out.print(chessboard[4][x] + " ");
            }
            System.out.println(" ");
            for (int x = 0; x < chessboard.length; x++) {
                System.out.print(chessboard[5][x] + " ");
            }
            System.out.println(" ");
            for (int x = 0; x < chessboard.length; x++) {
                System.out.print(chessboard[6][x] + " ");
            }
            System.out.println(" ");
            for (int x = 0; x < chessboard.length; x++) {
                System.out.print(chessboard[7][x] + " ");
            }

            System.out.println("It is your turn");
            System.out.println("Type your first coordinate. For example: 1");

            int first;
            int second; // These delcarations are going to be the inputs of the user's desired location.
            int third;
            int fourth;

            do {
                first = sc.nextInt();
                if (first < 8) {
                    System.out.println("Number confirmed. Pick your second coordinate"); // First coordinate
                } else {
                    System.out.println("Invalid input, try again");
                }
            } while (!(first < 8));

            do {
                second = sc.nextInt();
                if (second < 8) {
                    System.out.println("Number confirmed. Type your first coordinate for where you want to place it"); // Second coordinate
                } else {
                    System.out.println("Invalid input, try again");
                }
            } while (!(second < 8));

            do {
                third = sc.nextInt();
                if (third < 8) {
                    System.out.println("Number confirmed. Type your second coordinate for where you want to place it"); // First coordinate of the desired spot
                } else {
                    System.out.println("Invalid input, try again");
                }
            } while (!(third < 8));

            do {
                fourth = sc.nextInt();
                if (fourth < 8) {
                    System.out.println("Number confirmed.");
                } else {
                    System.out.println("Invalid input, try again");
                }
            } // Second coordinate of the desired spot
            while (!(fourth < 8));

            System.out.println("You have chosen to move the piece at " + "(" + first + "," + second + ")" + " to " + "(" + third + "," + fourth + ")");

            if ("\u25A1".equals(chessboard[third][fourth]) || !"\u25A1".equals(chessboard[first][second])) {
                chessboard[third][fourth] = chessboard[first][second]; //This complex code are will move the peices, determine whether is it empty of not, and check if theres a piece.
                chessboard[first][second] = "\u25A1";
                System.out.println("Moving...success");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[0][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[1][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[2][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[3][x] + " ");
                }    // Here prints out the newly updated chess board
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[4][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[5][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[6][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[7][x] + " ");
                }
            } else if (chessboard[first][second].equals("\u25A1") || !chessboard[third][fourth].equals("\u25A1")) {
                System.out.println("The current location you are trying to move is empty. Please pick a different square"); // This here checks if the location has a piece of not
                do {
                    first = sc.nextInt();
                    if (first < 8) {
                        System.out.println("Number confirmed. Pick your second coordinate"); // First coordinate
                    } else {
                        System.out.println("Invalid input, try again");
                    }
                } while (!(first < 8));

                do {
                    second = sc.nextInt();
                    if (second < 8) {
                        System.out.println("Number confirmed. Type your first coordinate for where you want to place it"); // Second coordinate
                    } else {
                        System.out.println("Invalid input, try again");
                    }
                } while (!(second < 8));

                do {
                    third = sc.nextInt();
                    if (third < 8) {
                        System.out.println("Number confirmed. Type your second coordinate for where you want to place it"); // First coordinate of the desired spot
                    } else {
                        System.out.println("Invalid input, try again");
                    }
                } while (!(third < 8));

                do {
                    fourth = sc.nextInt();
                    if (fourth < 8) {
                        System.out.println("Number confirmed.");
                    } else {
                        System.out.println("Invalid input, try again");
                    }
                } // Second coordinate of the desired spot
                while (!(fourth < 8));

                System.out.println("You have chosen to move the piece at " + "(" + first + "," + second + ")" + " to " + "(" + third + "," + fourth + ")");

                if ("\u25A1".equals(chessboard[first][second])) {
                    chessboard[first][second] = chessboard[third][fourth]; //This complex code are will move the peices, determine whether is it empty of not, and check if theres a piece.
                    chessboard[first][second] = "\u25A1";
                    System.out.println("Not possible, you are trying to move an empty square. Try again");
                    for (int x = 0; x < chessboard.length; x++) {
                        System.out.print(chessboard[0][x] + " ");
                    }
                    System.out.println(" ");
                    for (int x = 0; x < chessboard.length; x++) {
                        System.out.print(chessboard[1][x] + " ");
                    }
                    System.out.println(" ");
                    for (int x = 0; x < chessboard.length; x++) {
                        System.out.print(chessboard[2][x] + " ");
                    }
                    System.out.println(" ");
                    for (int x = 0; x < chessboard.length; x++) {
                        System.out.print(chessboard[3][x] + " ");
                    }    // Here prints out the newly updated chess board
                    System.out.println(" ");
                    for (int x = 0; x < chessboard.length; x++) {
                        System.out.print(chessboard[4][x] + " ");
                    }
                    System.out.println(" ");
                    for (int x = 0; x < chessboard.length; x++) {
                        System.out.print(chessboard[5][x] + " ");
                    }
                    System.out.println(" ");
                    for (int x = 0; x < chessboard.length; x++) {
                        System.out.print(chessboard[6][x] + " ");
                    }
                    System.out.println(" ");
                    for (int x = 0; x < chessboard.length; x++) {
                        System.out.print(chessboard[7][x] + " ");
                    }
                }

                do {
                    first = sc.nextInt();
                    if (first < 8) {
                        System.out.println("Number confirmed. Pick your second coordinate");
                    } else {
                        System.out.println("Invalid input, try again");
                    }
                } while (!(first < 8));

                second = sc.nextInt();
                if (second < 8) {
                    System.out.println("Number confirmed. Type your first coordinate for where you want to place it");
                } else {
                    System.out.println("Invalid input, try again");
                }
                while (!(second < 8));

                do {
                    third = sc.nextInt();
                    if (third < 8) {
                        System.out.println("Number confirmed. Type your second coordinate for where you want to place it");
                    } else {
                        System.out.println("Invalid input, try again");
                    }
                } while (!(third < 8));

                do {
                    fourth = sc.nextInt();
                    if (fourth < 8) {
                        System.out.println("Number confirmed.");
                    } else {
                        System.out.println("Invalid input, try again");
                    }
                } while (!(fourth < 8));
            } else {
                do {
                    System.out.println("That location is occupied. Please choose a new destination square. Type your first coordinate"); //This executes only if the user fails to provide the correct coordinates.
                    do {
                        first = sc.nextInt();
                        if (first < 8) {
                            System.out.println("Number confirmed. Pick your second coordinate");
                        } else {
                            System.out.println("Invalid input, try again");
                        }
                    } while (!(first < 8));

                    second = sc.nextInt();
                    if (second < 8) {
                        System.out.println("Number confirmed. Type your first coordinate for where you want to place it");
                    } else {
                        System.out.println("Invalid input, try again");
                    }
                    while (!(second < 8));

                    do {
                        third = sc.nextInt();
                        if (third < 8) {
                            System.out.println("Number confirmed. Type your second coordinate for where you want to place it");
                        } else {
                            System.out.println("Invalid input, try again");
                        }
                    } while (!(third < 8));

                    do {
                        fourth = sc.nextInt();
                        if (fourth < 8) {
                            System.out.println("Number confirmed.");
                        } else {
                            System.out.println("Invalid input, try again");
                        }
                    } while (!(fourth < 8));

                    if ("\u25A1".equals(chessboard[third][fourth])) { // This is the same thing as above, which is to alter the location. The only thing different is that this is executed if the user provides the wrong coodinates.

                        chessboard[third][fourth] = chessboard[first][second];
                        chessboard[first][second] = "\u25A1";
                        System.out.println("Moving...success");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[0][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[1][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[2][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[3][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[4][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[5][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[6][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[7][x] + " ");
                        }
                    }
                } while (("\u25A1".equals(chessboard[third][fourth])));
            }

            System.out.println("It is now your opponent's turn. Pick your first coodinate."); // The rest of this code is the SAME as above. This is for white's turn.

            do {
                first = sc.nextInt();
                if (first < 8) {
                    System.out.println("Number confirmed. Pick your second coordinate");
                } else {
                    System.out.println("Invalid input, try again");
                }
            } while (!(first < 8));

            do {
                second = sc.nextInt();
                if (second < 8) {
                    System.out.println("Number confirmed. Type your first coordinate for where you want to place it"); //White's turn to input.
                } else {
                    System.out.println("Invalid input, try again");
                }
            } while (!(second < 8));

            do {
                third = sc.nextInt();
                if (third < 8) {
                    System.out.println("Number confirmed. Type your second coordinate for where you want to place it");
                } else {
                    System.out.println("Invalid input, try again");
                }
            } while (!(third < 8));

            do {
                fourth = sc.nextInt();
                if (fourth < 8) {
                    System.out.println("Number confirmed.");
                } else {
                    System.out.println("Invalid input, try again");
                }
            } while (!(fourth < 8));

            System.out.println("You have chosen to move the piece at " + "(" + first + "," + second + ")" + " to " + "(" + third + "," + fourth + ")");

            if ("\u25A1".equals(chessboard[third][fourth])) {
                chessboard[third][fourth] = chessboard[first][second];
                chessboard[first][second] = "\u25A1";
                System.out.println("Moving...success");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[0][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[1][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[2][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[3][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[4][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[5][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[6][x] + " ");
                }
                System.out.println(" ");
                for (int x = 0; x < chessboard.length; x++) {
                    System.out.print(chessboard[7][x] + " ");
                }
            } else if (!chessboard[third][fourth].equals("\u25A1")) {
                System.out.println("The current location you are trying to move is empty. Please pick a different square");
            } else {
                boolean meep = true;
                do {
                    System.out.println("That location is occupied. Please choose a new destination square. Type your first coordinate"); // This will be excuted if the user makes on error on the coordinates.
                    do {
                        first = sc.nextInt();
                        if (first < 8) {
                            System.out.println("Number confirmed. Pick your second coordinate");
                        } else {
                            System.out.println("Invalid input, try again");
                        }
                    } while (!(first < 8));

                    second = sc.nextInt();
                    if (second < 8) {
                        System.out.println("Number confirmed. Type your first coordinate for where you want to place it");
                    } else {
                        System.out.println("Invalid input, try again");
                    }
                    while (!(second < 8));

                    do {
                        third = sc.nextInt();
                        if (third < 8) {
                            System.out.println("Number confirmed. Type your second coordinate for where you want to place it");
                        } else {
                            System.out.println("Invalid input, try again");
                        }
                    } while (!(third < 8));

                    do {
                        fourth = sc.nextInt();
                        if (fourth < 8) {
                            System.out.println("Number confirmed.");
                        } else {
                            System.out.println("Invalid input, try again");
                        }
                    } while (!(fourth < 8));

                    if ("\u25A1".equals(chessboard[third][fourth])) {
                        chessboard[third][fourth] = chessboard[first][second];
                        chessboard[first][second] = "\u25A1";
                        System.out.println("Moving...success");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[0][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[1][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[2][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[3][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[4][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[5][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[6][x] + " ");
                        }
                        System.out.println(" ");
                        for (int x = 0; x < chessboard.length; x++) {
                            System.out.print(chessboard[7][x] + " ");
                        }
                    }
                } while (("\u25A1".equals(chessboard[third][fourth])));
            }

            System.out.println("Type 1 to continue playing. Type 2 to end the game"); // This here determines whether to loop the whole code or not.
            int ce;
            ce = sc.nextInt();
            if (ce == 1) {
                hah = true;
            } else {
                hah = false;
            }

        } while (hah); // This is the actual loop of the whole code

    }

}
