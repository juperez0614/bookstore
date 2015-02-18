package bs.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Invoice implements Serializable {
	private static final long serialVersionUID = 4L;
	private int id;
	private Customer customer;
	private String paymentType;
	private Date transactionDate;
	private double totalAmount;
	private boolean isProcessed;
	private List<LineItem> lineItems;

	public Invoice() {
	}

	public Invoice(String paymentType, Date transactionDate,
			double totalAmount, boolean isProcessed) {
		this.paymentType = paymentType;
		this.transactionDate = transactionDate;
		this.totalAmount = totalAmount;
		this.isProcessed = isProcessed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
