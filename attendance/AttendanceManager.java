package deakin.edu.au.sarms.attendance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import deakin.edu.au.sarms.accounts.User;
import deakin.edu.au.sarms.units.Unit;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (22/05/2017)
 *
 */


public class AttendanceManager {
	
	public static List<Attendance> attendanceList = new ArrayList<>();
	
	public static void addAttendance(Attendance a){
		attendanceList.add(a);
	}
	
	public static void removeAttendance(Attendance a){
		attendanceList.remove(a);
	}

	
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 

	/**
	 * Get the Attendance Data of a Student in a specific unit and date
	 * @param user The Student to check
	 * @param unit The unit to check
	 * @param date The Data to check
	 * @return The attendance matching the user, unit and date, NULL if no attendance data is found
	 */
	public static Attendance getAttendanceSUT(User user, Unit unit, Date date){
		String stringDate = df.format(date);
		return attendanceList.stream().filter(a -> {
			
			return a.getUserID().equalsIgnoreCase(user.getUserID()) 
				&& a.getUnitID().equalsIgnoreCase(unit.getUnitID()) 
				&& a.getDate().equalsIgnoreCase(stringDate);
		}).findAny().orElse(null);
	}
	
	
	/**
	 * Stop duplicate attendances for the same unit
	 * @param a The attendance to check from
	 * @return True if attendance data has already been added to the list
	 */
	public static boolean alreadySaved(Attendance a){
		for(Attendance b : attendanceList){
			if(a.getUnitID().equalsIgnoreCase(b.getUnitID())){
				if(a.getUserID().equalsIgnoreCase(b.getUserID())){
					if(a.getDate().equalsIgnoreCase(b.getDate())){
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
