package bs.dataccess.test;

import static org.junit.Assert.*;
import bs.models.*;
import bs.dataaccess.*;

import org.junit.Before;
import org.junit.Test;

public class BookDbTest {
	Book b; 
	@Before
	public void setUp() throws Exception {
		b = new Book(123456789, 19.99,"Test sum", "Title test");
	}

	@Test
	public void testCreateBook() {
		Book returnedBook = BookDb.createBook(b);
		
		assertEquals(123456789, returnedBook.getISBN());
		assertEquals(null, 19.99, returnedBook.getPrice(), 0.0);
		assertEquals("Test sum", returnedBook.getSummary());
		assertEquals("Title test", returnedBook.getTitle());
	}

	@Test
	public void testUpdateBook() {
		Book update = BookDb.getBook(1);
		update.setISBN(987654321);
		update.setPrice(0.50);
		update.setSummary("update sum");
		update.setTitle("update title");

		Book returnedBook = BookDb.updateBook(update);

		assertEquals(987654321, returnedBook.getISBN());
		assertEquals(null, 0.50, returnedBook.getPrice(), 0.0);
		assertEquals("update sum", returnedBook.getSummary());
		assertEquals("update title", returnedBook.getTitle());
	}

	@Test
	public void testGetBook() {
		Book returnedBook = BookDb.getBook(2);
		
		assertEquals(2, returnedBook.getId());
		assertEquals(123456789, returnedBook.getISBN());
		assertEquals(null, 19.99, returnedBook.getPrice(), 0.0);
		assertEquals("Test sum", returnedBook.getSummary());
		assertEquals("Title test", returnedBook.getTitle());
	}

	@Test
	public void testDeleteBook() {
		Book book = BookDb.getBook(3);
		int result = BookDb.deleteBook(book);
		
		assertEquals(1, result);
	}

}
