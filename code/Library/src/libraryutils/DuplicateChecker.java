package libraryutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.LibraryConstants;
import users.UserManagement;

public class DuplicateChecker {
	
	public static boolean duplicatePinCheck(String pin) {
		return checkDuplicatePinEmployees(pin) | checkDuplicatePinMembers(pin);
	}
	
	private static boolean checkDuplicatePinEmployees(String pin){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE PIN_Code= ?");    
			st.setString(1, pin);   
			ResultSet rs = st.executeQuery();
			rs.next();
			String comparePin = rs.getString("PIN_Code");
			if(comparePin.equals(pin))
				return true;
			else
				return false;
		    } catch(Exception e){
		    	//e.printStackTrace();
		    	return false;
		    }	
	}
	
	private static boolean checkDuplicatePinMembers(String pin){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Members WHERE PIN_Code= ?");    
			st.setString(1, pin);   
			ResultSet rs = st.executeQuery();
			rs.next();
			String comparePin = rs.getString("PIN_Code");
			if(comparePin.equals(pin))
				return true;
			else
				return false;
		    } catch(Exception e){
		    	//e.printStackTrace();
		    	return false;
		    }	
	}
	
	
	public static boolean duplicateUsernameCheck(String username) {
		return checkDuplicateUsernameEmployees(username) | checkDuplicateUsernameMembers(username);
	}
	
	private static boolean checkDuplicateUsernameEmployees(String username){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Members WHERE "+ LibraryConstants.USERNAME+ " = ?");   
			st.setString(1, username);   
			ResultSet rs = st.executeQuery();
			rs.next();
			String compareUsername = rs.getString(LibraryConstants.USERNAME);
			if(compareUsername.equals(username))
				return true;
			else
				return false;
		    } catch(Exception e){
		    	//e.printStackTrace();
		    	return false;
		    }	
	}
	
	private static boolean checkDuplicateUsernameMembers(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Members WHERE "+ LibraryConstants.USERNAME+ " = ?");    
			st.setString(1, username);   
			ResultSet rs = st.executeQuery();
			rs.next();
			String compareUsername = rs.getString(LibraryConstants.USERNAME);
			if(compareUsername.equals(username))
				return true;
			else
				return false;
		    } catch(Exception e){
		    	//e.printStackTrace();
		    	return false;
		    }	
	}
}
