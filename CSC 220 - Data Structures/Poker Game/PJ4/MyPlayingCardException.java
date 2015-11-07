package PJ4;

import java.util.*;

/**
 * class MyPlayingCardException: It is used for errors related to Card and Deck
 * objects Do not modify this class!
 */
class MyPlayingCardException extends Exception {

	/* Constructor to create a MyPlayingCardException object */
	MyPlayingCardException() {
		super();
	}

	MyPlayingCardException(String reason) {
		super(reason);
	}
}
