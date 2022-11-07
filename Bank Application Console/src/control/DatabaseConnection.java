package control;

import java.sql.*;

public class DatabaseConnection {

	static DatabaseConnection databaseConnection;
	private Statement statement;

	private DatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_account_management",
					"root", "Ranjithkumar@1705");
			statement = connect.createStatement();

		} catch (Exception e) {
			System.out.println("Database Not Connected ! ");
		}
	}

	static public Statement getStatement() {
		if (databaseConnection == null) {
			databaseConnection = new DatabaseConnection();
		}
		return databaseConnection.statement;

	}

}
