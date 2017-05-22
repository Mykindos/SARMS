package deakin.edu.au.sarms.accounts.types;

import java.util.ArrayList;
import java.util.List;

import deakin.edu.au.sarms.accounts.User;
import deakin.edu.au.sarms.units.Unit;
import deakin.edu.au.sarms.units.UnitManager;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */

public class Lecturer extends User{

	public Lecturer(String userID, String username, String password,
			String firstName, String lastName, Status status) {
		super(userID, username, password, firstName, lastName, status);
	}
	
	public List<Unit> getLecturerUnits(){
		List<Unit> temp = new ArrayList<>();
		enrolments.forEach(e -> {
			if(e.getRole().equalsIgnoreCase("Lecturer")){
				temp.add(UnitManager.getUnitByCode(e.getUnitID()));
			}
		});
		return temp;
	}

}
