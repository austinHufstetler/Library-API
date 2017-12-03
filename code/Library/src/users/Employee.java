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

	public void returnBooks(Member m){
		
	}
	
	public double returnFines(Member m){
		return m.getFines();
	}
	
	//MEMBERS
	public void addMember(Member m){
		UserManagement.createMember(m);
	}
	
	public void removeMember(Member m){
		UserManagement.deleteMember(m.username);
	}
	
	private void editMember(Member m, int id){
		UserManagement.updateMember(m, id);
	}
	
	
}
