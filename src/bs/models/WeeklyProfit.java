package bs.models;

import java.io.Serializable;

public class WeeklyProfit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int weekId;
	private double profit; 
	
	public WeeklyProfit(){}
	
	public WeeklyProfit(int weekId, double profit){
		this.weekId = weekId;
		this.profit = profit; 
	}

	public int getWeekId() {
		return weekId;
	}

	public void setWeekId(int weekId) {
		this.weekId = weekId;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

}
