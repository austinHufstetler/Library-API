package tests;

import users.Authorization;

public class AuthorizationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test 1. authorize associate
		//correct
		System.out.println(Authorization.authorizeAssociate("jblack", "password789"));
		//incorrect
		System.out.println(Authorization.authorizeAssociate("jblack", "password7899"));
		//entering manager information, should return false
		System.out.println(Authorization.authorizeAssociate("jbrown", "stargirl123"));
		//testing with authorizemanager, should return true
		System.out.println(Authorization.authorizeManager("jbrown", "stargirl123"));
		
		//Test 2. authorize manager
		
		//Test 3. authorize member
		
		//Test 4. authorize user
		
		//Test 5. authorize employee
		
		
	}

}
