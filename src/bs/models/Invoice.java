package bs.models;

import java.io.Serializable;
import java.util.Date;

public class Invoice implements Serializable {
	private static final long serialVersionUID = 4L;
	private Book bookId; 
	private Author authorId; 
	private String paymentType; 
	private Date transactionDate;
	private double totalAmount; 
	private boolean isProcessed; 
	
	public Invoice(){}
	
	public Invoice (Book bookId, Author authorId, String paymentType, Date transactionDate,
			double totalAmount, boolean isProcessed){
		this.bookId = bookId;
		this.authorId = authorId; 
		this.paymentType = paymentType;
		this.transactionDate = transactionDate;
		this.totalAmount = totalAmount; 
		this.isProcessed = isProcessed; 
	}

	public Book getBookId() {
		return bookId;
	}

	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}

	public Author getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Author authorId) {
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
