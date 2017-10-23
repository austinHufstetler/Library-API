package users;

import java.sql.Connection;
import java.sql.PreparedStatement;

import libraryutils.Connect;

public abstract class Employee extends User {

	public Employee(String firstName, String lastName, String role, String username, String password) {
		super(firstName, lastName, role, username, password);
		// TODO Auto-generated constructor stub
	}
	
	//action methods
	private static void addMember(String firstName, String lastName, String username, String password){
		//temporary until we make generatePin() method
		Member m = new Member(firstName, lastName, username, password);
		UserManagement.createMember(m);;
	}

	public void checkoutBook(String isbn, String pin){
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Books SET PIN_Code= ? WHERE ISBN = " + isbn;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, pin);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 	
	}
	
	private static void displayBooks(Member m){
		
	}
	
	private static void displayFines(Member m){
		
	}
	
	
}
