package bs.dataccess.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bs.dataaccess.RatingDb;
import bs.models.Rating;

public class RatingDbTest {
	private Rating r; 
	private Rating returned;
	private Rating delete;

	@Before
	public void setUp() throws Exception {
		r = new Rating(4, "review");
		returned = new Rating();
		delete = new Rating();
	}

	@Test
	public void testCreateRating() {
		returned = RatingDb.createRating(r);
		
		assertEquals(4, returned.getRating());
		assertEquals("review", returned.getReview());
	}

	@Test
	public void testGetRating() {
		returned = RatingDb.getRating(1);
		
		assertEquals(4, returned.getRating());
		assertEquals("review", returned.getReview());
	}

	@Test
	public void testDeleteRating() {
		delete = RatingDb.getRating(2);
		
		int result = RatingDb.deleteRating(delete);
		
		assertEquals(1, result);
	}
}
