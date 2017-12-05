package keywords;

import java.sql.*;
import java.util.ArrayList;

import books.Book;
import common.LibraryConstants;
import libraryutils.Connect;
import users.Associate;
import users.Member;
import libraryutils.Connect;

public class KeywordManagement implements LibraryConstants {



	public static void add(String keyword) {
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/WFH/Desktop/austin/EclipseProjects/software/group1/Library_DB.accdb");
			Connection conn = Connect.getConnection();
			String sql = "INSERT INTO Keywords ([Desc]) VALUES(?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, keyword);
			st.execute();
		} catch(Exception e){
			System.out.print(e);
		}
	}

	public static Keyword searchByKeyword(String keyword) {
		ArrayList<Keyword> list = new ArrayList<Keyword>();
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT * FROM Keywords WHERE Desc = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, keyword);
			ResultSet rs = st.executeQuery();
			rs.next();
			Keyword result = new Keyword(rs.getString("Desc"));
			result.setId(rs.getInt("ID"));
			return result;

		} catch(Exception e){
			System.out.print(e);
			return null;
		}
	}

	public static ArrayList<Keyword> searchById(int id) {
		ArrayList<Keyword> list = new ArrayList<Keyword>();
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT * FROM Keywords WHERE ID = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Keyword result = new Keyword(rs.getString("Desc"));
				list.add(result);
			}

			return list;

		} catch(Exception e){
			System.out.print(e);
			return null;
		}
	}
	public static void delete(String keyword){
		try{
			Connection conn = Connect.getConnection();
			String sql = "DELETE FROM Keywords WHERE Desc = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, keyword);
			st.execute();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}