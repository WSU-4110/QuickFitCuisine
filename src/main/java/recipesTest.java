import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class recipesTest {
	
	recipes recipe;
	recipes test;
	
	@BeforeEach
	void setUp() {
		String link = "https://tasty.co/recipe/weekday-meal-prep-pesto-chicken-veggies";
		String name = "Pesto Chicken & Veggies";
		int time = 22;
		int count = 4;
		recipe = new recipes(link, name, time, count);
	}
	
	@AfterEach
	void tearDown() {
		recipe = null;
		test = null;
	}
	
	@Test
	void getLink() {
		String expected = "https://tasty.co/recipe/weekday-meal-prep-pesto-chicken-veggies";
		String actual = recipe.getLink();
		assertEquals(expected, actual);
	}
	
	@Test
	void setLink() {
		test = new recipes("", "", 0, 0);
		test.setLink("https://tasty.co/recipe/weekday-meal-prep-pesto-chicken-veggies");
		String expected = "https://tasty.co/recipe/weekday-meal-prep-pesto-chicken-veggies";
		String actual = test.getLink();
		assertEquals(expected, actual);
	}
	
	@Test
	void getName() {
		String expected = "Pesto Chicken & Veggies";
		String actual = recipe.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	void setName() {
		test = new recipes("", "", 0, 0);
		test.setName("Pesto Chicken & Veggies");
		String expected = "Pesto Chicken & Veggies";
		String actual = test.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	void getTime() {
		int expected = 22;
		int actual = recipe.getTime();
		assertEquals(expected, actual);
	}
	
	@Test
	void setTime() {
		test = new recipes("", "", 0, 0);
		test.setTime(22);
		int expected = 22;
		int actual = test.getTime();
		assertEquals(expected, actual);
	}
	
	@Test
	void getCount() {
		int expected = 4;
		int actual = recipe.getCount();
		assertEquals(expected, actual);
	}
	
	@Test
	void setCount() {
		test = new recipes("", "", 0, 0);
		test.setCount(4);
		int expected = 4;
		int actual = test.getCount();
		assertEquals(expected, actual);
	}

}
