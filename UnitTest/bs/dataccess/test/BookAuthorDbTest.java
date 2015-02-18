package bs.dataccess.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bs.dataaccess.AuthorDb;
import bs.dataaccess.BookAuthorDb;
import bs.dataaccess.BookDb;
import bs.models.Author;
import bs.models.Book;

public class BookAuthorDbTest {
	private Book book;
	private Author author;
	private List<Book> bList;
	private List<Author> aList;

	@Before
	public void setUp() throws Exception {
		book = new Book();
		author = new Author();
		bList = new ArrayList<Book>();
		aList = new ArrayList<Author>();
	}

	@Test
	public void testInsertIntoBA() {
		book = BookDb.getBook(2);
		int bookId = book.getId();
		author = AuthorDb.getAuthor(1);
		int authorId = author.getId();
		BookAuthorDb.insertIntoBA(bookId, authorId);

	}

	@Test
	public void testGetBookByAuthor() {
		bList = BookAuthorDb.getBookByAuthor(1);

		assertEquals(10, bList.size());

	}

	@Test
	public void testGetAuthorByBook() {
		aList = BookAuthorDb.getAuthorByBook(1);
		
		assertEquals(1, aList.size());
		assertEquals("Test", aList.get(0).getFirstName());
		assertEquals("Test", aList.get(0).getLastName());
		assertEquals("Test", aList.get(0).getBiography());
	}

}
