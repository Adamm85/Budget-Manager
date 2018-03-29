package BudgetManager;

import javax.xml.crypto.Data;

public class Cost {
	
	int cost;
	String description;
	Data data;
	
	public Cost() {
		
	}
	
	public Cost(int newCost, String newDescription, Data newData) {
		newCost = cost;
		newDescription = description;
		newData = data;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Data getData() {
		return data;
	}
	
	
	
	
	
}
