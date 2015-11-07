/************************************************************************************
 * 
 * Do not modify this file.
 *
 * LispException class
 *
 * It is used by SimpleLispExpressionEvaluator 
 *
 *************************************************************************************/

package PJ2;

public class LispException extends RuntimeException {
	public LispException() {
		this("");
	}

	public LispException(String errorMsg) {
		super(errorMsg);
	}

}
