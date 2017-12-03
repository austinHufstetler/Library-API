package keywords;

import java.sql.*;
import java.util.ArrayList;

import books.Book;
import books.BookManagement;
import common.LibraryConstants;
import libraryutils.Connect;
import users.Associate;
import users.Member;
import libraryutils.Connect;

public class KeywordMapManagement {

	public static void add(int bookId, int keywordId) {
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/WFH/Desktop/austin/EclipseProjects/software/group1/Library_DB.accdb");
			Connection conn = Connect.getConnection();
			String sql = "INSERT INTO KeywordMap ([BookId],[KeywordId]) VALUES(?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, bookId);
			st.setInt(2, keywordId);
			st.execute();
		} catch(Exception e){
			System.out.print(e);
		}
	}

	public static ArrayList<KeywordMap> search(int keywordId) {
		ArrayList<KeywordMap> list = new ArrayList<KeywordMap>();
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT * FROM KeywordMap WHERE KeywordId = " + keywordId;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, keywordId);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				KeywordMap result = new KeywordMap(rs.getInt("BookId"),rs.getInt("KeywordId"));
				list.add(result);
			}

			return list;

		} catch(Exception e){
			System.out.print(e);
			return null;
		}
	}

	public static ArrayList<Book> getBooksByKeyword(String keyword){
		ArrayList<Book> result = new ArrayList<Book>();
		Keyword key = KeywordManagement.searchByKeyword(keyword);
		ArrayList<KeywordMap> list = KeywordMapManagement.search(key.getId());
		for(KeywordMap map : list){
			result.add(BookManagement.getBook(map.getBookId()));
		}
		return result;
	}
}
