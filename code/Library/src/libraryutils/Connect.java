package libraryutils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public static Connection getConnection(){
		try{
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/gitclipse/group1/Library_DB.accdb");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/Library_DB_new.accdb");
			return conn;
		}catch(Exception e){
			System.out.print(e);
			return null;
		}
	}

	public static Connection getJohnConnection(){
		try{
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/gitclipse/group1/Library_DB.accdb");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/John/My Documents/cs 4321/group1/Library_DB_new.accdb");
			return conn;
		}catch(Exception e){
			System.out.print(e);
			return null;
		}
	} 
}
