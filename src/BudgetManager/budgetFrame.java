package BudgetManager;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class budgetFrame extends JPanel{

	
	private boolean DEBUG = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	budgetFrame(){
		super(new GridLayout(1,0));
		JTable tableCost = new JTable();
		tableCost.setModel(new DefaultTableModel(
				new Object [][] {},
				new String [] { "Id", "Cost name", "Date", "Free amount", "Budget"}));
		tableCost.setPreferredScrollableViewportSize(new Dimension(500,70));
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
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		budgetFrame newContentPane = new budgetFrame();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		frame.pack();
		frame.setVisible(true);
		
	}
}
