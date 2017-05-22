package deakin.edu.au.sarms.units;

import java.util.ArrayList;
import java.util.List;

import deakin.edu.au.sarms.accounts.User;
import deakin.edu.au.sarms.units.mysql.UnitRepository;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (22/05/2017)
 *
 */


public class UnitManager {

	public static List<Unit> unitList = new ArrayList<>();

	/**
	 * Add a unit to the list of units
	 * @param unit The unit to add
	 */
	public static void addUnit(Unit unit){
		unitList.add(unit);
	}

	/**
	 * Removes unit from the list of units
	 * @param unit The unit to remove
	 */
	public static void removeUnit(Unit unit){
		unitList.remove(unit);
	}

	/**
	 * Get a unit by its unit code
	 * @param code The unit code
	 * @return Returns a Unit with a matching unit code, if no unit is found, returns NULL
	 */
	public static Unit getUnitByCode(String code){
		return unitList.stream().filter(unit -> 
		unit.getUnitCode().equalsIgnoreCase(code) 
		|| unit.getUnitID().equalsIgnoreCase(code))
				.findFirst().orElse(null);
	}

	/**
	 * Removes a users enrolment
	 * @param unit The unit to un-enrol
	 * @param user The user un-enroling
	 */
	public static void unenrolUser(Unit unit, User user){
		if(user.isInUnit(unit.getUnitID())){
			Enrolment enrol = user.getEnrolment(unit);
			UnitRepository.removeEnrolment(unit, user);
			user.removeEnrolment(enrol);

		}
	}

}
