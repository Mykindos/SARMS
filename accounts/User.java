package deakin.edu.au.sarms.accounts;

import java.util.ArrayList;
import java.util.List;

import deakin.edu.au.sarms.units.Enrolment;
import deakin.edu.au.sarms.units.Unit;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */

public class User {
	
	private String userID;
	private String username, password, firstName, lastName;
	private Status status;
	protected List<Enrolment> enrolments;
	
	public User(String userID, String username, String password, String firstName, String lastName, Status status){
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.enrolments = new ArrayList<>();
	}
	
	public String getUserID(){
		return userID;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public Status getAccountStatus(){
		return status;
	}
	
	public void setStatus(Status s){
		this.status = s;
	}

	public enum Status{
		ACTIVE, EXPIRED, LOCKED, DISABLED;
	}

	
	public boolean isInUnit(String unitID){
		return enrolments.stream().anyMatch(unit -> unit.getUnitID().equalsIgnoreCase(unitID)); 
	}
	
	public void addEnrolment(Enrolment e){
		enrolments.add(e);
	}
	
	public void removeEnrolment(Enrolment e){
		enrolments.remove(e);
	}
	
	public Enrolment getEnrolment(Unit unit){
		return enrolments.stream().filter(e -> e.getUnitID().equalsIgnoreCase(unit.getUnitID()))
				.findAny().orElse(null);
	}
	
	
	@Override
	public String toString(){
		return getFirstName() + " " + getLastName();
	}

}
