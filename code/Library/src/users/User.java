package users;
import common.*;

public abstract class User extends LibraryObject{

	String firstName;
	String lastName;
	String role;
	String username;
	String password;
	
	//person who has not entered any information
	public User(){
		this.firstName = "unknown";
		this.lastName = "unknown";
		this.role = "visitor";
		this.username = "unknown";
		this.password = "unknown";
	}
	
	//users who plan to become members
	public User(String firstName, String lastName, String role, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.username = username;
		this.password = password;
	}
	
	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//action methods
	public static void requestMembership(){
		
	}
}
