package week1.day2;

public class Library_LearnMethodsObjects {

	public String addBook(String bookTitle) {

		System.out.println("Book added Sucessfully");

		return bookTitle;

	}

	public void issueBook() {

		System.out.println("Book issued Sucessfully");

	}

	public static void main(String[] args) {

		Library_LearnMethodsObjects books = new Library_LearnMethodsObjects();

		String addBook = books.addBook("Java With Selenium");

		System.out.println(addBook);

		books.issueBook();

	}

}
