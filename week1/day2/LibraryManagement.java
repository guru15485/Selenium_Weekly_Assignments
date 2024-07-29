package week1.day2;

public class LibraryManagement {

	public static void main(String[] args) {
		
		Library_LearnMethodsObjects lib=new Library_LearnMethodsObjects();
		
		String bookName = lib.addBook("Python With Selenium");
		
		System.out.println(bookName);
		
		lib.issueBook();

	}

}
