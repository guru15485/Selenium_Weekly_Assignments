package week1.day2;

/*
 * the purpose of this program is to find the Fibonacci series of the given number range
 * Fibonacci series is a number series with the sum of its preceding two numbers 
 */

public class FibonacciSeries {

	public static void main(String[] args) {

		// declare the number range to find and print the Fibonacci series
		int num = 8;

		int n1 = 0;
		int n2 = 1;
		int n3;

		// print the number n1, n2 since these two numbers are the starting positive
		// numbers
		System.out.print(n1 + "," + n2);

		// initialize the for loop from 2 since n1, n2 are printed already
		for (int i = 2; i < num; i++) {
			n3 = n1 + n2; // add the preceding two numbers and store in n3 variable and print
			n1 = n2; // reallocate the n2 variable's current value to n1 variable
			n2 = n3; // reallocate the n3 variable's current value to n2 variable
			// print the Fibonacci series
			System.out.print("," + n3);
			// iterate the loop till the declared number range
		}
	}

}
