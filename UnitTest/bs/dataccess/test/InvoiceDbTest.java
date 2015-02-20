package bs.dataccess.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import bs.dataaccess.CustomerDb;
import bs.dataaccess.InvoiceDb;
import bs.models.Invoice;

public class InvoiceDbTest {

	private Invoice i;
	private Invoice returned;
	@Before
	public void setUp() throws Exception {
		i = new Invoice("pay", new Date(123435243),0.0, false);
		returned = new Invoice();
	}

	@Test
	public void testCreateInvoice() {
		i.setCustomer(CustomerDb.getCustomer(1));
		returned = InvoiceDb.createInvoice(i);
		
	}

	@Test
	public void testUpdateInvoice() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectUnprocessedInvoices() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInvoice() {
		fail("Not yet implemented");
	}

}
