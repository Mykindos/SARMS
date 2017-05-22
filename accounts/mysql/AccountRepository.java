package deakin.edu.au.sarms.accounts.mysql;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;

import deakin.edu.au.sarms.accounts.User;
import deakin.edu.au.sarms.accounts.UserManager;
import deakin.edu.au.sarms.accounts.types.Administrator;
import deakin.edu.au.sarms.accounts.types.Lecturer;
import deakin.edu.au.sarms.accounts.User.Status;
import deakin.edu.au.sarms.mysql.Connect;
import deakin.edu.au.sarms.mysql.QueryExecutor;


/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */	

public class AccountRepository {


	
	/**
	 * Loads all users when the software starts
	 */
	public static void loadUsers(){

		try {
			PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM `users`");
			ResultSet result = statement.executeQuery();

			int count = 0;
			while (result.next()) {
				int id = result.getInt(1);
				String username = result.getString(2);
				String password = result.getString(3);
				String firstName = result.getString(4);
				String lastName = result.getString(5);
				Status status = Status.valueOf(result.getString(6).toUpperCase());
				String role = result.getString(7);
				
				if(role.equals("Administrator")){
					Administrator user = new Administrator(id, username, password, firstName, lastName, status);
					UserManager.addUser(user);
				}else if(role.equals("Lecturer")){
					Lecturer user = new Lecturer(id, username, password, firstName, lastName, status);
					UserManager.addUser(user);
				}else if(role.equals("Student")){
					User user = new User(id, username, password, firstName, lastName, status);
					UserManager.addUser(user);
				}
				

				count++;
			}
			
			System.out.println("MYSQL> Loaded " + count + " users" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Saves the user to the database
	 * @param user The user object
	 * @param role The role of the user, Student, Lecturer, Admin
	 */
	public static void saveUser(User user, String role){
		String query = "INSERT INTO users VALUES("
				+ "'" + user.getUserID() + "', "
				+ "'" + user.getUsername() + "', "
				+ "'" + user.getPassword() + "', "
				+ "'" + user.getFirstName() + "', "
				+ "'" + user.getLastName() + "', "
				+ "'" + user.getAccountStatus().toString() + "', "
				+ "'" + role + "')";
		QueryExecutor.addQuery(query);
	}
	
	/**
	 * Updates the user record in the database
	 * @param user The users updated object
	 */
	public static void updateUser(User user){
		String query = "UPDATE users SET"
				+ " Username='" + user.getUsername() + "'"
				+ ", Password='" + user.getPassword() + "'"
				+ ", FirstName='" + user.getFirstName() + "'"
				+ ", LastName='" + user.getLastName() + "'"
				+ ", Status='" + user.getAccountStatus().name() + "'";
		QueryExecutor.addQuery(query);
	}
	
	/**
	 * Deletes user record from the database
	 * @param user The user to delete
	 */
	public static void removeUser(User user){
		String query = "DELETE FROM users WHERE UserID=" + user.getUserID();
		QueryExecutor.addQuery(query);
	}
	
}
