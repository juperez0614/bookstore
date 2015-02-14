package bs.dataccess.test;

import static org.junit.Assert.*;
import bs.dataaccess.AuthorDb;
import bs.models.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorDbTest {
	Author a;

	@Before
	public void setUp() throws Exception {
		a = new Author("Test", "Test", "Test");
	}

	@Test
	public void testCreateAuthor_ShouldPass() {
		Author returnedAuthor = AuthorDb.createAuthor(a);

		assertEquals("Test", returnedAuthor.getFirstName());
		assertEquals("Test", returnedAuthor.getLastName());
		assertEquals("Test", returnedAuthor.getBiography());
	}

	@Test
	public void testGetAuthor_ShouldPass() {
		Author returnedAuthor = AuthorDb.getAuthor(1);

		assertEquals(1, returnedAuthor.getId());
		assertEquals("Test", returnedAuthor.getFirstName());
		assertEquals("Test", returnedAuthor.getLastName());
		assertEquals("Test", returnedAuthor.getBiography());
	}

	@Test
	public void testUpdateAuthor_ShouldPass() {
		Author updateAuthor = AuthorDb.getAuthor(2);
		updateAuthor.setFirstName("Update");
		updateAuthor.setLastName("Testing");
		updateAuthor.setBiography("update bio");

		Author returnedAuthor = AuthorDb.updateAuthor(updateAuthor);

		assertEquals(2, returnedAuthor.getId());
		assertEquals("Update", returnedAuthor.getFirstName());
		assertEquals("Testing", returnedAuthor.getLastName());
		assertEquals("update bio", returnedAuthor.getBiography());
	}
	
	@Test
	public void testDeleteAuthor_ShouldPass() {
		Author delete = AuthorDb.getAuthor(3);
		int result = AuthorDb.deleteAuthor(delete);
		
		assertEquals(1, result);
	}

}
