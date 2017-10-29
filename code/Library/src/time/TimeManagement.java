package time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import libraryutils.Connect;

public class TimeManagement {

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
	
}
