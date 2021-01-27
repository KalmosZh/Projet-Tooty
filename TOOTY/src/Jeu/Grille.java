package Jeu;
import java.util.ArrayList;

public class Grille {
	private final int largeur = 5;
	private ArrayList<Character[]> Mur;
	public int regle = 0;
	
	/*
	 * Création d'une nouvelle grille 
	 */
	
	public Grille() {
		Mur = new ArrayList<Character[]>();
		Mur.add(new Character[] {' ',' ',' ',' ',' ',' '});
    }
	
	/*
	 * Ajout d'un carreau sur le mur avec contrainte
	 */
	
	public void Ajout(int x, int y, Carreau c) {
		int arret = 0;
		int ligne = x + c.getlargeur();
		int colonne = y + c.gethauteur();
		while(Mur.size() < colonne + 1) {									//ajout d'une ligne vide dans la grille
			Mur.add(new Character[] {' ',' ',' ',' ',' ',' ',});
		}
		if (depassement(x,c) == true && stable(x,y,c) == true) {			//vérifie que le carreau ne dépasse pas du mur
			for(; y < colonne; y++) {										
				for(int k = x ; k < ligne; k++) {
					if (Mur.get(y)[k] == ' ') {								//vérifie que le carreau n'empiète pas sur un carreau déjà existant
						Mur.get(y)[k] = c.getlettre();						//ajout sur la grille la lettre du carreau 
					}
					else {
						arret++;
						break;
					}
				}
				if (arret == 1) {
					System.out.println("Vous ne pouvez pas poser le carreau ici");		//message d'erreur 
					System.out.println("Veuillez saisir de nouvelles coordonées :");
					regle++;
					break;
				}
			}		
		}
		else {
			System.out.println("Vous ne pouvez pas poser le carreau ici");				//message d'erreur
			System.out.println("Veuillez saisir de nouvelles coordonées :");
			regle++;
		}
	}		
	
	/*
	 * Affichage du mur
	 */
	
	public String toString() {
		StringBuilder m = new StringBuilder("");
		for(int i = Mur.size()-1;i >= 0; i--) { 
			if (i >= 9) 
				m.append("");
			else 
				m.append(" ");
			m.append(i+1);
			m.append(" ");
			for(int j = 0; j < largeur + 1; j++) {
				if(Mur.get(i)[j] != ' ') {
					m.append(Mur.get(i)[j]);
					m.append(" ");
				}	
				else
					m.append("  ");
			}
			m.append(System.lineSeparator());
		}
		m.append("  ");
		for(int k = 0; k < largeur; k++) {
			m.append(" ");
			m.append(k+1);
		}
		return m.toString();
	}
	
	/*
	 * Ajout de la pièce neutre
	 */
	
	public void ajoutPieceNeutre() {
		int n = (int)(Math.random() * 4);						//génère un chiffre entre 0-3
		switch (n) {
		case 0:
			Ajout(0, 0, new Carreau ('x',3,1,"rien"));			//ajoute à la grille la pièce en fonction du chiffre généré
			break;
		case 1:
			Ajout(0, 0, new Carreau ('x',1,3,"rien"));
			break;
		case 2:
			Ajout(2, 0, new Carreau ('x',3,1,"rien"));
			break;
		default:
			Ajout(4, 0, new Carreau ('x',1,3,"rien"));
			break;
		}
		System.out.println(this.toString());					//affiche le mur avec la pièce neutre
	}
	
	/*
	 * Vérifie la stabilité du carreau choisi
	 */
	
	public boolean stable(int x, int y, Carreau c) {
		boolean o = true;
		if (c.getlettre() != 'x' && y > 0) {
			int ligne = x + c.getlargeur(); 
			for(int k = x ; k < ligne; k++) {
				if (Mur.get(y-1)[k] == ' ')						//vérifie pour chaque case en dessous du carreau n'est pas vide 
					o = false;
			}
		}
		return o;
	}
	
	/*
	 * Vérifie que le carreau ne dépasse pas du mur
	 */
	
	public boolean depassement(int x, Carreau c) {
		return (x + c.getlargeur() <= largeur);
	}
	
	/*
	 * Vérifie que le carreau touche bien un autre carreau
	 */
	
	public boolean touche(int x, int y, Carreau c) {
		int cpt = 0;
		int ligne = x + c.getlargeur();
		int colonne = y + c.gethauteur();
		for(; y < colonne; y++) {
			for(int k = x ; k < ligne; k++) {
				if(Mur.get(y)[x-1] != ' ') 
					cpt++;
			}
				
		}
		return(cpt != 0);
		
	}
	public ArrayList<Character[]> getMur() {
		return Mur;
	}

	public int getlargeur() {
		return this.largeur;
	}
	
	public boolean vide() {
		return Mur.isEmpty();
	}
}
