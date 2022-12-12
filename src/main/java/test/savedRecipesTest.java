package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qfc.savedRecipes;

class savedRecipesTest {
	savedRecipes sr = new savedRecipes("d@gmail.com", 2);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		sr = new savedRecipes("d@gmail.com", 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		sr = new savedRecipes();
	}

	@Test
	void testGetEmail() {
		String actual = sr.getEmail();
		String expected = "d@gmail.com";
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetEmail() {
		sr.setEmail("a@gmail.com");
		assertEquals("a@gmail.com", sr.getEmail());
	}
	
	@Test
	void testGetRecipeid() {
		int actual = sr.getRecipeid();
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	void testSetRecipeid() {
		sr.setRecipeid(3);
		assertEquals(3, sr.getRecipeid());
	}
}