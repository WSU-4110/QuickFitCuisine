package quick;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class userTest {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testUser() {
		user user = new user();
		user.setEmail("brandondenha@gmail.com");
		user.setPassword("pass1234");
		assertEquals("brandondenha@gmail.com", user.getEmail());
		assertEquals("pass1234", user.getPassword());
	}

	@Test
	public void testUserString() {
		user user = new user("brandondenha@gmail.com");
		String expected = "brandondenha@gmail.com";
		assertEquals(expected, user.getEmail());
	}

	@Test
	public void testUserStringString() {
		user user = new user("brandondenha@gmail.com", "pass1234");
		String expectedEmail = "brandondenha@gmail.com";
		String expectedPassword = "pass1234";
		assertEquals(expectedEmail, user.getEmail());
		assertEquals(expectedPassword, user.getPassword());
	}

	@Test
	public void testGetEmail() {
		user user = new user();
		String expected = "brandondenha@gmail.com";
		user.setEmail("brandondenha@gmail.com");
		String actual = user.getEmail();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetEmail() {
		user user = new user();
		String email = "brandondenha@gmail.com";
		user.setEmail(email);
		assertEquals(user.getEmail(), email);
	}

	@Test
	public void testGetPassword() {
		user user = new user();
		String expected = "pass1234";
		user.setPassword("pass1234");
		String actual = user.getPassword();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetPassword() {
		user user = new user();
		String password = "pass1234";
		user.setPassword(password);
		assertEquals(user.getPassword(), password);
	}

}
