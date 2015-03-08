package bs.dataccess.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AuthorDbTest.class, BookAuthorDbTest.class, BookDbTest.class,
		CustomerDbTest.class, LineItemDbTest.class, PublisherDbTest.class,
		RatingDbTest.class, InvoiceDbTest.class })
public class DbAccessTests {

}
