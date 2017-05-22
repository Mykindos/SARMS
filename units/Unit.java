package deakin.edu.au.sarms.units;

import java.util.ArrayList;
import java.util.List;

import deakin.edu.au.sarms.accounts.UserManager;
import deakin.edu.au.sarms.accounts.types.Lecturer;
import deakin.edu.au.sarms.accounts.types.Student;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */

public class Unit {

	private int unitID;
	private String unitCode, unitName;

	public Unit(int unitID, String unitCode, String unitName){
		this.unitID = unitID;
		this.unitCode = unitCode;
		this.unitName = unitName;
	}

	/**
	 * Get the Units ID
	 * @return The Units ID
	 */
	public int getUnitID(){
		return unitID;
	}

	/**
	 * Gets the Units code
	 * @return The Unit code
	 */
	public String getUnitCode(){
		return unitCode;
	}

	/**
	 * Gets the Units Name
	 * @return The Unit name
	 */
	public String getUnitName(){
		return unitName;
	}

	/**
	 * Get all lecturers in the Unit
	 * @return A list of Lecturers
	 */
	public List<Lecturer> getLecturers(){
		List<Lecturer> lecturers = new ArrayList<>();
		UserManager.userList.forEach(user -> {
			if(user instanceof Lecturer){
				Lecturer lecturer = (Lecturer) user;
				if(lecturer.isInUnit(getUnitCode())){
					lecturers.add(lecturer);
				}
			}
		});
		return lecturers;
	}

	/**
	 * Get all Students in the Unit
	 * @return A list of students
	 */
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		UserManager.userList.forEach(user -> {
			if(user instanceof Student){
				Student student = (Student) user;
				if(student.isInUnit(getUnitCode())){
					students.add(student);
				}
			}
		});
		return students;
	}
	
	
	/**
	 * Overrides toString to properly display the unit in the GUI lists
	 */
	@Override
	public String toString(){
		return getUnitCode() + " (" + getUnitName() + ")"; 
	}

}
