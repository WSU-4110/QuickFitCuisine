package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qfc.ingredients;

class ingredientsTest {

	ingredients ing = new ingredients();

	@BeforeEach
	void setUp() throws Exception {
		ing = new ingredients(1, "chicken", "greenbeans", "tomato", "pesto", "", "", "", "", "", "");
	}

	@AfterEach
	void tearDown() throws Exception {
		ing = new ingredients();
	}

	@Test
	void testGetRecipeid() {
		int actual = ing.getRecipeid();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	void testSetRecipeid() {
		ing.setRecipeid(2);
		assertEquals(2, ing.getRecipeid());
	}

	@Test
	void testGetIngredient1() {
		String actual = ing.getIngredient1();
		String expected = "chicken";
		assertEquals(expected, actual);
	}

	@Test
	void testSetIngredient1() {
		ing.setIngredient1("lemon");
		assertEquals("lemon", ing.getIngredient1());
	}

	@Test
	void testGetIngredient2() {
		String actual = ing.getIngredient2();
		String expected = "greenbeans";
		assertEquals(expected, actual);
	}
}
