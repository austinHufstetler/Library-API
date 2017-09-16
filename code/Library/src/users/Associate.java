package users;

public class Associate extends Employee {

	public Associate(String firstName, String lastName, String username, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = "associate";
		this.username = username;
		this.password = password;
	}

}
