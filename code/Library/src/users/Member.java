package users;
import java.util.Random;

public class Member extends User {
	
	String pin;
	
	public Member(String firstName, String lastName, String username, String password, String pin) {
		super(firstName, lastName, "member", username, password);
		// TODO Auto-generated constructor stub
		this.pin = pin;
	}

	//getters and setters
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	//actions methods
	private void checkoutBook(){
		
	}
<<<<<<< HEAD
	private String generatePINCode() {
		Random rand = new Random();
		int pin = rand.nextInt(89999)+10000;
		return "" + pin;
	}
=======
>>>>>>> master
	
	private void renewBook(){
		
	}
	
	private void reportLostBook(){
		
	}
	
	private void holdBook(){
		
	}
	
	private void displayCheckedOutBooks(){
		
	}
	
	private void displayFines(){
		
	}
	
	public static String generatePINCode() {
		Random rand = new Random();
		int pin = rand.nextInt(89999)+10000;
		return "" + pin;
	}
	
	
	
	



}
