package week3.day2.LearnInterface;

public class JavaConnection implements DatabseConnection{

	@Override
	public void connect() {
		System.out.println("This is the implementaion method - connect from DatabseConnection Interface");
		
	}

	@Override
	public void disconnect() {
		System.out.println("This is the implementaion method - disconnect from DatabseConnection Interface");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("This is the implementaion method - executeUpdate from DatabseConnection Interface");
		
	}
	
	public static void main(String[] args) {
		JavaConnection jcDC=new JavaConnection();
		jcDC.connect();
		jcDC.disconnect();
		jcDC.executeUpdate();
	}

}
