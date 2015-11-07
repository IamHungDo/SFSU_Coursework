package PJ4;

import java.util.*;

/**
 * class Card : for creating playing card objects it is an immutable class. Rank
 * - valid values are 1 to 13 Suit - valid values are 0 to 3 Do not modify this
 * class!
 */
class Card {

	/* constant suits and ranks */
	static final String[] Suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static final String[] Rank = { "", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	/* Data field of a card: rank and suit */
	private int cardRank; /* values: 1-13 (see Rank[] above) */
	private int cardSuit; /* values: 0-3 (see Suit[] above) */

	/* Constructor to create a card */
	/* throw MyPlayingCardException if rank or suit is invalid */
	public Card(int rank, int suit) throws MyPlayingCardException {
		if ((rank < 1) || (rank > 13))
			throw new MyPlayingCardException("Invalid rank:" + rank);
		else
			cardRank = rank;
		if ((suit < 0) || (suit > 3))
			throw new MyPlayingCardException("Invalid suit:" + suit);
		else
			cardSuit = suit;
	}

	/* Accessor and toString */
	/* You may impelemnt equals(), but it will not be used */
	public int getRank() {
		return cardRank;
	}

	public int getSuit() {
		return cardSuit;
	}

	public String toString() {
		return Rank[cardRank] + " " + Suit[cardSuit];
	}

	/* Few quick tests here */
	public static void main(String args[]) {
		try {
			Card c1 = new Card(1, 3); // A Spades
			System.out.println(c1);
			c1 = new Card(10, 0); // 10 Clubs
			System.out.println(c1);
			c1 = new Card(10, 5); // generate exception here
		} catch (MyPlayingCardException e) {
			System.out.println("MyPlayingCardException: " + e.getMessage());
		}
	}
}

/**
 * class Decks represents : n decks of 52 playing cards Use class Card to
 * construct n * 52 playing cards!
 *
 * Do not add new data fields! Do not modify any methods You may add private
 * methods
 */

class Decks {

	/* this is used to keep track of original n*52 cards */
	private List<Card> originalDecks;

	/* this starts with n*52 cards deck from original deck */
	/* it is used to keep track of remaining cards to deal */
	/* see reset(): it resets dealDecks to a full deck */
	private List<Card> dealDecks;

	/* number of decks in this object */
	private int numberDecks;

	/**
	 * Constructor: Creates default one deck of 52 playing cards in
	 * originalDecks and copy them to dealDecks. initialize numberDecks=n Note:
	 * You need to catch MyPlayingCardException from Card constructor Use
	 * ArrayList for both originalDecks & dealDecks
	 */
	public Decks() {

	}

	/**
	 * Constructor: Creates n decks (52 cards each deck) of playing cards in
	 * originalDecks and copy them to dealDecks. initialize numberDecks=n Note:
	 * You need to catch MyPlayingCardException from Card constructor Use
	 * ArrayList for both originalDecks & dealDecks
	 */
	public Decks(int n) {
		numberDecks = n;
		originalDecks = new ArrayList<Card>();
		for (int numDecks = 0; numDecks < numberDecks; numDecks++) {
			for (int Csuit = 0; Csuit <= 3; Csuit++) {
				for (int Crank = 1; Crank <= 13; Crank++) {
					try {
						originalDecks.add(new Card(Crank, Csuit));
					} catch (MyPlayingCardException i) {
						System.out.println("Try again");
					}

				}
			}
		}
		dealDecks = new ArrayList<Card>(originalDecks);

		// implement this method!
	}

	/**
	 * Task: Shuffles cards in deal deck. Hint: Look at java.util.Collections
	 */
	public void shuffle() {
		Collections.shuffle(dealDecks);
		// implement this method!
	}

	/**
	 * Task: Deals cards from the deal deck.
	 *
	 * @param numberCards
	 *            number of cards to deal
	 * @return a list containing cards that were dealt
	 * @throw MyPlayingCardException if numberCard > number of remaining cards
	 *
	 *        Note: You need to create ArrayList to stored dealt cards and
	 *        should removed dealt cards from dealDecks
	 *
	 */
	public List<Card> deal(int numberCards) throws MyPlayingCardException {

		List<Card> dealCard = new ArrayList<Card>();
		if (numberCards > dealDecks.size()) {
			throw new MyPlayingCardException("Not enough cards");
		}
		for (int x = 0; x < numberCards; x++) {
			dealCard.add(dealDecks.remove(0));

		}
		return dealCard;

		// implement this method!
	}

	/**
	 * Task: Resets deal deck by getting all cards from the original deck.
	 */
	public void reset() {
		dealDecks.clear();
		dealDecks.addAll(originalDecks);
	}

	/**
	 * Task: Return number of remaining cards in deal deck.
	 */
	public int remain() {
		return dealDecks.size();
	}

	/**
	 * Task: Returns a string representing cards in the deal deck
	 */
	public String toString() {
		return "" + dealDecks;
	}

	/* Quick test */
	/*                              */
	/* Do not modify these tests */
	/* Generate 2 decks of cards */
	/* Loop 2 times: */
	/* Deal 30 cards for 4 times */
	/* Expect exception last time */
	/* reset() */

	public static void main(String args[]) {

		System.out.println("*******    Create 2 decks of cards      *********\n\n");
		Decks decks = new Decks(2);

		for (int j = 0; j < 2; j++) {
			System.out.println("\n************************************************\n");
			System.out.println("Loop # " + j + "\n");
			System.out.println("Before shuffle:" + decks.remain() + " cards");
			System.out.println("\n\t" + decks);
			System.out.println("\n==============================================\n");

			int numHands = 4;
			int cardsPerHand = 30;

			for (int i = 0; i < numHands; i++) {
				decks.shuffle();
				System.out.println("After shuffle:" + decks.remain() + " cards");
				System.out.println("\n\t" + decks);
				try {
					System.out.println("\n\nHand " + i + ":" + cardsPerHand + " cards");
					System.out.println("\n\t" + decks.deal(cardsPerHand));
					System.out.println("\n\nRemain:" + decks.remain() + " cards");
					System.out.println("\n\t" + decks);
					System.out.println("\n==============================================\n");
				} catch (MyPlayingCardException e) {
					System.out.println("*** In catch block : MyPlayingCardException : msg : " + e.getMessage());
				}
			}

			decks.reset();
		}
	}

}
