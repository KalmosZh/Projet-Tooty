package Test;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Jeu.Paquet;

class PaquetTest {

	@Test
	void testTirerCarte() {
		Paquet p = new Paquet();
		assertFalse(p.Vide());
		p.tirer();
	}

}
