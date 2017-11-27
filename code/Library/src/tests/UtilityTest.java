package tests;

import libraryutils.DuplicateChecker;

public class UtilityTest {
	public static void main(String[] args) {
		//Test 1. Duplicate check
		System.out.println(DuplicateChecker.duplicatePinCheck("10101"));
		
		//Test 2. Test Connection
		
		//Test 3. Test username duplicate check
		System.out.println(DuplicateChecker.duplicateUsernameCheck("10101"));
		System.out.println(DuplicateChecker.duplicateUsernameCheck("ldoe"));
	}
}
