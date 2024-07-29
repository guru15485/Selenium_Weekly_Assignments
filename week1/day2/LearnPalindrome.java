package week1.day2;

public class LearnPalindrome {

	public static void main(String[] args) {

		int input = 121;
		int rem = 0;
		int output = 0;
		int temp = input;

		for (int i = temp; i > 0;) {
			rem = temp % 10;
			output = (output * 10) + rem;
			temp = temp / 10;
			i = i / 10;
		}
		if (output == input) {
			System.out.println("The number - " + input + " is Palindrome");

		} else
			System.out.println("The number - " + input + " is not Palindrome");

	}

}
