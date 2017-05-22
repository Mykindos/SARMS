package deakin.edu.au.sarms.units;

/**
 * 
 * @author Tom
 *
 */

public class Enrolment {

	
	private int userID;
	private int unitID;
	private String role;
	
	public Enrolment(int unitID, int userID, String role){
		this.unitID = unitID;
		this.userID = userID;
		this.role = role;
	}
	
	public int getUnitID(){
		return unitID;
	}
	
	public int getUserID(){
		return userID;
	}
	
	public String getRole(){
		return role;
	}
}
