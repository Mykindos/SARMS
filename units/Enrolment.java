package deakin.edu.au.sarms.units;

/**
 * 
 * @author Tom
 *
 */

public class Enrolment {

	
	private String userID;
	private String unitID;
	private String role;
	
	public Enrolment(String unitID, String userID, String role){
		this.unitID = unitID;
		this.userID = userID;
		this.role = role;
	}
	
	public String getUnitID(){
		return unitID;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public String getRole(){
		return role;
	}
}
