package users;

public class Manager extends Employee {
	
	public Manager(String firstName, String lastName, String username, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = "manager";
		this.username = username;
		this.password = password;
	}
	
}