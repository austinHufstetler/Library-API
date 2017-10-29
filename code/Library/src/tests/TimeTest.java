package tests;

import java.util.Date;

import time.TimeTools;

public class TimeTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		//1. Get number of days between two dates
		Date d1 = new Date();
		//Date d2 = new Date();
		String inputString = "11-11-2016";
		Date d2 = TimeTools.convertDate(inputString);
		System.out.println(TimeTools.getDayDifference(d1, d2));
		
	}

}
