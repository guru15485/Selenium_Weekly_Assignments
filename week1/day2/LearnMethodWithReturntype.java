package week1.day2;

public class LearnMethodWithReturntype {
	
	public int addBook(int num) {
		
		int num1=3;
		int num2=num1*num;
		
		return num2;

	}

	public static void main(String[] args) {
		
		LearnMethodWithReturntype obj=new LearnMethodWithReturntype();
		
		obj.addBook(2);

	}

}
