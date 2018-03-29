package BudgetManager;

import java.sql.*;

public class dbConnection {
	
	static private String urlDatabase = "jdbc:postgresql://localhost:5432/BM_Database";
	static private String user = "postgres";
	static private String pass = "Aa123$qwe";
	static private Connection conn;
	static private Statement statement;
	static private ResultSet resultset;
	
	public static void dbConn() throws SQLException {
		conn();
		statement();
	}
	
	public static Connection conn() {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			conn = DriverManager.getConnection(urlDatabase, user , pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Statement statement() throws SQLException {
		statement = conn.createStatement();
		return statement;
	}
	
	public static void resultset(String query) throws SQLException {
		resultset = statement.executeQuery(query);
		while(resultset.next()) {
			System.out.println(resultset.getString("budget_id") + " " + resultset.getString("budget_name") + " " + resultset.getString("budget_description") + " " + resultset.getString("user_id"));
		}
		resultset.close();
		statement.close();
		conn.close();
	}
	
	public static String resultsetUser(String query) throws SQLException {
		String login = "";
		resultset = statement.executeQuery(query);
		if(resultset.next()) {
			login = resultset.getString(1);
			System.out.println("login " + login);
		}
		resultset.close();
		statement.close();
		conn.close();
		return login;
	}	
}
