/*************************************************************************************
 *
 * This class represents a fraction whose numerator and denominator are integers.
 *
 * Requirements:
 *      Implement interfaces: FractionInterface and Comparable (i.e. compareTo())
 *      Implement methods equals() and toString() from class Object
 *
 *      Should work for both positive and negative fractions
 *      Must always reduce fraction to lowest term 
 *      For number such as 3/-10, it is same as -3/10 (see hints 2. below)
 *      Must display negative fraction as -x/y,
 *         example: (-3)/10 or 3/(-10), must display as -3/10
 *      Must throw only FractionExcpetion in case of errors
 *      Must not add new or modify existing data fields
 *      Must not add new public methods
 *      May add private methods
 *
 * Hints:
 *
 * 1. To reduce a fraction such as 4/8 to lowest terms, you need to divide both
 *    the numerator and the denominator by their greatest common denominator.
 *    The greatest common denominator of 4 and 8 is 4, so when you divide
 *    the numerator and denominator of 4/8 by 4, you get the fraction 1/2.
 *    The recursive algorithm which finds the greatest common denominator of
 *    two positive integers is implemnted (see code)
 *       
 * 2. It will be easier to determine the correct sign of a fraction if you force
 *    the fraction's denominator to be positive. However, your implementation must 
 *    handle negative denominators that the client might provide.
 *           
 * 3. You need to downcast reference parameter FractionInterface to Fraction if  
 *    you want to use it as Fraction. See add, subtract, multiply and divide methods
 *
 * 4. Use "this" to access this object if it is needed
 *
 ************************************************************************************/

package PJ1;

public class Fraction implements FractionInterface, Comparable<Fraction> {
	private int num; // Numerator
	private int den; // Denominator

	public Fraction() {
		setFraction(0, 1);
	}

	public Fraction(int numerator, int denominator) {
		num = numerator;
		den = denominator;
	}

	public void setFraction(int numerator, int denominator) {
		num = numerator;
		if (denominator == 0) {
			throw new FractionException();
		} else {
			den = denominator;
		}
	}

	public double toDouble() {
		double inttodoub;
		inttodoub = (double) num / den;
		return inttodoub;
	}

	public FractionInterface add(FractionInterface secondFraction) {
		Fraction e = new Fraction(num, den);
		Fraction i = (Fraction) secondFraction;

		int topresult;
		topresult = (e.num * i.den + i.num * e.den);
		int botresult;
		botresult = (i.den * e.den);
		int temp1 = 0;
		int gcd = topresult;
		int temp2 = botresult;
		while (temp2 != 0) {
			temp1 = gcd % temp2;
			gcd = temp2;
			temp2 = temp1;
		}
		int simfract1 = topresult / gcd;
		int simfract2 = botresult / gcd;
		e.setFraction(simfract1, simfract2);
		return e;
	}

	public FractionInterface subtract(FractionInterface secondFraction) {
		Fraction e = new Fraction(num, den);
		Fraction i = (Fraction) secondFraction;
		int topresult;
		topresult = (e.num * i.den - i.num * e.den);
		int botresult;
		botresult = (i.den * e.den);
		int temp1 = 0;
		int gcd = topresult;
		int temp2 = botresult;
		while (temp2 != 0) {
			temp1 = gcd % temp2;
			gcd = temp2;
			temp2 = temp1;
		}
		int simfract1 = topresult / gcd;
		int simfract2 = botresult / gcd;
		if (simfract2 < 0) {
			simfract1 = -1 * (simfract1);
			simfract2 = -1 * (simfract2);
		}
		e.setFraction(simfract1, simfract2);
		return e;
	}

	public FractionInterface multiply(FractionInterface secondFraction) {
		Fraction e = new Fraction(num, den);
		Fraction i = (Fraction) secondFraction;
		int topresult;
		topresult = (e.num * i.getnum());
		int botresult;
		botresult = (i.getden() * e.den);
		int temp1 = 0;
		int gcd = topresult;
		int temp2 = botresult;
		while (temp2 != 0) {
			temp1 = gcd % temp2;
			gcd = temp2;
			temp2 = temp1;
		}
		int simfract1 = topresult / gcd;
		int simfract2 = botresult / gcd;
		if (simfract2 < 0) {
			simfract1 = -1 * (simfract1);
			simfract2 = -1 * (simfract2);
		}
		e.setFraction(simfract1, simfract2);
		return e;
	}

	public FractionInterface divide(FractionInterface secondFraction) {
		if (num == 0) {
			throw new FractionException();
		} else {
			Fraction e = new Fraction(num, den);
			Fraction i = (Fraction) secondFraction;
			int topresult;
			topresult = (e.num * i.den);
			int botresult;
			botresult = (i.num * e.den);
			int temp1 = 0;
			int gcd = topresult;
			int temp2 = botresult;
			while (temp2 != 0) {
				temp1 = gcd % temp2;
				gcd = temp2;
				temp2 = temp1;
			}
			int simfract1 = topresult / gcd;
			int simfract2 = botresult / gcd;
			if (simfract2 < 0) {
				simfract1 = -1 * (simfract1);
				simfract2 = -1 * (simfract2);
			}
			e.setFraction(simfract1, simfract2);
			return e;
		}

		// return FractionException if secondFraction is 0
		// a/b / c/d is (ad)/(bc)
		// implement this method!
	} // end divide

	public FractionInterface getReciprocal() {
		if (num == 0) {
			throw new FractionException();
		} else {
			Fraction e = new Fraction(den, num);
			return e;
		}
	}

	public boolean equals(Object other) {
		Fraction e = new Fraction(num, den);
		Fraction i = (Fraction) other;
		int temp1 = 0;
		int gcd = e.num;
		int temp2 = e.den;
		while (temp2 != 0) {
			temp1 = gcd % temp2;
			gcd = temp2;
			temp2 = temp1;
		}
		int simfract1 = (e.num / gcd);
		int simfract2 = (e.den / gcd);

		int tem1 = 0;
		int gcdd = i.num;
		int tem2 = i.den;
		while (tem2 != 0) {
			tem1 = gcdd % tem2;
			gcdd = tem2;
			tem2 = tem1;
		}

		int simfract3 = (i.num / gcdd);
		int simfract4 = (i.den / gcdd);

		if (simfract1 == simfract3 && simfract2 == simfract4) {
			return true;
		} else {
			return false;
		}
	} // end equals

	public int compareTo(Fraction other) {
		Fraction e = new Fraction(num, den);
		Fraction i = (other);

		if ((e.num < i.num) && (e.den < i.den)) {
			return -1;
		} else if ((e.num < i.num) && (e.den < i.den)) {
			return 1;
		} else if ((e.num == i.num) && (e.den == i.den)) {
		} // end compareTo
		return 0;
	}

	public String toString() {
		return num + "/" + den;
	}

	/** Task: Reduces a fraction to lowest terms. */

	// -----------------------------------------------------------------
	// private methods start here
	// -----------------------------------------------------------------
	private int getnum() {
		return num;
	}

	private int getden() {
		return den;
	}

	private void reduceToLowestTerms() {
		int temp1 = 0;
		int gcd = num;
		int temp2 = den;
		while (temp2 != 0) {
			temp1 = gcd % temp2;
			gcd = temp2;
			temp2 = temp1;
		}
	}

	/**
	 * Task: Computes the greatest common secondFraction of two integers.
	 * 
	 * @param integerOne
	 *            an integer
	 * @param integerTwo
	 *            another integer
	 * @return the greatest common divisor of the two integers
	 */
	private int greatestCommonDivisor(int integerOne, int integerTwo) {
		int result;

		if (integerOne % integerTwo == 0)
			result = integerTwo;
		else
			result = greatestCommonDivisor(integerTwo, integerOne % integerTwo);

		return result;
	}

	// -----------------------------------------------------------------
	// Simple test is provided here

	public static void main(String[] args) {
		FractionInterface firstOperand = null;
		FractionInterface secondOperand = null;
		FractionInterface result = null;
		double doubleResult = 0.0;

		Fraction nineSixteenths = new Fraction(9, 16); // 9/16
		Fraction oneFourth = new Fraction(1, 4); // 1/4

		System.out.println("\n=========================================");
		// 7/8 + 9/16
		firstOperand = new Fraction(7, 8);
		result = firstOperand.add(nineSixteenths);
		System.out.println("The sum of " + firstOperand + " and " + nineSixteenths + " is \t\t" + result);

		// 9/16 - 7/8
		firstOperand = nineSixteenths;
		secondOperand = new Fraction(7, 8);
		result = firstOperand.subtract(secondOperand);
		System.out.println("The difference of " + firstOperand + " and " + secondOperand + " is \t" + result);

		// 15/-2 * 1/4
		firstOperand.setFraction(15, -2);
		result = firstOperand.multiply(oneFourth);
		System.out.println("The product of " + firstOperand + " and " + oneFourth + " is \t" + result);

		// (-21/2) / (3/7)
		firstOperand.setFraction(-21, 2);
		secondOperand.setFraction(3, 7);
		result = firstOperand.divide(secondOperand);
		System.out.println("The quotient of " + firstOperand + " and " + secondOperand + " is \t" + result);

		// -21/2 + 7/8
		firstOperand.setFraction(-21, 2);
		secondOperand.setFraction(7, 8);
		result = firstOperand.add(secondOperand);
		System.out.println("The sum of " + firstOperand + " and " + secondOperand + " is \t\t" + result);

		// 0/10, 5/(-15), (-22)/7
		firstOperand.setFraction(0, 10);
		doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand + " is \t" + doubleResult);
		firstOperand.setFraction(1, -3);
		doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand + " is \t" + doubleResult);
		firstOperand.setFraction(-22, 7);
		doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand + " is \t" + doubleResult);
		System.out.println("\n=========================================");
		firstOperand.setFraction(-21, 2);
		System.out.println("First = " + firstOperand);
		// equality check
		System.out.println("check First equals First: ");
		if (firstOperand.equals(firstOperand))
			System.out.println("Identity of fractions OK");
		else
			System.out.println("ERROR in identity of fractions");

		secondOperand.setFraction(-42, 4);
		System.out.println("\nSecond = " + secondOperand);
		System.out.println("check First equals Second: ");
		if (firstOperand.equals(secondOperand))
			System.out.println("Equality of fractions OK");
		else
			System.out.println("ERROR in equality of fractions");

		// comparison check
		Fraction first = (Fraction) firstOperand;
		Fraction second = (Fraction) secondOperand;

		System.out.println("\ncheck First compareTo Second: ");
		if (first.compareTo(second) == 0)
			System.out.println("Fractions == operator OK");
		else
			System.out.println("ERROR in fractions == operator");

		second.setFraction(7, 8);
		System.out.println("\nSecond = " + secondOperand);
		System.out.println("check First compareTo Second: ");
		if (first.compareTo(second) < 0)
			System.out.println("Fractions < operator OK");
		else
			System.out.println("ERROR in fractions < operator");

		System.out.println("\ncheck Second compareTo First: ");
		if (second.compareTo(first) > 0)
			System.out.println("Fractions > operator OK");
		else
			System.out.println("ERROR in fractions > operator");

		System.out.println("\n=========================================");

		System.out.println("\ncheck FractionException: 1/0");
		try {
			Fraction a1 = new Fraction(1, 0);
		} catch (FractionException fe) {
			System.err.printf("Exception: %s\n", fe);
		} // end catch

		System.out.println("\ncheck FractionException: division");
		try {
			Fraction a2 = new Fraction();
			Fraction a3 = new Fraction(1, 2);
			a3.divide(a2);
		} catch (FractionException fe) {
			System.err.printf("Exception: %s\n", fe);
		} // end catch

	} // end main
} // end Fraction
