package deakin.edu.au.sarms.roles.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import deakin.edu.au.sarms.mysql.Connect;
import deakin.edu.au.sarms.roles.Role;

public class RoleRepository {

	private static List<Role> roles = new ArrayList<>();

	public static void loadRoles(){

		try {
			PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM roles");
			ResultSet result = statement.executeQuery();

			while (result.next()) {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
