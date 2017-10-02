package users;

import java.util.Random;

public class Member extends User {
	public Member(String firstName, String lastName, String role, String username, String password) {
		super(firstName, lastName, role, username, password);
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
	private static void checkoutBook(){
		
	}
	private String generatePINCode() {
		Random rand = new Random();
		int pin = rand.nextInt(100000);
		return "" + pin;
	}
	
	private static void renewBook(){
		
	}
	
	private static void reportLostBook(){
		
	}
	
	private static void holdBook(){
		
	}
	
	private static void displayCheckedOutBooks(){
		
	}
	
	private static void displayFines(){
		
	}
	
	
	
	



}
