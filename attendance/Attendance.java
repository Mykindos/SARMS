package deakin.edu.au.sarms.attendance;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (22/05/2017)
 *
 */


public class Attendance {
	
	private String attendanceID;
	private String userID, unitID;
	private boolean attendance; // false = absent, true = present - ABSENT BY DEFAULT
	private String date;
	
	public Attendance(String attendanceID, String unitID, String userID, String date){
		this.attendanceID = attendanceID;
		this.unitID = unitID;
		this.userID = userID;
		this.date = date;
	}
	
	
	public String getAttendanceID(){
		return attendanceID;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public String getUnitID(){
		return unitID;
	}
	
	public boolean wasPresent(){
		return attendance;
	}
	
	
	/**
	 * Set the Users attendance for a unit
	 * True = Present, False = Absent
	 * @param present Whether the student was present to the class or not
	 */
	public void setAttendance(boolean present){
		this.attendance = present;
	}

}
