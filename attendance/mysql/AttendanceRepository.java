package deakin.edu.au.sarms.attendance.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import deakin.edu.au.sarms.Main;
import deakin.edu.au.sarms.attendance.Attendance;
import deakin.edu.au.sarms.attendance.AttendanceManager;
import deakin.edu.au.sarms.mysql.Connect;
import deakin.edu.au.sarms.mysql.QueryExecutor;

/**
 * 
 * @author Robert Meredith (22/05/17)
 *
 */

public class AttendanceRepository {

	
	/**
	 * Loads all the attendance data when the software starts
	 */
	public static void loadAttendance(){

		try {
			PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM attendance");
			ResultSet result = statement.executeQuery();
			

			int count = 0;
			while (result.next()) {
				String attendanceID = result.getString(1);
				String unitID = result.getString(2);
				String userID = result.getString(3);
				
				boolean present = result.getBoolean(4);
				
				String date = result.getString(5);
				Attendance attendance = new Attendance(attendanceID, unitID, userID, date);
				attendance.setAttendance(present);
				
				AttendanceManager.addAttendance(attendance);
				count++;
			}

			System.out.println("MYSQL> Loaded " + count + " attendance data");
		}catch(Exception e){
			e.printStackTrace();
		}

		
		Main.started = true;

		
	}
	
	public static void saveAttendance(Attendance a){
		String query = "INSERT INTO attendance VALUES("
				+ "'" + a.getAttendanceID() + "', "
				+ "'" + a.getUnitID() + "', "
				+ "'" + a.getUserID() + "', "
				+ "'" + (a.wasPresent() ? 1 : 0) + "', "
				+ "'" + a.getDate() + "')";
		QueryExecutor.addQuery(query);
	}
	
	public static void updateAttendance(String attendanceID, boolean present){
		String query = "UPDATE attendance SET State='" + (present ? 1 : 0)
				+ "' WHERE AttendanceID='" + attendanceID + "'";
		QueryExecutor.addQuery(query);
	}
}
