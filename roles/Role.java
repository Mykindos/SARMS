package deakin.edu.au.sarms.roles;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */

public class Role {
	
	private int roleID;
	private String roleLabel;
	private String[] roleDescription;
	
	public Role(int roleID, String roleLabel, String[] description){
		this.roleID = roleID;
		this.roleLabel = roleLabel;
		this.roleDescription = description;
	}
	
	public int getRoleID(){
		return roleID;
	}
	
	public String getRoleLabel(){
		return roleLabel;
	}
	
	public String[] getDescription(){
		return roleDescription;
	}

}
