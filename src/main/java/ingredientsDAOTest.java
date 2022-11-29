import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class ingredientsDAOTest {
	ingredientsDAO ingDAO = new ingredientsDAO();
	int recipeid = 1;

	@Test
	void testSpecificIngredients() throws SQLException {
		ingredients actual = ingDAO.specificIngredients(recipeid);
		ingredients expected = new ingredients("chicken", "greenbeans", "tomato", "pesto", "", "", "", "", "", "");
		assertEquals(expected, actual);
	}

}
