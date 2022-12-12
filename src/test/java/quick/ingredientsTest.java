package quick;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ingredientsTest {

	ingredients ing = new ingredients(1, "chicken", "greenbeans", "tomato", "pesto", "", "", "", "", "", "");

	@BeforeEach
	public void setUp() throws Exception {
		ing = new ingredients(1, "chicken", "greenbeans", "tomato", "pesto", "", "", "", "", "", "");
	}

	@AfterEach
	public void tearDown() throws Exception {
		ing = new ingredients();
	}

	@Test
	public void testGetRecipeid() {
		int actual = ing.getRecipeid();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetRecipeid() {
		ing.setRecipeid(2);
		assertEquals(2, ing.getRecipeid());
	}

	@Test
	public void testGetIngredient1() {
		String actual = ing.getIngredient1();
		String expected = "chicken";
		assertEquals(expected, actual);
	}

	@Test
	public void testSetIngredient1() {
		ing.setIngredient1("lemon");
		assertEquals("lemon", ing.getIngredient1());
	}

	@Test
	public void testGetIngredient2() {
		String actual = ing.getIngredient2();
		String expected = "greenbeans";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetIngredient3() {
		String actual = ing.getIngredient3();
		String expected = "tomato";
		assertEquals(expected, actual);
	}
}
