package common;

public interface LibraryConstants {
	
	//DATABASE FIELDS SIZES
	final int NUM_FIELDS_BOOKS = 10;
	final int NUM_FIELDS_MEMBERS = 10;
	final int NUM_FIELD_EMPLOYEES = 10;
	
	final int MAX_BOOKS_CHECKOUT = 10;
	
	final double LATE_FEE = 0.10;
	final double MINIMUM_PAYMENT = 5.00;
	final double ALLOWABLE_FINES = 25.00;
	
	//Maximum number of days user has to pickup held book it
	//becomes "unheld" in the system
	final int DAYS_TO_PICKUP = 4;
	
	//Size of user pin
	final int PIN_SIZE = 4;
	
	//Maximum times a member can renew a single book
	final int MAX_RENEWAL  = 2;
	
	//How long member can keep a book, in days
	final int CHECKOUT_PERIOD = 14;
	
	//reasons for suspension
	final int NOT_SUSPENDED = 0;
	final int SUSPENDED_FINES = 1;
	final int SUSPENDED_OTHER = 2;
}
