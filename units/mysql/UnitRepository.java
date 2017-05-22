package deakin.edu.au.sarms.units.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import deakin.edu.au.sarms.Main;
import deakin.edu.au.sarms.accounts.User;
import deakin.edu.au.sarms.accounts.UserManager;
import deakin.edu.au.sarms.mysql.Connect;
import deakin.edu.au.sarms.mysql.QueryExecutor;
import deakin.edu.au.sarms.units.Enrolment;
import deakin.edu.au.sarms.units.Unit;
import deakin.edu.au.sarms.units.UnitManager;

public class UnitRepository {

	/**
	 * Loads all the units when the software starts
	 */
	public static void loadUnits(){

		try {
			PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM units");
			ResultSet result = statement.executeQuery();

			int count = 0;
			while (result.next()) {
				int unitID = result.getInt(1);
				String unitCode = result.getString(2);
				String name = result.getString(3);

				Unit unit = new Unit(unitID, unitCode, name);
				UnitManager.addUnit(unit);

				count++;
			}

			System.out.println("MYSQL> Loaded " + count + " units");
		}catch(Exception e){
			e.printStackTrace();
		}


		loadEnrolments();
	}

	
	/**
	 * Loads all the enrolments after the units have been loaded
	 */
	public static void loadEnrolments(){

		try {
			PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM enrolments");
			ResultSet result = statement.executeQuery();

			int count = 0;
			while (result.next()) {
				int unitID = result.getInt(1);
				int userID = result.getInt(2);
				String unitRole = result.getString(3);

				User user = UserManager.getUserByID(userID);
				if(user != null){
					user.addEnrolment(new Enrolment(unitID, userID, unitRole));
				}

				count++;

			}
			System.out.println("MYSQL> Loaded " + count + " enrolments");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Main.started = true;


	}

	/**
	 * Saves a unit to the database
	 * @param unit The unit to save
	 */
	public static void addUnit(Unit unit){
		String query = "INSERT INTO units VALUES('" + unit.getUnitID() + "', '"
				+ unit.getUnitCode() + "', '" + unit.getUnitName() + "')";
		QueryExecutor.addQuery(query);
	}
	
	/**
	 * Removes unit from the database
	 * @param unit The unit to remove
	 */
	public static void removeUnit(Unit unit){
		String query = "DELETE FROM units WHERE UnitID=" + unit.getUnitID();
		QueryExecutor.addQuery(query);
	}

	/**
	 * Removes enrolment from the database
	 * @param unit Unit user is enrolled in
	 * @param user User that is enrolled
	 */
	public static void removeEnrolment(Unit unit, User user){
		String query = "DELETE FROM enrolments WHERE UnitID=" 
				+ unit.getUnitID() + " AND UserID=" + user.getUserID();
		QueryExecutor.addQuery(query);
	}

	/**
	 * Save enrolment to the database
	 * @param unit The unit enrolled in
	 * @param user The user enrolling
	 * @param role The role of the user, Student or Lecturer
	 */
	public static void addEnrolment(Unit unit, User user, String role){
		String query = "INSERT INTO enrolments VALUES('" + unit.getUnitID() 
		+ "', '" + user.getUserID() + "' , '" + role + "')";
		QueryExecutor.addQuery(query);
	}
}
