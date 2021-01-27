package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Jeu.Liste;

class ListeTest {

	@Test
	void testChoixCarreau() {
		Liste l = new Liste();
		l.selectCarreau("ROUGE");
		assertFalse(l.DispoVide());
		assertFalse(l.ListeVide());
	}


}
