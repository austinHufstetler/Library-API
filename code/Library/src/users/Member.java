package users;

import java.util.Random;

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
}
