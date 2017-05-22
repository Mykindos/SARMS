package deakin.edu.au.sarms.accounts;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */

public class UserManager {
	
	public static List<User> userList = new ArrayList<>();
	
	
	/**
	 * Add user to userList
	 * @param user The User to add
	 */
	public static void addUser(User user){
		userList.add(user);
		
	}
	
	/**
	 * Remove user from userList
	 * @param user The User to remove
	 */
	public static void removeUser(User user){
		userList.remove(user);
	}
	
	/**
	 * Find user by their ID
	 * @param id The Users ID
	 * @return The User found, NULL if no user is found with provided ID
	 */
	public static User getUserByID(String id){
		return userList.stream().filter(user -> user.getUserID().equalsIgnoreCase(id))
				.findFirst().orElse(null);
	}
	
	/**
	 * Find user by their Username
	 * @param username The Username of the user you are trying to find
	 * @return The User found, NULL if no user is found with provided username
	 */
	public static User getUserByUsername(String username){
		return userList.stream().filter(user -> user.getUsername()
				.equalsIgnoreCase(username)).findFirst().orElse(null);
	}

}
