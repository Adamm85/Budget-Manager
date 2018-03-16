package BudgetManager;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class budgetFrame extends JPanel{

	
	private boolean DEBUG = false;
	private static Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	private static TitledBorder title;
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	budgetFrame(){
		super(new FlowLayout());

		JTable tableCost = new JTable();
		tableCost.setModel(new DefaultTableModel(
				new Object [][] {},
				new String [] { "Id", "Cost name", "Date", "Budget", "Free amount"}));
		tableCost.setPreferredScrollableViewportSize(new Dimension(580,480));
		tableCost.setFillsViewportHeight(true);
		
		if (DEBUG) {
			tableCost.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(tableCost);
				}
			});
		}
		
		JScrollPane scrollPane = new JScrollPane(tableCost);
		
		add(scrollPane);

	}
	
	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		TableModel model = table.getModel();
		
		for (int i = 0; i < numRows; i++) {
			System.out.print(" row " + i + ":");
			for(int j = 0; j < numCols; j++) {
				System.out.print(" " + model.getValueAt(i,j));
			}
		}
	}
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Budget Manager");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenu settings = new JMenu("Settings");
		JMenu about = new JMenu("About");
		menuBar.add(menu);
		menuBar.add(settings);
		menuBar.add(about);
		
		frame.setJMenuBar(menuBar);
		
		budgetFrame newContentPane = new budgetFrame();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		newContentPane.setPreferredSize(new Dimension(600, 600));
		title = BorderFactory.createTitledBorder(loweredetched, "Costs");
		title.setTitleJustification(TitledBorder.CENTER);
		newContentPane.setBorder(title);

		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BoxLayout(downPanel, BoxLayout.LINE_AXIS));
		
		frame.add(downPanel);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(1,0));
		JButton buttonAddCost = new JButton("New Cost");
		buttonAddCost.setPreferredSize(new Dimension(145,40));
		downPanel.add(leftPanel);
		leftPanel.add(buttonAddCost);
		
		title = BorderFactory.createTitledBorder(loweredetched, "Pop Menu");
		title.setTitleJustification(TitledBorder.CENTER);
		downPanel.setBorder(title);
		
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(1,0));
		JButton buttonExit = new JButton("Exit");
		JButton options = new JButton("Options");
		JButton showBudgets = new JButton("Budget Manager");
		downPanel.add(rightPanel);
		showBudgets.setPreferredSize(new Dimension(145,40));
		buttonExit.setPreferredSize(new Dimension(120,40));
		options.setPreferredSize(new Dimension(120,40));
		rightPanel.add(showBudgets);
		rightPanel.add(options);
		rightPanel.add(buttonExit);	
		
		frame.pack();
		frame.setVisible(true);				
	}
}
