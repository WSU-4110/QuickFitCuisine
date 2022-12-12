package quick;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class savedRecipesTest {
	savedRecipes sr = new savedRecipes("d@gmail.com", 2);
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		sr = new savedRecipes("d@gmail.com", 2);
	}

	@AfterEach
	public void tearDown() throws Exception {
		sr = new savedRecipes("d@gmail.com", 2);
	}

	@Test
	public void testGetEmail() {
		String actual = sr.getEmail();
		String expected = "d@gmail.com";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetEmail() {
		sr.setEmail("a@gmail.com");
		assertEquals("a@gmail.com", sr.getEmail());
	}
	
	@Test
	public void testGetRecipeid() {
		int actual = sr.getRecipeid();
		System.out.println(actual);
		int expected = 2;
		System.out.println(expected);
		assertEquals(expected, actual);
	}

	@Test
	public void testSetRecipeid() {
		sr.setRecipeid(3);
		assertEquals(3, sr.getRecipeid());
	}
}