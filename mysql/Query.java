package deakin.edu.au.sarms.mysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class Query {

	
	private String stmt;

	public Query(String stmt) {
		this.stmt = stmt;

	}

	/**
	 * Get the statement
	 * @return The query statement
	 */
	public String getStatment() {
		return stmt;
	}

	/**
	 * Executes the statement as a query through the MYSQL Connection
	 */
	public void execute() {
		try {

			PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(getStatment());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(CommunicationsException ce){
			ce.printStackTrace();
			Connect.connection = null;

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

}
