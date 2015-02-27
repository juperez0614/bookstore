package bs.models;

import java.io.Serializable;

public class MonthlyProfit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int monthId;
	private double profit;
	public MonthlyProfit(){}
	public MonthlyProfit (int monthId, double profit){
		this.monthId = monthId;
		this.profit = profit; 
	}
	public int getMonthId() {
		return monthId;
	}
	public void setMonthId(int monthId) {
		this.monthId = monthId;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	
}
