package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import users.SuspensionManagement;
import users.UserInformation;
import common.LibraryConstants;

//maybe delete? maybe need?
import java.util.Currency;

import libraryutils.Connect;

public class FineManagement {
	
	public static double getFines(String username){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement st = conn.prepareStatement("SELECT Fees FROM Members WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			double fine = rs.getDouble("Fees");
			return fine;
		    } catch(Exception e){
		    	System.out.print(e);
		    	return 0.0;
		    }		
	}	
	
	public static void payFines(String username, double amountPaid){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement gt = conn.prepareStatement("SELECT Fees FROM Members WHERE Username = ?");  
			gt.setString(1, username);    
			ResultSet rs = gt.executeQuery();
			rs.next();
			double fine = rs.getDouble("Fees");
			PreparedStatement st = conn.prepareStatement("UPDATE Members SET Fees= ? WHERE Username = ?");
			st.setString(1, Double.toString(fine - amountPaid));
			st.setString(2, username);
			st.executeUpdate();
			if(UserInformation.isSuspended(username) && UserInformation.getReasonSuspended(username) == 1 && (fine - amountPaid) < LibraryConstants.ALLOWABLE_FINES){
				SuspensionManagement.unsuspendMember(username);
			}
			
		    } catch(Exception e){
		    	System.out.print(e);
		    }		
	}	
	
	public static void issueFines(String username, double amount){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement gt = conn.prepareStatement("SELECT Fees FROM Members WHERE Username = ?");  
			gt.setString(1, username);    
			ResultSet rs = gt.executeQuery();
			rs.next();
			double fine = rs.getDouble("Fees");
			PreparedStatement st = conn.prepareStatement("UPDATE Members SET Fees= ? WHERE Username = ?");
			st.setString(1, Double.toString(fine + amount));
			st.setString(2, username);
			st.executeUpdate();		
			if(fine + amount > LibraryConstants.ALLOWABLE_FINES){
				SuspensionManagement.suspendMember(username, LibraryConstants.SUSPENDED_FINES);
			}
		    } catch(Exception e){
		    	System.out.print(e);
		    }			
	}
	
}
