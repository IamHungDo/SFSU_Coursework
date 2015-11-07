/************************************************************************************
 *
 *  		CSC220 Programming Project#2
 *  
 * Due Date: 23:55pm, Thursday, 11/6/2014  
 *           Upload SimpleLispExpressionEvaluator.java to ilearn 
 *
 * Specification: 
 *
 * Taken from Project 6, Chapter 5, Page 137
 * I have modified specification and requirements of this project
 *
 * Ref: http://www.gigamonkeys.com/book/        (see chap. 10)
 *      http://joeganley.com/code/jslisp.html   (GUI)
 *
 * In the language Lisp, each of the four basic arithmetic operators appears 
 * before an arbitrary number of operands, which are separated by spaces. 
 * The resulting expression is enclosed in parentheses. The operators behave 
 * as follows:
 *
 * (+ a b c ...) returns the sum of all the operands, and (+ a) returns a.
 *
 * (- a b c ...) returns a - b - c - ..., and (- a) returns -a. 
 *
 * (* a b c ...) returns the product of all the operands, and (* a) returns a.
 *
 * (/ a b c ...) returns a / b / c / ..., and (/ a) returns 1/a. 
 *
 * Note: + * - / must have at least one operand
 *
 * You can form larger arithmetic expressions by combining these basic 
 * expressions using a fully parenthesized prefix notation. 
 * For example, the following is a valid Lisp expression:
 *
 * 	(+ (- 6) (* 2 3 4) (/ (+ 3) (* 1) (- 2 3 1)) (+ 1))
 *
 * This expression is evaluated successively as follows:
 *
 *	(+ (- 6) (* 2 3 4) (/ 3 1 -2) (+ 1))
 *	(+ -6 24 -1.5 1)
 *	17.5
 *
 * Requirements:
 *
 * - Design and implement an algorithm that uses Java API stacks to evaluate a 
 *   valid Lisp expression composed of the four basic operators and integer values. 
 * - Valid tokens in an expression are '(',')','+','-','*','/',and positive integers (>=0)
 * - Display result as floting point number with at 2 decimal places
 * - Negative number is not a valid "input" operand, e.g. (+ -2 3) 
 *   However, you may create a negative number using parentheses, e.g. (+ (-2)3)
 * - There may be any number of blank spaces, >= 0, in between tokens
 *   Thus, the following expressions are valid:
 *   	(+   (-6)3)
 *   	(/(+20 30))
 *
 * - Must use Java API Stack class in this project.
 *   Ref: http://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 * - Must throw LispException to indicate errors
 * - Must not add new or modify existing data fields
 * - Must implement these methods : 
 *
 *   	public SimpleLispExpressionEvaluator()
 *   	public SimpleLispExpressionEvaluator(String inputExpression) 
 *      public void reset(String inputExpression) 
 *      public double evaluate()
 *      private void evaluateCurrentOperation()
 *
 * - You may add new private methods
 *
 *************************************************************************************/

package PJ2;

import java.util.*;

public class SimpleLispExpressionEvaluator {
	// Current input Lisp expression
	private String inputExpr;

	// Main expression stack & current operation stack, see algorithm in
	// evaluate()
	private Stack<Object> exprStack;
	private Stack<Double> opStack;

	// default constructor
	// set inputExpr to ""
	// create stack objects
	public SimpleLispExpressionEvaluator() {
		inputExpr = "";
		exprStack = new Stack<Object>();
		opStack = new Stack<Double>();
	}

	// constructor with an input expression
	// set inputExpr to inputExpression
	// create stack objects
	public SimpleLispExpressionEvaluator(String inputExpression) {
		inputExpr = inputExpression;
		exprStack = new Stack<Object>();
		opStack = new Stack<Double>();

	}

	// set inputExpr to inputExpression
	// clear stack objects
	public void reset(String inputExpression) {
		inputExpr = inputExpression;
		exprStack.clear();
		opStack.clear();
	}

	// This function evaluates current operator with its operands
	// See complete algorithm in evaluate()
	//
	// Main Steps:
	// Pop operands from exprStack and push them onto
	// opStack until you find an operator
	// Apply the operator to the operands on opStack
	// Push the result into exprStack
	//

	private void evaluateCurrentOperation() {

		if (exprStack.isEmpty()) {
			throw new LispException("The exprStack is empty");
		}

		double result;
		Object ex = exprStack.pop();
		if (!ex.equals(ex.toString())) {
			throw new LispException("No number to compute with");
		}
		try {
			while (ex.equals(ex.toString())) {
				opStack.push(Double.parseDouble(ex.toString()));
				ex = exprStack.pop();
			}
		} catch (EmptyStackException e) {
			throw new LispException("*ERROR*. The stack is empty!!!");
		}
		String derp = ex.toString();

		switch (derp) {

		case "+":
			result = 0;
			while (!opStack.isEmpty()) {
				result += opStack.pop();
			}
			exprStack.push(Double.toString(result));
			break;

		case "-":
			result = opStack.pop();
			if (opStack.isEmpty()) {
				result = -result;
			} else
				while (!opStack.isEmpty()) {
					result -= opStack.pop();
				}
			exprStack.push(Double.toString(result));
			break;

		case "*":
			result = 1;
			while (!opStack.isEmpty()) {
				result *= opStack.pop();
			}
			exprStack.push(Double.toString(result));
			break;
		case "/":
			result = opStack.pop();
			if (opStack.isEmpty()) {
				result = (1 / result);
			}
			while (!opStack.isEmpty()) {
				result /= opStack.pop();
			}
			exprStack.push(Double.toString(result));
			break;

		}

	}

	/**
	 * This funtion evaluates current Lisp expression in inputExpr It return
	 * result of the expression
	 *
	 * The algorithm:
	 *
	 * Step 1 Scan the tokens in the string. Step 2 If you see an operand, push
	 * operand object onto the exprStack Step 3 If you see "(", next token
	 * should be an operator Step 4 If you see an operator, push operator object
	 * onto the exprStack Step 5 If you see ")" // steps in
	 * evaluateCurrentOperation() : Step 6 Pop operands and push them onto
	 * opStack until you find an operator Step 7 Apply the operator to the
	 * operands on opStack Step 8 Push the result into exprStack Step 9 If you
	 * run out of tokens, the value on the top of exprStack is is the result of
	 * the expression.
	 */
	public double evaluate() {
		double result = 0.0;
		// only outline is given...
		// you need to add statements/local variables
		// you may delete or modify any statements in this method

		// use scanner to tokenize inputExpr
		Scanner inputExprScanner = new Scanner(inputExpr);

		// Use zero or more white space as delimiter,
		// which breaks the string into single character tokens
		inputExprScanner = inputExprScanner.useDelimiter("\\s*");

		// Step 1: Scan the tokens in the string.
		while (inputExprScanner.hasNext()) {
			// Step 2: If you see an operand, push operand object onto the
			// exprStack
			if (inputExprScanner.hasNextInt()) {

				// This force scanner to grab all of the digits
				// Otherwise, it will just get one char
				String dataString = inputExprScanner.findInLine("\\d+");
				exprStack.push(dataString);
				// more ...
			} else {
				// Get next token, only one char in string token
				String aToken = inputExprScanner.next();
				// System.out.println("Other: " + aToken);
				char item = aToken.charAt(0);

				switch (item) {
				case '(':
					break;

				case '+':
					exprStack.push('+');
					break;

				case '-':
					exprStack.push('-');
					break;

				case '*':
					exprStack.push('*');
					break;

				case '/':
					exprStack.push('/');
					break;

				case ')':
					evaluateCurrentOperation();
					break;

				// Step 3: If you see "(", next token shoube an operator
				// Step 4: If you see an operator, push operator object onto the
				// exprStack
				// Step 5: If you see ")" // steps in evaluateCurrentOperation()
				// :
				default: // error
					throw new LispException(item + " is not a legal expression operator");
				} // end switch
			} // end else
		} // end while

		// Step 9: If you run out of tokens, the value on the top of exprStack
		// is
		// is the result of the expression.
		//
		// return result

		return Double.parseDouble(exprStack.pop().toString());
	}

	// =====================================================================
	// DO NOT MODIFY ANY STATEMENTS BELOW
	// =====================================================================

	// This static method is used by main() only
	private static void evaluateExprTest(String s, SimpleLispExpressionEvaluator expr, String expect) {
		Double result;
		System.out.println("Expression " + s);
		System.out.printf("Expected result : %s\n", expect);
		expr.reset(s);
		try {
			result = expr.evaluate();
			System.out.printf("Evaluated result : %.2f\n", result);
		} catch (LispException e) {
			System.out.println("Evaluated result :" + e);
		}

		System.out.println("-----------------------------");
	}

	// define few test cases, exception may happen
	public static void main(String args[]) {
		SimpleLispExpressionEvaluator expr = new SimpleLispExpressionEvaluator();
		String test1 = "(+ (- 6) (* 2 3 4) (/ (+ 3) (* 1) (- 2 3 1)) (+ 0))";
		String test2 = "(+ (- 632) (* 21 3 4) (/ (+ 32) (* 1) (- 21 3 1)) )";
		String test3 = "(+ (/ 2) (* 2) (/ (+ 1) (+ 1) (- 2 1 )) (/ 1))";
		String test4 = "(+ (/2)(+))";
		String test5 = "(+ (/2 3 0))";
		String test6 = "(+ (/ 2) (* 2) (/ (+ 1) (+ 3) (- 2 1 ))))";
		evaluateExprTest(test1, expr, "16.50");
		evaluateExprTest(test2, expr, "-378.12");
		evaluateExprTest(test3, expr, "4.50");
		evaluateExprTest(test4, expr, "LispException");
		evaluateExprTest(test5, expr, "Infinity or LispException");
		evaluateExprTest(test6, expr, "LispException");
	}
}
