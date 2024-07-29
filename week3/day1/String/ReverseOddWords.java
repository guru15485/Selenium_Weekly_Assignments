package week3.day1.String;

public class ReverseOddWords {
	/*
	 *This is program is to understand the concepts of String manipulation to build a logic to reverse the odd position words
	 */

	public static void main(String[] args) {

		String test = "I am a software tester";

		// split the String to String[] by using the method split
		String[] words = test.split(" ");
		int len = words.length;
		
		String revString = "";
		
		System.out.println("The input String - "+test);
		for (int i = 0; i <len; i++) 
		{
			if (i%2==0) 	
			{
				revString=revString+words[i]+" ";
			} 
			else 
			{
				String output = "";
				char[] oddWord = words[i].toCharArray();
				for (int j = oddWord.length-1; j >= 0; j--) 
				{
					output=output+oddWord[j];
					
				}
				revString=revString+output+" ";
			}
			
		}
//		revString=revString+output+" ";
		System.out.print("The output string with the odd words reversal - "+revString);

	}

}
