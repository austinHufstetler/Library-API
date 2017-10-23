package libraryutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import users.UserManagement;

public class DuplicateChecker {
	public static boolean duplicateCheck(String pin) {
		return checkDuplicateEmployees(pin) | checkDuplicateMembers(pin);
	}
	
	private static boolean checkDuplicateEmployees(String pin){
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
		    	System.out.println("IGNORE " + e);
		    	return false;
		    }	
	}
	
	private static boolean checkDuplicateMembers(String pin){
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
		    	System.out.println("IGNORE " + e);
		    	return false;
		    }	
	}
}
