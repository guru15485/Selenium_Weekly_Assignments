package week3.day1.String;

public class ChangeOddIndextoUppercase {

	public static void main(String[] args) {
			String test="changeme";
			char[] letter = test.toCharArray();
			String output="";
			
			for (int i = 0; i < letter.length; i++) {
//				String output="";
				if (i%2==0) 
				{
					output=output+letter[i];
				} 
				
				else 
					
				{
					char upperCase = Character.toUpperCase(letter[i]);
					output=output+upperCase;
				}
//				System.out.print(output);
				
			}	
			System.out.println("The input String - "+test);
			System.out.println("The String after odd index reversal - "+output);
	}

}
