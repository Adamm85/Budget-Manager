package BudgetManager;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BudgetManager.View.BudgetFrame;
import BudgetManager.View.LoginFrame;

public class Logger {

	private static String login;
	private static String password;
	private static String loggerQuery;
	private static String checkLogin;
	
	public String login() {
		return login = LoginFrame.getLogin();
	}
	
	public String pass() throws NoSuchAlgorithmException {
		password = MD5Coding.md5(LoginFrame.getPassword());
		return password;
	}
	
	public String loggerQuery() throws NoSuchAlgorithmException {
		loggerQuery = "select '" + login() + "' from \"User\" where password='" + pass() + "';";
		return loggerQuery;
	}
	
	public void checkLogIn() throws SQLException, NoSuchAlgorithmException {		
		dbConnection.dbConn();
		checkLogin = dbConnection.resultsetUser(loggerQuery());
	    if(login.equals(checkLogin) && !login.equals("")) {
			BudgetManager.View.LoginFrame.loginWindow.dispose();
	    	BudgetFrame budgetframe = new BudgetFrame();
			budgetframe.createAndShowGUI();
		}else {
			JOptionPane.showMessageDialog(null, "Wrong Login or Password");
		}
	}
}
