package users;

import java.sql.*;
import java.util.Random;

public class UserManagement {

	///////////////////
	//Member management
	///////////////////
	public static void createMember(/*Member m*/){
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			//Statement st = conn.createStatement();
			String sql = "INSERT INTO Members ([FName]) VALUES (?)";
			//st.executeQuery(sql);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "John");
			st.executeUpdate();
			//st.executeUpdate(sql);
			//ResultSet rs = st.executeQuery(sql);
			/*while(rs.next()){
				System.out.println("\n" + rs.getString("Title"));
			} */
		} catch(Exception e){
			System.out.print(e);
		} 
	}
	
	public void readMember(Member m){

	}
	
	public void updateMember(Member m){

	}
	
	public void deleteMember(Member m){

	}
	
	////////////////////
	//Manager management
	////////////////////
	public void createManager(Manager m){
		
	}
	
	public void readManager(Manager m){
		
	}
	
	public void updateManager(Manager m){
		
	}
	
	public void deleteManager(Manager m){
		
	}
	
	//////////////////////
	//Associate management
	/////////////////////
	public void createAssociate(Associate m){
		
	}
	
	public void readAssociate(Associate m){
		
	}
	
	public void updateAssociate(Associate m){
		
	}
	
	public void deleteAssociate(Associate m){
		
	}
	private String DuplicateCheck(String value) {
		boolean duplicated = true;
		do{
			   myFunction();
			}while(duplicated = true);
	return value;
	}
}
