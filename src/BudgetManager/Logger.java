package BudgetManager;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Logger {

	private static String login;
	private static String password;
	private static String loggerQuery;
	private static String checkLogin;
	
	public String login() {
		return login = LoginFrame.getLogin();
	}
	
	public String pass() throws NoSuchAlgorithmException {
		return password = MD5Coding.md5(LoginFrame.getPassword());
	}
	
	public String loggerQuery() throws NoSuchAlgorithmException {
		return loggerQuery = "select '" + login() + "' from \"User\" where password='" + pass() + "';";
	}
	
	public void checkLogIn() throws SQLException, NoSuchAlgorithmException {		
		dbConnection.dbConn();
		checkLogin = dbConnection.resultsetUser(loggerQuery());
	    if(login.equals(checkLogin) && !login.equals("")) {
			LoginFrame.loginWindow.dispose();
	    	BudgetFrame.createAndShowGUI();
		}else {
			JOptionPane.showMessageDialog(null, "Wrong Login or Password");
		}
	}
}
