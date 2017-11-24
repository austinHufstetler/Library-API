package time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import libraryutils.Connect;

public class TimeTools {

	public static int getDayDifference(Date d1, Date d2){
		int days = (int) ((d1.getTime() - d2.getTime())/ (1000*60*60*24) );
		return Math.abs(days);
	}

	public static Date convertDate(String input){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try{
			d = dateFormat.parse(input);
		} catch(Exception e){
			System.out.println(e);
			return null;
		}
		return d;
	}
	
	public static String getCurrentDate(){
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		String current = year +"-" + month +"-" + day;
		return current;
	}
	
	public static int getDaysCheckedOut(int book_id){
			try{
				Connection conn = Connect.getConnection();
				String sql = "SELECT * FROM Books WHERE ID= ?";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1,book_id + "");
				ResultSet rs = st.executeQuery();
				rs.next();
				int id = rs.getInt("ID");
				System.out.println("hello");
				Date checkedOut = new Date(rs.getDate("DateStartCheckedOut").getTime());
				Date current = convertDate(getCurrentDate());
				return getDayDifference(current,checkedOut);
			} catch(Exception e){
				System.out.print(e);
				return 0;
			} 	
	}
}
