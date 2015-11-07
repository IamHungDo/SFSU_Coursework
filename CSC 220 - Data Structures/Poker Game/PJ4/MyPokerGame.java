package PJ4;

import java.util.*;

/*
 * Ref: http://en.wikipedia.org/wiki/Video_poker
 *      http://www.google.com/ig/directory?type=gadgets&url=www.labpixies.com/campaigns/videopoker/videopoker.xml
 *
 *
 * Short Description and Poker rules:
 *
 * Video poker is also known as draw poker. 
 * The dealer uses a 52-card deck, which is played fresh after each currentHand. 
 * The player is dealt one five-card poker currentHand. 
 * After the first draw, which is automatic, you may hold any of the cards and draw 
 * again to replace the cards that you haven't chosen to hold. 
 * Your cards are compared to a table of winning combinations. 
 * The object is to get the best possible combination so that you earn the highest 
 * payout on the bet you placed. 
 *
 * Winning Combinations
 *  
 * 1. Jacks or Better: a pair pays out only if the cards in the pair are Jacks, 
 * 	Queens, Kings, or Aces. Lower pairs do not pay out. 
 * 2. Two Pair: two sets of pairs of the same card denomination. 
 * 3. Three of a Kind: three cards of the same denomination. 
 * 4. Straight: five consecutive denomination cards of different suit. 
 * 5. Flush: five non-consecutive denomination cards of the same suit. 
 * 6. Full House: a set of three cards of the same denomination plus 
 * 	a set of two cards of the same denomination. 
 * 7. Four of a kind: four cards of the same denomination. 
 * 8. Straight Flush: five consecutive denomination cards of the same suit. 
 * 9. Royal Flush: five consecutive denomination cards of the same suit, 
 * 	starting from 10 and ending with an ace
 *
 */

/* This is the main poker game class.
 * It uses Decks and Card objects to implement poker game.
 * Please do not modify any data fields or defined methods
 * You may add new data fields and methods
 * Note: You must implement defined methods
 */

public class MyPokerGame {

	// default constant values
	private static final int startingBalance = 100;
	private static final int numberOfCards = 5;

	// default constant payout value and currentHand types
	private static final int[] multipliers = { 1, 2, 3, 5, 6, 9, 25, 50, 250 };
	private static final String[] goodHandTypes = { "Royal Pair", "Two Pairs", "Three of a Kind", "Straight",
			"Flush	", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush" };

	// must use only one deck
	private static final Decks oneDeck = new Decks(1);

	// holding current poker 5-card hand, balance, bet
	private List<Card> currentHand;
	private int balance;
	private int bet;
	int arraylength = 0;

	Scanner sc = new Scanner(System.in);

	/** default constructor, set balance = startingBalance */
	public MyPokerGame() {
		this(startingBalance);
	}

	/** constructor, set given balance */
	public MyPokerGame(int balance) {
		this.balance = balance;
	}

	/**
	 * This display the payout table based on multipliers and goodHandTypes
	 * arrays
	 */
	private void showPayoutTable() {
		System.out.println("\n\n");
		System.out.println("Payout Table   	      Multiplier   ");
		System.out.println("=======================================");
		int size = multipliers.length;
		for (int i = size - 1; i >= 0; i--) {
			System.out.println(goodHandTypes[i] + "\t|\t" + multipliers[i]);
		}
		System.out.println("\n\n");
	}

	/**
	 * Check current currentHand using multipliers and goodHandTypes arrays Must
	 * print yourHandType (default is "Sorry, you lost") at the end of function.
	 * This can be checked by testCheckHands() and main() method.
	 */
	private void checkHands() {

		List<Integer> numbers = new ArrayList<Integer>();
		for (int x = 0; x < 5; x++) {
			numbers.add(currentHand.get(x).getRank());
		}
		Collections.sort(numbers);

		if (royalFlush()) {
			System.out.println(goodHandTypes[8]);
			balance += (bet * multipliers[8]);

		} else if (straightFlush(numbers)) {
			System.out.println(goodHandTypes[7]);
			balance += (bet * multipliers[7]);
		} else if (fourOfAKind(numbers)) {
			System.out.println(goodHandTypes[6]);
			balance += (bet * multipliers[6]);
		} else if (fullHouse(numbers)) {
			System.out.println(goodHandTypes[5]);
			balance += (bet * multipliers[5]);
		}

		else if (flush()) {
			System.out.println(goodHandTypes[4]);
			balance += (bet * multipliers[4]);
		} else if (straight(numbers)) {
			System.out.println(goodHandTypes[3]);
			balance += (bet * multipliers[3]);
		} else if (threeOfAKind(numbers)) {
			System.out.println(goodHandTypes[2]);
			balance += (bet * multipliers[2]);
		} else if (twoPair(numbers)) {
			System.out.println(goodHandTypes[1]);
			balance += (bet * multipliers[1]);
		} else if (royalPair()) {
			System.out.println(goodHandTypes[0]);
			balance += (bet * multipliers[0]);
		} else {
			System.out.println("Sorry you lost!");
		}

	}

	/*************************************************
	 * add new private methods here ....
	 * 
	 *
	 *************************************************/

	private boolean royalPair() {
		int seeJack = 0;
		int seeQueen = 0;
		int seeKing = 0;
		int seeAce = 0;

		for (int x = 0; x < currentHand.size(); x++) {
			if (currentHand.get(x).getRank() == 11) {
				seeJack++;
			}
			if (currentHand.get(x).getRank() == 12) {
				seeQueen++;
			}
			if (currentHand.get(x).getRank() == 13) {
				seeKing++;
			}
			if (currentHand.get(x).getRank() == 1) {
				seeAce++;
			}
		}
		return seeJack == 2 || seeQueen == 2 || seeKing == 2 | seeAce == 2;
	}

	private boolean twoPair(List<Integer> m) {

		int countPair = 0;
		for (int i = 0; i < m.size() - 1; i++) {
			if (m.get(i) == m.get(i + 1)) {
				countPair++;
				i += 2;
			}
		}
		return countPair == 2;
	}

	private boolean threeOfAKind(List<Integer> e) {
		int countThree = 0;
		for (int x = 0; x < e.size() - 2; x++) {
			if ((e.get(x) == e.get(x + 1)) && (e.get(x) == e.get(x + 2))) {
				countThree++;
			}
		}
		return countThree == 1;
	}

	private boolean fourOfAKind(List<Integer> k) {

		int countFour = 0;
		for (int x = 0; x < k.size() - 3; x++) {
			if ((k.get(x) == k.get(x + 1)) && (k.get(x) == k.get(x + 2)) && k.get(x) == k.get(x + 3)) {
				countFour++;
			}
		}
		return countFour == 1;
	}

	private boolean fullHouse(List<Integer> g) {
		int countIfThree = 0;
		int countIfTwo = 0;
		if (((g.get(0) == g.get(1)) && (g.get(0) == g.get(2)))) {
			for (int x = 0; x < g.size() - 2; x++) {
				if ((g.get(x) == g.get(x + 1)) && (g.get(x) == g.get(x + 2))) {
					countIfThree++;
				}
			}
			if (countIfThree == 1) {
				for (int i = 3; i <= g.size() - 2; i++) {
					if (g.get(i) == g.get(i + 1)) {
						countIfTwo++;

					}
				}
			} else {
				for (int d = 0; d < g.size() - 3; d++) {
					if (g.get(d) == g.get(d + 1)) {
						countIfTwo++;
					}
					if (countIfTwo == 1) {
						for (int e = 2; e < g.size() - 2; e++) {
							if ((g.get(e) == g.get(e + 1)) && (g.get(e) == g.get(e + 2))) {
								countIfThree++;
							}
						}

					}
				}
			}

		}
		return (countIfThree == 1 && countIfTwo == 1);
	}

	private boolean straight(List<Integer> n) {
		int countStraight = 0;
		for (int x = 0; x < n.size() - 1; x++) {
			if ((n.get(x) + 1) == (n.get(x + 1))) {
				countStraight++;
			}
		}
		return countStraight == 4;
	}

	private boolean flush() {
		int countFlush = 0;
		for (int x = 0; x < currentHand.size() - 1; x++) {
			if (currentHand.get(x).getSuit() == currentHand.get(x + 1).getSuit()) {
				countFlush++;
			}
		}
		return countFlush == 4;
	}

	private boolean straightFlush(List<Integer> p) {

		return flush() && straight(p);
	}

	private boolean royalFlush() {
		int countTen = 0;
		int countJack = 0;
		int countQueen = 0;
		int countKing = 0;
		int countAce = 0;
		for (int x = 0; x < currentHand.size(); x++) {
			if (currentHand.get(x).getRank() == 10) {
				countTen++;
			}
			if (currentHand.get(x).getRank() == 11) {
				countJack++;
			}
			if (currentHand.get(x).getRank() == 12) {
				countQueen++;
			}
			if (currentHand.get(x).getRank() == 13) {
				countKing++;
			}
			if (currentHand.get(x).getRank() == 1) {
				countAce++;
			}
		}
		return (countTen == 1 && countJack == 1 && countQueen == 1 && countKing == 1 && countAce == 1 && flush());
	}

	private void displayHand() {
		System.out.println(currentHand);
	}

	private void changeHand() {

		Scanner scp = new Scanner(System.in);
		System.out.println("\nEnter positions of cards to keep (e.g. 1 4 5 )");
		List<Card> keptCard = new ArrayList<Card>();
		List<Card> deal = new ArrayList<Card>();
		String tokens = scp.nextLine();
		Scanner scf = new Scanner(tokens);
		scf = scf.useDelimiter("\\s*");
		while (scf.hasNext()) {
			String numstring = scf.findInLine("\\d+");
			int a = Integer.parseInt(numstring);
			if (a != 0) {
				keptCard.add(currentHand.get(a - 1));
			}

		}
		int count = 5;
		int counter = keptCard.size();
		while (count > counter) {
			try {
				deal = oneDeck.deal(1);
			} catch (MyPlayingCardException e) {
				e.printStackTrace();
			}
			keptCard.add(deal.get(0));
			count--;
		}
		currentHand = keptCard;
		displayHand();

	}

	public void play() {
		showPayoutTable();
		boolean swag = true;
		while (swag) {
			System.out.println("Your current balance is: $" + balance);

			boolean checkbet = true;
			while (checkbet) {
				System.out.println("How much would you like to bet?");
				bet = sc.nextInt();
				if (startingBalance >= bet && bet >= 0) {
					System.out.println("You have placed a bet of: $" + bet);
					balance = (balance - bet);
					checkbet = false;
				} else {
					System.out.println("You do not have enough $$ to bet");
				}

			}

			oneDeck.reset();
			oneDeck.shuffle();
			currentHand = new ArrayList<Card>();
			try {
				currentHand = oneDeck.deal(numberOfCards);
			} catch (MyPlayingCardException e) {
				e.printStackTrace();
			}
			displayHand();

			changeHand();

			checkHands();

			System.out.print("Your updated balance is: $" + balance);

			if (balance == 0) {
				swag = false;
			} else {
				System.out.println("\nWould you like to bet again?  press [y] for yes, press [n] to end program");
				String choice = sc.next();
				if (choice.equals("n")) {
					swag = false;
				} else {
					System.out.println(
							"Would you like to see the payout table again? press [y] for yes, press [n] for no");
					String paychoice = sc.next();
					if (paychoice.equals("y")) {
						showPayoutTable();
					}
				}
			}

		}

		/**
		 * The main algorithm for single player poker game
		 *
		 * Steps: showPayoutTable()
		 *
		 * ++ show balance, get bet verify bet value, update balance reset deck,
		 * shuffle deck, deal cards and display cards ask for position of cards
		 * to keep get positions in one input line update cards check hands,
		 * display proper messages update balance if there is a payout if
		 * balance = O: end of program else ask if the player wants to play a
		 * new game if the answer is "no" : end of program else :
		 * showPayoutTable() if user wants to see it goto ++
		 */

		// implement this method!
	}

	/**
	 * Do not modify this. It is used to test checkHands() method checkHands()
	 * should print your current hand type
	 */
	public void testCheckHands() {
		try {
			currentHand = new ArrayList<Card>();

			// set Royal Flush
			currentHand.add(new Card(1, 3));
			currentHand.add(new Card(10, 3));
			currentHand.add(new Card(12, 3));
			currentHand.add(new Card(11, 3));
			currentHand.add(new Card(13, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Straight Flush
			currentHand.set(0, new Card(9, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Straight
			currentHand.set(4, new Card(8, 1));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Flush
			currentHand.set(4, new Card(5, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// "Royal Pair" , "Two Pairs" , "Three of a Kind", "Straight",
			// "Flush ",
			// "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"
			// };

			// set Four of a Kind
			currentHand.clear();
			currentHand.add(new Card(8, 3));
			currentHand.add(new Card(8, 0));
			currentHand.add(new Card(12, 3));
			currentHand.add(new Card(8, 1));
			currentHand.add(new Card(8, 2));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Three of a Kind
			currentHand.set(4, new Card(11, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Full House
			currentHand.set(2, new Card(11, 1));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Two Pairs
			currentHand.set(1, new Card(9, 1));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Royal Pair
			currentHand.set(0, new Card(3, 1));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// non Royal Pair
			currentHand.set(2, new Card(3, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Quick testCheckHands() */
	public static void main(String args[]) {
		MyPokerGame mypokergame = new MyPokerGame();
		mypokergame.testCheckHands();
	}
}
