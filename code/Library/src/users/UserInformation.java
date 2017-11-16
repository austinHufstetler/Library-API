package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import libraryutils.Connect;

public class UserInformation {

//this will be for getters, getting all info from users, method for each
	
	public static boolean isSuspended(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT Suspended FROM Members WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			boolean suspended = rs.getBoolean("Suspended");
			return suspended;
		    } catch(Exception e){
		    	System.out.println(e);
		    	return false;
		    }
		
	}
	
	public static int getReasonSuspended(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT Suspension_Reason FROM Members WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int reason = rs.getInt("Suspension_Reason");
			return reason;
		    } catch(Exception e){
		    	System.out.println(e);
		    	return 0;
		    }
		
	}
}
