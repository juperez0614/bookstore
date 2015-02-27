package bs.dataccess.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bs.dataaccess.AuthorDb;
import bs.dataaccess.CustomerDb;
import bs.dataaccess.PublisherDb;
import bs.models.Author;
import bs.models.Customer;
import bs.models.Publisher;

public class PopTables {
	private Customer[] cArray;
	private Author[] aArray;
	private Publisher[] pArray;
	@Before
	public void setUp() throws Exception {
		cArray = new Customer [10];
		cArray[0] = new Customer("Julio", "Perez", "27950 NE 147th Circle", "Duvall", "WA", 98019, "jperez99@uw.edu", 99099);
		cArray[1] = new Customer("Jeff", "Asmus", "22567 NW 146th St", "Seattle", "WA", 98101, "jasmus08@uw.edu", 94335);
		cArray[2] = new Customer("Liz", "Perez", "27950 NE 147th Circle", "Duvall", "WA", 98019, "lper555@yahoo.com", 90876);
		cArray[3] = new Customer("Brian", "Seto", "28550 SE 147th Pl", "Goldbar", "WA", 98032, "bseto@microsoft.com", 93425);
		cArray[4] = new Customer("Matt", "Coard", "814 NE 4th Pl", "Redmond", "WA", 98054, "matt@uw.edu", 91123);
		cArray[5] = new Customer("Julie", "Richards", "814 NE 4th Pl", "Redmond", "WA", 98054, "jrichards@microsoft.com", 91298);
		cArray[6] = new Customer("Wendy", "Medina", "28550 SE 147th Pl", "Goldbar", "WA", 98032, "wmedina@uw.edu", 98076);
		cArray[7] = new Customer("Lidia", "Espinosa", "27950 NE 147th Circle", "Duvall", "WA", 98019, "lidia@uw.edu", 56234);
		cArray[8] = new Customer("Pablo", "Escobar", "1459 S Cocaine Rd", "Bogota", "CO", 00010, "pabloisalive@cia.gov", 83407);
		cArray[9] = new Customer("Osama", "BinDead", "666 Rip ln", "Hell", "WI", 44019, "terrorrist1@alibaba.cn", 71204);
		
		aArray = new Author[10];
		aArray[0] = new Author("Juan", "Coyote", "Bio for Juan Coyote");
		aArray[1] = new Author("Jill", "Danger", "Bio for Jill Danger");
		aArray[2] = new Author("Sterling", "Archer", "Bio for Sterling Archer");
		aArray[3] = new Author("George", "Michael", "Bio for George Michael");
		aArray[4] = new Author("Gob", "Geofferies", "Bio for Gob Geofferies");
		aArray[5] = new Author("Ben", "Button", "Bio for Ben Button");
		aArray[6] = new Author("Tony", "Stark", "Bio for Tony Stark");
		aArray[7] = new Author("Bruce", "Banner", "Bio for Bruce Banner");
		aArray[8] = new Author("Clark", "Kent", "Bio for Clark Kent");
		aArray[9] = new Author("Bruce", "Wayne", "Bio for Bruce Wayne");
		
		pArray = new Publisher[10];
		pArray[0] = new Publisher("GoodBooks", "123 Candycane Ln", "Seattle", "WA", 98110, "808-719-3232", "Kaleb McGraw");
		pArray[1] = new Publisher("BadBooks", "123 Candycane Ln", "Seattle", "WA", 98110, "426-736-3232", "John Outlaw");
		pArray[2] = new Publisher("GreatBooks", "123 Candycane Ln", "Seattle", "WA", 98110, "405-789-3232", "Michael Phelps");
		pArray[3] = new Publisher("BetterBooks", "444 kiddycorner st", "Seattle", "WA", 98110, "808-779-3232", "Jesus Martinez");
		pArray[4] = new Publisher("BestBooks", "999 Champion Ave", "Seattle", "WA", 98110, "808-732-3232", "Chris Crater");
		pArray[5] = new Publisher("GreaterBooks", "321 Candycorn Ln", "Nashville", "TN", 32101, "808-766-3232", "Gumbo Jenkins");
		pArray[6] = new Publisher("ExtremeBooks", "123 Skyhigh Tr", "Seattle", "WA", 98110, "305-719-3223", "Leroy Hilliford");
		pArray[7] = new Publisher("Awful Books", "333 Garbage St", "Philidelphia", "PA", 69808, "808-919-3232", "Joe Celeb");
		pArray[8] = new Publisher("ReligiousBooks", "777 Heaven Rd", "Seattle", "WA", 98110, "808-319-3232", "Jack Frost");
		pArray[9] = new Publisher("SatanicBooks", "999 Upsidedown Ln", "Miami", "FL", 33014, "808-419-3232", "Abe Acerater");
		
	}

	@Test
	public void test() {
		for ( int i = 0; i < 10; i++){
			CustomerDb.createCustomer(cArray[i]);
		}
		
		for ( int i = 0; i < 10; i++){
			AuthorDb.createAuthor(aArray[i]);
		}
		
		for ( int i = 0; i < 10; i++){
			PublisherDb.createPublisher(pArray[i]);
		}
	}

}
