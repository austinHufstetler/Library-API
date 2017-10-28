package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import libraryutils.Connect;

public class Member extends User {

	
	public Member(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, "member", username, password);
		// TODO Auto-generated constructor stub
	}
	
	//constructor for already created members, used when getting back member objects
	public Member(String firstName, String lastName, String username, String password, String pin) {
		super(firstName, lastName, "member", username, password, pin);
		// TODO Auto-generated constructor stub
	}

	//getters and setters
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	//actions methods
	
	private static void renewBook(){
		
	}
	
	private static void reportLostBook(){
		
	}
	
	
	private static void displayCheckedOutBooks(){
		
	}
	
	private static void displayFines(){
		
	}
	

	
	
	
	



}
