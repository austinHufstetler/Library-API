package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.LibraryConstants;
import libraryutils.Connect;

public class UserSearch {

	//searches members (for use by associates and managers)
	public static ArrayList<Member> memberSearch(String search) {
		ArrayList<Member> list = new ArrayList<Member>();
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT * FROM Members WHERE "
					+ "UPPER(" +LibraryConstants.FIRST_NAME + ") LIKE UPPER(?) "
					+ "OR UPPER(" +LibraryConstants.LAST_NAME + ") LIKE UPPER(?) "
					+ "OR UPPER(" +LibraryConstants.PIN_CODE + ") LIKE UPPER(?) "
					+ "OR UPPER(" +LibraryConstants.USERNAME + ") LIKE UPPER(?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search + "%" );
			st.setString(2, "%" +search + "%" );
			st.setString(3, "%" +search + "%" );
			st.setString(4, "%" +search + "%" );
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Member result = UserManagement.getMember(rs.getString(LibraryConstants.USERNAME));
				/*
				result.setId(rs.getInt("ID"));
				result.setFirstName(rs.getString(LibraryConstants.FIRST_NAME));
				result.setLastName(rs.getString(LibraryConstants.LAST_NAME));
				result.setUsername(rs.getString(LibraryConstants.USERNAME));
				result.setPin(rs.getString(LibraryConstants.PIN_CODE));
				*/
				list.add(result);
			}

			return list;

		} catch(Exception e){
			e.printStackTrace(System.out);
			return null;
		}
	}
}
