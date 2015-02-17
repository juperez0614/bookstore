package bs.models;

import java.util.List;
import java.io.Serializable;

public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<LineItem> lineItems;
	
	public Cart(){}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	} 
	
	public void addLineItem(LineItem lineItem){
		lineItems.add(lineItem);
	}
	
	public void removeLineItem(LineItem lineItem){
		lineItems.remove(lineItem);
	}
	
	public void decreaseQuantity(LineItem lineItem){
		int quantity = lineItem.getQuantity() - 1; 
		lineItem.setQuantity(quantity);
	}
	
	public void addQuantity(LineItem lineItem){
		int quantity = lineItem.getQuantity() + 1; 
		lineItem.setQuantity(quantity);
	}

}
