package libraryutils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static final String AUSTIN_CONNECTION = "jdbc:ucanaccess://C:/Users/Austin/Desktop/gitclipse/group1/Library_DB.accdb";
	private static final String JOHN_CONNECTION = "jdbc:ucanaccess://C:/Users/John/My Documents/cs 4321/group1/Library_DB_new.accdb";
	public static Connection getConnection(){
		try{
			Connection conn = DriverManager.getConnection(JOHN_CONNECTION);
			return conn;
		}catch(Exception e){
			System.out.print(e);
			return null;
		}
	}
}
