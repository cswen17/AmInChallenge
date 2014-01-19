package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Class that interfaces with the MySQL database and processes all queries to
 * it. Probably shouldn't configure the database with unencrypted data like
 * this. Will change later.
 * 
 * @author connie
 * 
 */

public class MySQLConnector {
	private final String dbName = "AmInChallenge";
	private final String userName = "demoname";
	private final String passWord = "demopswd2014";
	private static MySQLConnector instance;

	private Connection connect = null;
	private Statement statement = null;
	// private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private MySQLConnector() {
		// Constructor stuff here
	}

	/**
	 * Returns an instance of the MySQLConnector
	 * 
	 * @return self
	 */
	public static MySQLConnector getInstance() {
		// Either create an instance, or return the current instance
		if (instance == null) {
			instance = new MySQLConnector();
		}
		return instance;
	}

	/**
	 * test test
	 * 
	 * @throws Exception
	 */
//	public void readDataBase() throws Exception {
//		try {
//			// This code is copied and tweaked from vogella
//			Class.forName("com.mysql.jdbc.Driver");
//			connect = DriverManager.getConnection("jdbc:mysql://localhost/"
//					+ dbName + "?" + "user=" + userName + "&password="
//					+ passWord);
//			statement = connect.createStatement();
//			resultSet = statement
//					.executeQuery("select * from AmInChallenge.COUNTRIES");
//			writeResultSet(resultSet);
//
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			close();
//		}
//	}

	/**
	 * test test
	 * 
	 * @param resultSet
	 * @throws SQLException
	 */
//	private void writeResultSet(ResultSet resultSet) throws SQLException {
//		while (resultSet.next()) {
//			String country = resultSet.getString("COUNTRY");
//			String report = resultSet.getString("REPORT");
//			System.out.println("Country: " + country);
//			System.out.println("Report: " + report);
//		}
//	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			// Ignore
		}
	}

	/**
	 * Accepts a query from another place and processes it, storing results in
	 * the database.
	 * 
	 * @param query
	 */
	public void writeEntry(String tblName, Map<String, String> columnsValues)
			throws Exception {
		try {
			// This code is copied and tweaked from vogella
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/"
					+ dbName + "?" + "user=" + userName + "&password="
					+ passWord);
			statement = connect.createStatement();
			String query = "insert into " + tblName + "values (";
			Iterator<String> columnsIt = columnsValues.keySet().iterator();
			while (columnsIt.hasNext()) {
				String column = columnsIt.next();
				String value = columnsValues.get(column);
				query += "'" + value + "',";
			}
			query = query.substring(0, query.length() - 1);
			query += ");";
			resultSet = statement
					.executeQuery(query);
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	/**
	 * Accepts a query from another place and processes it, returning search
	 * results as a String.
	 * 
	 * @param query
	 */
	public ResultSet retrieveEntries(String query) throws Exception {
		try {
			// This code is copied and tweaked from vogella
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/"
					+ dbName + "?" + "user=" + userName + "&password="
					+ passWord);
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			return resultSet; // It's up to the caller to process these results
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
}