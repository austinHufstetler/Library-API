package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import users.*;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1 = new Member("Lisa","Doe","dpickle","password123","12345");
		//System.out.println(UserManagement.readMember("dpickle2"));
		//System.out.println(UserManagement.readManager("kausten"));
		//System.out.println(UserManagement.readAssociate("jblack2"));
		System.out.println(UserManagement.authorizeUser("kausten", "password456"));
	}

}
