package week1.day2;

public class FindOddAndEvenNumbers {
	
	/*
	 * This Program is to understand the mod operator, conditional statement and logic to solve
	 */

	public static void main(String[] args) {
		
		//declare the range to find the odd and even numbers
		int maxRange = 10;
		
		//initialize the for loop from 1 to the maxRange to find the odd and even numbers
		for (int i = 1; i <= maxRange; i++) {
			//initialize the if condition with mod(%) operator to find the odd and even numbers; if the number is modulo balance 1 means it is a odd number and 0 means even number 
			if (i % 2 == 1) {
				System.out.println("The number - " + i + " is a Odd number");

			} else
				System.out.println("The number - " + i + " is a Even number");

		}

	}

}
