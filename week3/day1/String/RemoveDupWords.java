package week3.day1.String;

public class RemoveDupWords {

	public static void main(String[] args) {
		
			String text = "We learn Java basics as part of java sessions in java week1";
			String[] str = text.split(" ");
			String[] words1 = text.split(" ");
			String[] words2 = text.split(" ");
			
			
			String output =" ";
			int i; 
			int j;
			
			for (i = 0; i < str.length; i++) 
			{
				int count=0;
			for ( j = 0; j < str.length; j++) 
			{
			if (str[i].equals(str[j])) 
			{
				count=count+1;
			}
			if (count>=2) 
			{
			words1[i]=" ";	
			}
			output = words1[i].toString();
			output=output+" ";
			}
//			System.out.print(words1[i]+" ");
			System.out.print(output);
			
			}
//			System.out.println(output);
			
	}

}
