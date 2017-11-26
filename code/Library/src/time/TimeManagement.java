package time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.LibraryConstants;
import libraryutils.Connect;

public class TimeManagement implements LibraryConstants{
	
	public static void newDay(){
		//updateBookTimes();
		//updateFines();
	}
	
	private void updateFines(){
		
	}
	
	private void updateHoldPickup(){
		
	}
	

	/* wont work with new way
	public static boolean updateBookTimes(){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement gt = conn.prepareStatement("SELECT DaysCheckedOut,PIN_Code FROM Books WHERE PIN_Code != ?");    
			gt.setString(1, "0");
			ResultSet rs = gt.executeQuery();
			while(rs.next()) {
				String pin = rs.getString("PIN_Code");
				int days = rs.getInt("DaysCheckedOut");
				PreparedStatement st = conn.prepareStatement("UPDATE Books SET DaysCheckedOut= ? WHERE PIN_Code = ?");
				st.setString(1, Integer.toString(days + 1));
				st.setString(2, pin);
				st.executeUpdate();
			}
		    } catch(Exception e){
		    	System.out.print(e);
		    	return false;
		    }			
		return true;
	}
	*/
	
	/* doesn't work with new way of doing it
	public static boolean updateFines(){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement gt = conn.prepareStatement("SELECT DaysCheckedOut,PIN_Code FROM Books WHERE PIN_Code != ?");    
			gt.setString(1, "0");
			ResultSet rs = gt.executeQuery();
			while(rs.next()) {
				String pin = rs.getString("PIN_Code");
				int days = rs.getInt("DaysCheckedOut");
				if(days > 10) {
					PreparedStatement ht = conn.prepareStatement("SELECT fees FROM Members WHERE PIN_Code = ?");
					ht.setString(1, pin);
					ResultSet hs = ht.executeQuery();
					hs.next();
					double currentFees = hs.getDouble("Fees");
					PreparedStatement st = conn.prepareStatement("UPDATE Members SET Fees= ? WHERE PIN_Code = ?");
					//right number?
					st.setString(1, Double.toString(currentFees + LATE_FEE));
					st.setString(2, pin);
					st.executeUpdate();
				}
			}
		    } catch(Exception e){
		    	System.out.print(e);
		    	return false;
		    }			
		return true;
	}
	*/
	
	/*
	public static Date getTime(){
		
	} */
	
}
