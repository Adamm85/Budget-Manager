package BudgetManager.View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class NewCostFrame extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame newCostFrame;
	private static JTextArea newCostDescription;
	private static JPanel costsDownPanel, costsTopPanel;
	private static JButton newCost, cancelNewCost, newBudget;
	private static JLabel costNameLabel, costDateLabel, costBudgetLabel, amountLabel, newCostDescriptionLabel;
	private static JTextField costNameField, costDateField, amountField;
	private static JComboBox<Object> costBudgetBox;
	private JScrollPane scrollDescription;
	private static Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	private static TitledBorder title;

		public void CreateAndShowNewCost() {
			newCostFrame = new JFrame();
			newCostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newCostFrame.setResizable(false);
			OptionsFrame newContentPane = new OptionsFrame();
			newContentPane.setOpaque(true);
			newCostFrame.setContentPane(newContentPane);
			title = BorderFactory.createTitledBorder(loweredetched, "New Cost");
			title.setTitleJustification(TitledBorder.CENTER);
			newContentPane.setBorder(title);
			
			newContentPane.setPreferredSize(new Dimension(260,500));
			
			costsTopPanel = new JPanel();
			costsDownPanel = new JPanel();
			newContentPane.add(costsTopPanel);
			costsTopPanel.setLayout(new GridLayout(11,0));
			newContentPane.add(costsDownPanel);
			costsDownPanel.setLayout(new GridLayout(3,0));
			
			costNameLabel = new JLabel("Cost Name");
			costDateLabel = new JLabel("Cost Date");
			costBudgetLabel = new JLabel("Cost Budget");
			amountLabel = new JLabel("Amount");
			costNameField = new JTextField();
			costNameField.setPreferredSize(new Dimension(230, 30));
			costDateField = new JTextField();
			costDateField.setPreferredSize(new Dimension(230, 30));
			costBudgetBox = new JComboBox<Object>();
			amountField = new JTextField();
			amountField.setPreferredSize(new Dimension(230, 30));
			newCostDescriptionLabel = new JLabel("Description");
			newCostDescription = new JTextArea();
			scrollDescription = new JScrollPane (newCostDescription);
			
			costsTopPanel.add(costNameLabel);
			costsTopPanel.add(costNameField);
			costsTopPanel.add(costDateLabel);
			costsTopPanel.add(costDateField);
			costsTopPanel.add(costBudgetLabel);
			costsTopPanel.add(costBudgetBox);
			costsTopPanel.add(amountLabel);
			costsTopPanel.add(amountField);
			costsTopPanel.add(newCostDescriptionLabel);
			costsTopPanel.add(scrollDescription);
			
			newCost = new JButton("Add Cost");
			newBudget = new JButton("Add New Budget");
			cancelNewCost = new JButton("Cancel");
			newCost.setPreferredSize(new Dimension(230, 35));
			newBudget.setPreferredSize(new Dimension(230, 35));
			cancelNewCost.setPreferredSize(new Dimension(230, 35));
			
			title = BorderFactory.createTitledBorder(loweredetched, "Menu");
			title.setTitleJustification(TitledBorder.CENTER);
			costsDownPanel.setBorder(title);
			costsDownPanel.add(newCost);
			costsDownPanel.add(newBudget);
			costsDownPanel.add(cancelNewCost);
			
			listeners();
			newCostFrame.pack();
			newCostFrame.setVisible(true);
	}
		
		public void listeners() {
			newCost.addActionListener(this);
			newBudget.addActionListener(this);		
			cancelNewCost.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent a) {
			Object source = a.getSource();
			if(source == newCost) {
				
			}
			if(source == newBudget) {
				
			}
			if(source == cancelNewCost) {
				BudgetFrame budgetFrame = new BudgetFrame();
				budgetFrame.createAndShowGUI();
				newCostFrame.dispose();
			}
			
		}
}
