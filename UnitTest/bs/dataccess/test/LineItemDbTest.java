package bs.dataccess.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bs.dataaccess.BookDb;
import bs.dataaccess.InvoiceDb;
import bs.dataaccess.LineItemDb;
import bs.models.Invoice;
import bs.models.LineItem;

public class LineItemDbTest {
	private LineItem l;
	private Invoice i;
	private LineItem returned;
	private List<LineItem> list;

	@Before
	public void setUp() throws Exception {
		l = new LineItem();
		i = new Invoice();
		returned = new LineItem();
		list = new ArrayList<LineItem>();
	}

	/*@Test
	public void testCreateLineItem() {
		l.setBook(BookDb.getBook(1));
		l.setQuantity(2);
		
		i = InvoiceDb.getInvoice(1);
		
		returned = LineItemDb.createLineItem(l, i);
		
		assertEquals(123456789, returned.getBook().getISBN());
		assertEquals(null, 19.99, returned.getBook().getPrice(), 0.0);
		assertEquals("Test sum", returned.getBook().getSummary());
		assertEquals("Title test", returned.getBook().getTitle());
		assertEquals(2, returned.getQuantity());
	}

	@Test
	public void testSelectLineItems() {
		
		list = LineItemDb.selectLineItems(1);
		
		assertEquals(4, list.size());
		assertEquals(123456789, list.get(0).getBook().getISBN());
	}*/
	
	@Test
	public void testGetItem() {
		
		LineItem i =  LineItemDb.getLineItem(1);
		
		assertEquals(1, i.getId());
		assertEquals(1, i.getBook().getId());
	}

}
