package bs.dataccess.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import bs.models.*;
public class LineItemDbTest {

	@Before
	public void setUp() throws Exception {
		LineItem i = new LineItem();
		Book b = new Book(01, 19.99, "sum", "a");
		i.setBook(b);
		i.setQuantity(2);
		Invoice ic = new Invoice(); 
	}

	@Test
	public void testCreateLineItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectLineItems() {
		
	}

}
