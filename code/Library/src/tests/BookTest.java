package tests;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import books.Book;
=======
import Books.Book;
>>>>>>> parent of c7c8403... added books to db

public class BookTest {

	public static void main(String[] args){
	 /*	Book book = new Book("test","test","test");
		System.out.println(book.getAuthor() == "test");
		System.out.println(book.getIsbn() == "test");
		System.out.println(book.getTitle() == "test"); */
		
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/WFH/Desktop/austin/EclipseProjects/software/group1/Library_DB.accdb");
			Statement st = conn.createStatement();
			String sql = "Select * from Books";
			st.executeQuery(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println("\n" + rs.getString("Title"));
			}
		} catch(Exception e){
			System.out.print(e);
		}	
	}

}
