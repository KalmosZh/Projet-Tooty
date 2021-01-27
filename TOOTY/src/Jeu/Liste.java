package Jeu;
import java.util.ArrayList;
import java.util.Scanner;

public class Liste {
	private static final int nb_Carreaux = 18;
	private ArrayList<Carreau> Carreaux, c;
	private Carreau carreauChoisi;

	/*
	 * Création d'une liste contenant l'ensemble des carreaux
	 */
	
	public Liste() {
		
		Carreaux = new ArrayList<Carreau>();
		Carreaux.add(new Carreau('a',1,1,"BLEU"));		//ajout des différents carreaux dans la liste
		Carreaux.add(new Carreau('b',1,2,"BLEU"));
		Carreaux.add(new Carreau('c',2,1,"BLEU"));
		Carreaux.add(new Carreau('d',2,2,"BLEU"));
		Carreaux.add(new Carreau('e',1,3,"BLEU"));
		Carreaux.add(new Carreau('f',3,1,"BLEU"));
		Carreaux.add(new Carreau('g',2,3,"BLEU"));
		Carreaux.add(new Carreau('h',3,2,"BLEU"));
		Carreaux.add(new Carreau('i',3,3,"BLEU"));
		
		Carreaux.add(new Carreau('A',1,1,"ROUGE"));
		Carreaux.add(new Carreau('B',1,2,"ROUGE"));
		Carreaux.add(new Carreau('C',2,1,"ROUGE"));
		Carreaux.add(new Carreau('D',2,2,"ROUGE"));
		Carreaux.add(new Carreau('E',1,3,"ROUGE"));
		Carreaux.add(new Carreau('F',3,1,"ROUGE"));
		Carreaux.add(new Carreau('G',2,3,"ROUGE"));
		Carreaux.add(new Carreau('H',3,2,"ROUGE"));
		Carreaux.add(new Carreau('I',3,3,"ROUGE"));
	}
	
	/*
	 * Création d'une liste qui va correspondre 
	 */
	
	public Liste(Carreau c) {
		this.carreauChoisi = c;
	}
	
	/*
	 * création d'une liste correspondant à tous les carreaux correspondant à la carte piochée
	 */
	
	public void selectCarreau(String s) {
		c = new ArrayList<Carreau>();
		for (int i = 0; i < Carreaux.size(); i++) {
			if(s == "TAILLE 1") {
				if(Carreaux.get(i).gethauteur() == 1 || Carreaux.get(i).getlargeur() == 1)	//ajout dans la liste des carreaux 
				c.add(Carreaux.get(i));
			}
			else if(s == "TAILLE 2") {
				if(Carreaux.get(i).gethauteur() == 2 || Carreaux.get(i).getlargeur() == 2)
				c.add(Carreaux.get(i));
			}
			else if(s == "TAILLE 3") {
				if(Carreaux.get(i).gethauteur() == 3 || Carreaux.get(i).getlargeur() == 3)
				c.add(Carreaux.get(i));
			}
			else if(s == "ROUGE") {
				if(Carreaux.get(i).getcouleur() == "ROUGE")
				c.add(Carreaux.get(i));
			}
			else if (s == "BLEU") {
				if(Carreaux.get(i).getcouleur() == "BLEU")
				c.add(Carreaux.get(i));
			}
		}

	}
	
	/*
	 * affichage en ligne des carreaux disponible correspondant à la carte tirée
	 */
	
	public String toString() {
		StringBuilder s = new StringBuilder("");
		for (int h = 3; h > 0; h--) {
			for (int i = 0; i < c.size(); i++) {
				if (c.get(i).gethauteur() >= h) {
					for (int largeur = 0; largeur < c.get(i).getlargeur(); largeur ++) {
						s.append(c.get(i).getlettre());
						s.append(" ");
					}
				}
				else {
					for (int largeur = 0; largeur < c.get(i).getlargeur(); largeur ++)
						s.append("  ");
				}
				s.append(" ");
			}
			s.append(System.lineSeparator());
		}
		return s.toString();
	}
	
	/*
	 * Choisi un des carreaux présents dans la liste des carreaux disponible
	 */
	
	public void choixCarreau(char lettre) {
		for(int j = 0; j < Carreaux.size(); j++) {
			if(lettre == Carreaux.get(j).getlettre()) {
				this.carreauChoisi = Carreaux.get(j);
				Carreaux.remove(j);							//retire le carreau de la liste initiale
			}
		}
	}
	
	
	/*
	 * permet d'accéder au carreau choisi
	 */

	public Carreau getcarreauChoisi(){
		return this.carreauChoisi;
	}
	
	/*
	 * Vérifie qu'il y a encore des carreaux disponible
	 */
	
	public Boolean isEmpty() {
		return c.isEmpty();
	}
	/*
	 * permet d'accéder au nombre de carreaux
	 */
	
	public int getnb_Carreaux() {
		return this.nb_Carreaux;
	}
	
	/*
	 * permet d'accéder à la liste des carreaux disponible
	 */
	
	public ArrayList<Carreau> getArrayCarreaux() {
		return this.c;
	}
	
	public int getTailleListe() {
		return this.Carreaux.size();
	}
	
	public boolean DispoVide() {
		return c.isEmpty();
	}
	
	public boolean ListeVide() {
		return Carreaux.isEmpty();
	}
}

	


	