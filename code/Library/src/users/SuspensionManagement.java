package users;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.LibraryConstants;
import libraryutils.Connect;

public class SuspensionManagement {
	public static void suspendMember(String username, int reason){
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Members SET Suspended = True, Suspension_Reason = ? WHERE Username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, reason+"");
			st.setString(2, username);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 		
	}
	
	public static void unsuspendMember(String username){
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Members SET Suspended = False, Suspension_Reason = ? WHERE Username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, LibraryConstants.NOT_SUSPENDED + "");
			st.setString(2, username);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 		
	}
}
