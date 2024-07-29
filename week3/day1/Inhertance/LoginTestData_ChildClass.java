package week3.day1.Inhertance;

public class LoginTestData_ChildClass extends TestData_SuperClass{
	
	public void enterUsername() {
		System.out.println("This is method - enterUsername from Child class");

	}
	
	public void enterPassword() {
		System.out.println("This is method - enterPassword from Child class");

	}				

	public static void main(String[] args) 
	{
		
		LoginTestData_ChildClass testData=new LoginTestData_ChildClass();
		testData.enterCredentials();
		testData.navigateToHomePage();
		
		testData.enterUsername();
		testData.enterPassword();

	}

}
