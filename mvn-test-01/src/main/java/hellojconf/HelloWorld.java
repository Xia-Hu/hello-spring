package hellojconf;

public class HelloWorld {

	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		System.out.println("Your message: " + this.message);
		return message;
	}
	
}
