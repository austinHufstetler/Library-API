package books;

import java.sql.*;
import books.Book;

public class BookManagement {


	public void add(Book book) {
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/WFH/Desktop/austin/EclipseProjects/software/group1/Library_DB.accdb");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/John/My Documents/cs 4321/group1/Library_DB.accdb");
			String sql = "INSERT INTO Books ([ISBN],[Author_FName],[Author_LName],[Title],[Genre],[ReleaseYear],[Hold]) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,book.getIsbn());
			st.setString(2, book.getAuthorFirstName());
			st.setString(3, book.getAuthorLastName());
			st.setString(4, book.getTitle());
			st.setString(5, book.getGenre());
			st.setString(6, book.getReleaseYear());
			st.setString(7, book.getHold());
			st.execute();
		} catch(Exception e){
			System.out.print(e);
		}
	}
	public Book search(Book book) {
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/WFH/Desktop/austin/EclipseProjects/software/group1/Library_DB.accdb");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/John/My Documents/cs 4321/group1/Library_DB.accdb");
			String sql = "SELECT * FROM Books WHERE ID = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, book.getId());
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			Book result = new Book(rs.getString("ISBN"),rs.getString("Author_FName"),rs.getString("Author_LName"),rs.getString("Title"),rs.getString("Genre"),rs.getString("ReleaseYear"),rs.getString("Hold"));
			result.setId(id);
			return result;

		} catch(Exception e){
			System.out.print(e);
			return null;
		}
	}

	public void update(Book book) {

	}

	public void delete(Book book) {
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/WFH/Desktop/austin/EclipseProjects/software/group1/Library_DB.accdb");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/John/My Documents/cs 4321/group1/Library_DB.accdb");
			String sql = "DELETE FROM Books WHERE ID = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, book.getId());
			st.execute();
		} catch(Exception e){
			System.out.print(e);
		}
	}



}
