package users;

import java.util.Random;

<<<<<<< HEAD
public class Member extends User {
	int pin;
	public Member(String firstName, String lastName, String username, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = "member";
		this.username = username;
		this.password = password;
	}
	private static int generatePINCode() {
		Random rand = new Random();
		this.pin = rand.nextInt(100000);
			return pin;
	}
=======
	public Member(String firstName, String lastName, String role, String username, String password) {
		super(firstName, lastName, role, username, password);
		// TODO Auto-generated constructor stub
	}


	
>>>>>>> d46bfee6e77975255c8893d7c1958167e79bfe96
}
