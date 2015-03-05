package bs.dataccess.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bs.dataaccess.UserAuthDb;
import bs.models.UserAuth;

public class UserAuthDbTest {
UserAuth a;
	@Before
	public void setUp() throws Exception {
		a = new UserAuth("user", "pass");
	}

	@Test
	public void testCreateUserAuth() {
		UserAuth b = UserAuthDb.createUserAuth(a);
		assertEquals("user", b.getUsername());
		assertEquals("pass", b.getPassword());
	}

}
