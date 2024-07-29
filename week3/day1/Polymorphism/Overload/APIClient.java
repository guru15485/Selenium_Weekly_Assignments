package week3.day1.Polymorphism.Overload;

public class APIClient {
	/*
	 * This program is to understand and implement the concept of Overloading in Java by creating a class and implementing methods with 
		different sets of input arguments
	 */

	public String sendRequest(String endpoint) {
		return endpoint;

	}
	public void sendRequest(String endpoint,String requestBody, boolean requestStatus)
	{
		System.out.println("The endpoint is - "+endpoint);
		System.out.println("The Rewuest body is - "+requestBody);
		System.out.println("The request Status is - "+requestStatus);
	}
	
	public static void main(String[] args) {
		APIClient apiclt=new APIClient();
		apiclt.sendRequest("Hello");
		apiclt.sendRequest("Bye", "Selenium", true);
	}
}
