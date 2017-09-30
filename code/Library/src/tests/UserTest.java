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
		UserManagement.updateMember(m1, 1);
		
	}

}
