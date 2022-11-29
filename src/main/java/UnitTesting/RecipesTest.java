package UnitTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recipes.recipes;

public class RecipesTest {
	
	recipes recipe;
	
	@BeforeEach
	void setUp() {
		String link = "https://tasty.co/recipe/weekday-meal-prep-pesto-chicken-veggies";
		String name = "Pesto Chicken & Veggies";
		int time = 22;
		int count = 4;
		recipe = new recipes(link, name, time, count);
	}
	
	@AfterEach
	void tearDown() {}
	
	@Test
	void getRecipeid() {}
	
	@Test
	void setRecipeid() {}
	
	@Test
	void getLink() {}
	
	@Test
	void setLink() {}
	
	@Test
	void getName() {}
	
	@Test
	void setName() {}
	
	@Test
	void getTime() {}
	
	@Test
	void setTime() {}
	
	@Test
	void getCount() {}
	
	@Test
	void setCount() {}

}
