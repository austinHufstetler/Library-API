package users;

import java.sql.*;
import java.util.Random;
import libraryutils.Connect;

public class UserManagement {

	///////////////////
	//Member management
	///////////////////
	public static void createMember(Member m){
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//String pin = m.pin;
			Connection conn = Connect.getConnection();
			//Statement st = conn.createStatement();
			String sql = "INSERT INTO Members ([FName], [LName], [Username], [Password], [PIN_Code]) VALUES (?,?,?,?,?)";
			//st.executeQuery(sql);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password);
			st.setString(5, m.pin);
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
	
	
	//changes return type to string later, void is for testing
	public static String readMember(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Members WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			String fname = rs.getString("FName");
			String lname= rs.getString("LName");
			String uname = rs.getString("Username");
			String password =  rs.getString("Password");
			return String.format("ID= %d\nName= %s %s\nUsername= %s\nPassword= %s\n", id,fname,lname,uname,password);
		    } catch(Exception e){
		    	return "User doesn't exist";
		    }
		
	}
	
	public static Member getMember(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Members WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			String fname = rs.getString("FName");
			String lname= rs.getString("LName");
			String uname = rs.getString("Username");
			String password =  rs.getString("Password");
			String pincode =  rs.getString("PIN_Code");
			System.out.println("you have gotten a member");
			return new Member(fname,lname,uname,password,pincode);
		    } catch(Exception e){
		    	System.out.println(e);
		    	return null;
		    }		
	}
	
	public static void updateMember(Member m, int id){
		try{
			Connection conn = Connect.getConnection();
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
			Connection conn = Connect.getConnection();
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
			Connection conn = Connect.getConnection();
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
	
	public static String readManager(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			String fname = rs.getString("FName");
			String lname= rs.getString("LName");
			String uname = rs.getString("Username");
			String password =  rs.getString("Password");
			return String.format("ID= %d\nName= %s %s\nUsername= %s\nPassword= %s\n", id,fname,lname,uname,password);
		    } catch(Exception e){
		    	return "User doesn't exist";
		    }		
	}
	
	public static Manager getManager(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			String fname = rs.getString("FName");
			String lname= rs.getString("LName");
			String uname = rs.getString("Username");
			String password =  rs.getString("Password");
			return new Manager(fname,lname,uname,password);
		    } catch(Exception e){
		    	return null;
		    }		
	}
	
	public static void updateManager(Manager m, int id){
		try{
			Connection conn = Connect.getConnection();
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
			Connection conn = Connect.getConnection();
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
			Connection conn = Connect.getConnection();
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
	
	public static String readAssociate(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			String fname = rs.getString("FName");
			String lname= rs.getString("LName");
			String uname = rs.getString("Username");
			String password =  rs.getString("Password");
			return String.format("ID= %d\nName= %s %s\nUsername= %s\nPassword= %s\n", id,fname,lname,uname,password);
		    } catch(Exception e){
		    	System.out.print(e);
		    	return "User doesn't exist";
		    }		
	}
	
	public static Associate getAssociate(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			String fname = rs.getString("FName");
			String lname= rs.getString("LName");
			String uname = rs.getString("Username");
			String password =  rs.getString("Password");
			return new Associate(fname,lname,uname,password);
		    } catch(Exception e){
		    	return null;
		    }		
	}
	
	public static void updateAssociate(Associate m, int id){
		try{
			Connection conn = Connect.getConnection();
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
			Connection conn = Connect.getConnection();
			String sql = "DELETE FROM Employees WHERE Username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	/*
	 *
	 *
	ALL LOGIN AND AUTHORIZE METHODS NEED TO BE PUT IN SEPARATE CLASS LATER, TOO MUCH FOR THIS CLASS
	 *
	 *
	
	
	public static User login(String username, String password){
		User u = null;
		if(authorizeUser(username, password)){
			if(authorizeMember(username,password)){
				
			}
			
		}
		return u;
	}
	
	public static boolean authorizeUser(String username, String password){
		return authorizeEmployee(username,password) || authorizeMember(username, password);
	}
	
	private static boolean authorizeEmployee(String username, String password){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ? AND Password = ?");    
			st.setString(1, username);   
			st.setString(2, password);   
			ResultSet rs = st.executeQuery();
			rs.next();
			String uname = rs.getString("Username");
			String pswd =  rs.getString("Password"); 
			
			if(uname.equals(username) && pswd.equals(password)){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	return false;
		    }	
	}
	
	private static boolean authorizeAssociate(String username, String password){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ? AND Password = ? AND Role = ?");    
			st.setString(1, username);   
			st.setString(2, password);   
			ResultSet rs = st.executeQuery();
			rs.next();
			String uname = rs.getString("Username");
			String pswd =  rs.getString("Password"); 
			String role =  rs.getString("Role"); 
			if(uname.equals(username) && pswd.equals(password) && role.equals("associate")){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	return false;
		    }	
	}
	
	private static boolean authorizeManager(String username, String password){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ? AND Password = ? AND Role = ?");    
			st.setString(1, username);   
			st.setString(2, password);   
			st.setString(2, password);  
			ResultSet rs = st.executeQuery();
			rs.next();
			String uname = rs.getString("Username");
			String pswd =  rs.getString("Password"); 
			String role =  rs.getString("Role"); 
			if(uname.equals(username) && pswd.equals(password) && role.equals("manager")){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	return false;
		    }	
	}
	
	private static boolean authorizeMember(String username, String password){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Members WHERE Username = ? AND Password = ?");    
			st.setString(1, username);   
			st.setString(2, password);   
			ResultSet rs = st.executeQuery();
			rs.next();
			String uname = rs.getString("Username");
			String pswd =  rs.getString("Password"); 
			
			if(uname.equals(username) && pswd.equals(password)){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	return false;
		    }	
	}
	*/
	
	//delete later, added to Connect class
	/*public static Connection getConnection(){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/gitclipse/group1/Library_DB.accdb");
			return conn;
		}catch(Exception e){
			System.out.print(e);
			return null;
		}
	} */
	
	
	public static String generatePINCode() {
		Random rand = new Random();
		int pin = rand.nextInt(89999)+10000;
		return "" + pin;
	}
	
	//delete from this class later, added to Member class
	/*public static void checkoutBook(String isbn, String pin){
		try{
			Connection conn = getConnection();
			String sql = "UPDATE Books SET PIN_Code= ? WHERE ISBN = " + isbn;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, pin);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}*/
	
}
