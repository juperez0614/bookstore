package bs.dataccess.test;

import bs.dataaccess.CustomerDb;
import bs.models.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerDbTest {

	private Customer c; 
	@Before
	public void setUp() throws Exception {
		c = new Customer("test", "test", "test", "test", "test", "tt",1, "test", 1 );
	}

	@Test
	public void testCreateCustomer() {
		CustomerDb.createCustomer(c);
	}

	@Test
	public void testUpdateCustomer() {
		Customer update = CustomerDb.getCustomer(1);
		
		update.setFirstName("update");
		
		Customer returned = CustomerDb.updateCustomer(update);
		
		assertEquals("update", returned.getFirstName());
	}

	@Test
	public void testGetCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCustomer() {
		fail("Not yet implemented");
	}

}
