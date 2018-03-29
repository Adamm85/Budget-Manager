package BudgetManager;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Logger {

	private static String login;
	private static String password;
	private static String loggerQuery;
	private static String checkLogin;
	
	public void checkLogIn() throws SQLException, NoSuchAlgorithmException {
		login = LoginFrame.getLogin();
		password = MD5Coding.md5(LoginFrame.getPassword());
		loggerQuery = "select '" + login + "' from \"User\" where password='" + password + "';";
		dbConnection.dbConn();
		dbConnection.statement();
		System.out.println(loggerQuery);
		checkLogin = dbConnection.resultsetUser(loggerQuery);
	    if(login.equals(checkLogin) && !login.equals("")) {
			BudgetFrame.createAndShowGUI();
		}else {
			JOptionPane.showMessageDialog(null, "Wrong Login or Password");
		}
	}
}
