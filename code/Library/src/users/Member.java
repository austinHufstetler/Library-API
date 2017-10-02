package users;

import java.util.Random;

public class Member extends User {
	int pin;
	public Member(String firstName, String lastName, String role, String username, String password) {
		super(firstName, lastName, role, username, password);
		// TODO Auto-generated constructor stub
	}
	private String generatePINCode() {
		Random rand = new Random();
		this.pin = rand.nextInt(100000);
		return "" + pin;
	}
}
