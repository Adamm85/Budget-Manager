package BudgetManager.View;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OptionsFrame extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void CreateAndShowOptions() {
		JFrame optionFrame = new JFrame();
		optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OptionsFrame newContentPane = new OptionsFrame();
		newContentPane.setOpaque(true);
		optionFrame.setContentPane(newContentPane);
		
		newContentPane.setPreferredSize(new Dimension(500,500));
		
		optionFrame.pack();
		optionFrame.setVisible(true);
	}
}
