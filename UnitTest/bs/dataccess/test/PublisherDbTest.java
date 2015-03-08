package bs.dataccess.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bs.dataaccess.PublisherDb;
import bs.models.Publisher;

public class PublisherDbTest {
	private Publisher p; 

	@Before
	public void setUp() throws Exception {
		p = new Publisher("cName", "address1", "address2", "city", "wa", 98103, "1234567", "poc");
	}

	@Test
	public void testCreatePublisher() {
		Publisher returned = PublisherDb.createPublisher(p);
		
		assertEquals("cName", returned.getCompanyName());
		assertEquals("address1", returned.getAddress());
		assertEquals("address2", returned.getAddress2());
		assertEquals("city", returned.getCity());
		assertEquals("wa", returned.getState());
		assertEquals(98103, returned.getZipCode());
		assertEquals("1234567", returned.getPhone());
		assertEquals("poc", returned.getPointOfContact());
	}

	@Test
	public void testUpdatePublisher() {
		Publisher update = PublisherDb.getPublisher(1);
		
		update.setCompanyName("update");
		update.setAddress("update");
		update.setAddress2("update");
		update.setCity("update");
		update.setState("up");
		update.setZipCode(12345);
		update.setPhone("7654321");
		update.setPointOfContact("update");
		
		Publisher returned = PublisherDb.updatePublisher(update);
		
		assertEquals("update", returned.getCompanyName());
		assertEquals("update", returned.getAddress());
		assertEquals("update", returned.getAddress2());
		assertEquals("update", returned.getCity());
		assertEquals("up", returned.getState());
		assertEquals(12345, returned.getZipCode());
		assertEquals("7654321", returned.getPhone());
		assertEquals("update", returned.getPointOfContact());
	}

	@Test
	public void testGetPublisher() {
		Publisher returned = PublisherDb.getPublisher(2);
		
		assertEquals("cName", returned.getCompanyName());
		assertEquals("address1", returned.getAddress());
		assertEquals("address2", returned.getAddress2());
		assertEquals("city", returned.getCity());
		assertEquals("wa", returned.getState());
		assertEquals(98103, returned.getZipCode());
		assertEquals("1234567", returned.getPhone());
		assertEquals("poc", returned.getPointOfContact());
	}

	@Test
	public void testDeletePublisher() {
		Publisher delete = PublisherDb.getPublisher(5);
		
		int result = PublisherDb.deletePublisher(delete);
		
		assertEquals(1, result);
	}

}
