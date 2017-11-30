package users;

import java.sql.Connection;
import java.sql.PreparedStatement;

import libraryutils.Connect;

public abstract class Employee extends User {

	public Employee(String firstName, String lastName, String role, String username, String password, String address, String phoneNumber) {
		super(firstName, lastName, role, username, password, address, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	
	//getting back already made employees
	public Employee(String firstName, String lastName, String role, String username, String password, String address, String phoneNumber, String pin) {
		super(firstName, lastName, role, username, password, address, phoneNumber, pin);
		// TODO Auto-generated constructor stub
	}
	
	//action methods
	private static void addMember(String firstName, String lastName, String username, String password, String address, String phoneNumber){
		//temporary until we make generatePin() method
		Member m = new Member(firstName, lastName, username, password, address, phoneNumber);
		UserManagement.createMember(m);;
	}

	private static void displayBooks(Member m){
		
	}
	
	private static void displayFines(Member m){
		
	}
	
	
	
}
