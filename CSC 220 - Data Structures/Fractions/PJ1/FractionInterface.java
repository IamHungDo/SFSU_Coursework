/* This file specifies methods for FractionInterface		*/
/* Do not modify this file!!                  			*/

package PJ1;

public interface FractionInterface 
{
	/** Task: Sets a fraction to a given value.
	 *  @param numerator  the integer numerator
	 *  @param denominator  the integer denominator
         *  @throws FractionException if denominator=0 */
	public void setFraction(int numerator, int denominator);

	/** Task: Convert a fraction to double value
	 *  @return the double floating point value of a fraction */
	public double toDouble();

	/** Task: Adds two fractions.
	 *  @param secondFraction a fraction that is the second operand of the addition
	 *  @return a fraction which is the sum of the invoking fraction and the secondFraction */
	public FractionInterface add(FractionInterface secondFraction);

	/** Task: Subtracts two fractions.
	 *  @param secondFraction a fraction that is the second operand of the subtraction
	 *  @return a fraction which is the difference of the invoking fraction and the second operand */
	public FractionInterface subtract(FractionInterface secondFraction);

	/** Task: Multiplies two fractions.
	 *  @param secondFraction a fraction that is the second operand of the multiplication
	 *  @return a fraction which is the product of the invoking fraction and the secondFraction*/
	public FractionInterface multiply(FractionInterface secondFraction);

	/** Task: Divides two fractions.
	 *  @param secondFraction a fraction that is the second operand of the division
	 *  @return a fraction which the quotient of the invoking fraction and the secondFraction
         *  @throws FractionException if secondFraction=0 */
	public FractionInterface divide(FractionInterface secondFraction);

	/** Task: Get's the fraction's reciprocal
	 *  @return the reciprocal of the invoking fraction 
         *  @throws FractionException if the new number with denominator=0*/
	public FractionInterface getReciprocal();

}
