package users;

import java.sql.*;

public class UserManagement {

	///////////////////
	//Member management
	///////////////////
	public static void createMember(Member m){
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//String pin = m.pin;
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			//Statement st = conn.createStatement();
			String sql = "INSERT INTO Members ([FName], [LName], [Username], [Password]) VALUES (?,?,?,?)";
			//st.executeQuery(sql);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password);
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
	
	public static void updateMember(Member m, int id){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			String sql = "UPDATE Members SET FName = ?, LName = ?, Username = ?, Password = ? WHERE ID = "+ id;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password); 
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 	
	}
	
	public static void deleteMember(String username){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			String sql = "DELETE FROM Members WHERE Username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 	
	}
	
	////////////////////
	//Manager management
	////////////////////
	public static void createManager(Manager m){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			String sql = "INSERT INTO Employees ([FName], [LName], [Username], [Password],[Role]) VALUES (?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password);
			st.setString(5, m.role);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 	
	}
	
	public static void readManager(Manager m){
		
	}
	
	public static void updateManager(Manager m, int id){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			String sql = "UPDATE Employees SET FName = ?, LName = ?, Username = ?, Password = ? WHERE ID = "+ id;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password); 
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	public static void deleteManager(String username){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			String sql = "DELETE FROM Employees WHERE Username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	//////////////////////
	//Associate management
	/////////////////////
	public static void createAssociate(Associate a){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			String sql = "INSERT INTO Employees ([FName], [LName], [Username], [Password],[Role]) VALUES (?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, a.firstName);
			st.setString(2, a.lastName);
			st.setString(3, a.username);
			st.setString(4, a.password);
			st.setString(5, a.role);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	public static void readAssociate(Associate m){
		
	}
	
	public static void updateAssociate(Associate m, int id){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			String sql = "UPDATE Employees SET FName = ?, LName = ?, Username = ?, Password = ? WHERE ID = "+ id;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password); 
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	public static void deleteAssociate(String username){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/git/group1/Library_DB.accdb");
			String sql = "DELETE FROM Employees WHERE Username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
}
