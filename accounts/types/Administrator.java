package deakin.edu.au.sarms.accounts.types;

import deakin.edu.au.sarms.accounts.User;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */

public class Administrator extends User{

	public Administrator(int userID, String username, String password,
			String firstName, String lastName, Status status) {
		super(userID, username, password, firstName, lastName, status);
	}

}
