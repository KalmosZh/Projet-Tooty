package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Jeu.Grille;

class GrilleTest {

	@Test
	void testAjoutCarreau() {
		Grille g = new Grille ();
		assertFalse(g.vide());
	}

}
