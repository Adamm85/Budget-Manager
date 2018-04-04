package BudgetManager.View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import BudgetManager.Logger;

public class LoginFrame implements ActionListener {

	private JPanel mainPanelLogin, topPanelLogin, downPanelLogin;
	private JLabel loginLabel, passLabel;
	private static JTextField loginTF;
	private static JPasswordField passwordTF;
	JButton loginButton, cancelLoginButton;
	private Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	private TitledBorder title;
	public static JFrame loginWindow;
	
	public void initComponents() {
		loginWindow = new JFrame("Logger");
		loginWindow.setResizable(false);
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanelLogin = new JPanel();
		loginWindow.add(mainPanelLogin);
		topPanelLogin = new JPanel();
		downPanelLogin = new JPanel();
		topPanelLogin.setLayout(new GridLayout(2,0));
		downPanelLogin.setLayout(new GridLayout(2,0));
		
		title = BorderFactory.createTitledBorder(loweredetched, "Budget Logger");
		title.setTitleJustification(TitledBorder.LEFT);
		topPanelLogin.setBorder(title);
		
		mainPanelLogin.add(topPanelLogin);
		mainPanelLogin.add(downPanelLogin);
			
		loginLabel = new JLabel("Your Login: ");
		passLabel = new JLabel("Your Password: ");
		
		loginTF = new JTextField();
		passwordTF = new JPasswordField();
		loginTF.setPreferredSize(new Dimension(130,25));
		passwordTF.setPreferredSize(new Dimension(130,25));
		
		topPanelLogin.add(loginLabel);
		topPanelLogin.add(loginTF);
		topPanelLogin.add(passLabel);
		topPanelLogin.add(passwordTF);
		 
		loginButton = new JButton("Log in");
		cancelLoginButton = new JButton("Cancel");
		loginButton.setPreferredSize(new Dimension(120,30));
		cancelLoginButton.setPreferredSize(new Dimension(120,30));
		
		downPanelLogin.add(loginButton);
		downPanelLogin.add(cancelLoginButton);
		
		listeners();
		loginWindow.pack();
		loginWindow.setVisible(true);
	}
	
	public void listeners() {
		loginButton.addActionListener(this);
		cancelLoginButton.addActionListener(this);
	}
	
	public static String getLogin() {
		return loginTF.getText();
	}
	
	@SuppressWarnings("deprecation")
	public static String getPassword() {
		return passwordTF.getText();
	}
	
	public static JFrame loginFrame() {
		return loginWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		if(source == loginButton) {
			Logger logger = new Logger();
			try {
				logger.checkLogIn();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(source == cancelLoginButton) {
			loginWindow.dispose();
		}
	}
}
