package deakin.edu.au.sarms.accounts;

import java.util.ArrayList;
import java.util.List;

import deakin.edu.au.sarms.units.Enrolment;
import deakin.edu.au.sarms.units.Unit;
import deakin.edu.au.sarms.units.UnitManager;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */

public class User {
	
	private int userID;
	private String username, password, firstName, lastName;
	private Status status;
	private List<Enrolment> enrolments;
	
	public User(int userID, String username, String password, String firstName, String lastName, Status status){
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.enrolments = new ArrayList<>();
	}
	
	public int getUserID(){
		return userID;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public Status getAccountStatus(){
		return status;
	}

	public enum Status{
		ACTIVE, EXPIRED, LOCKED, DISABLED;
	}
	
	public boolean isInUnit(String unitCode){
		Unit unit = UnitManager.getUnitByCode(unitCode);
		return isInUnit(unit.getUnitID());
	}
	
	public boolean isInUnit(int unitID){
		return enrolments.stream().anyMatch(unit -> unit.getUnitID() == unitID);
	}
	
	public void addEnrolment(Enrolment e){
		enrolments.add(e);
	}
	
	public void removeEnrolment(Enrolment e){
		enrolments.remove(e);
	}
	
	public Enrolment getEnrolment(Unit unit){
		return enrolments.stream().filter(e -> e.getUnitID() == unit.getUnitID())
				.findAny().orElse(null);
	}
	
	
	@Override
	public String toString(){
		return getFirstName() + " " + getLastName() + " (" + getUserID() + ")";
	}

}
