package BudgetManager;

import java.sql.SQLException;

public class MainClass {
	
	static private String query = "select * from \"Budget\";";
	
	public static void main(String[] args) throws SQLException {
		
		dbConnection.dbConn();
		dbConnection.statement();
		dbConnection.resultset(query);
		LoginFrame loginWindow = new LoginFrame();
	}
}
