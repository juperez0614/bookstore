package bs.models;

import java.io.Serializable;
import java.util.Date;

public class Invoice implements Serializable {
	private static final long serialVersionUID = 4L;
	private int id;
	private int bookId; 
	private int authorId; 
	private String paymentType; 
	private Date transactionDate;
	private double totalAmount; 
	private boolean isProcessed; 
	
	public Invoice(){}
	
	public Invoice (int id, int bookId, int authorId, String paymentType, Date transactionDate,
			double totalAmount, boolean isProcessed){
		this.id = id;
		this.bookId = bookId;
		this.authorId = authorId; 
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

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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
}
