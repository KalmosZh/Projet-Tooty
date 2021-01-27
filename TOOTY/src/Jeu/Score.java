package Jeu;
import java.util.ArrayList;

public class Score {
	ArrayList<String> Carte;
	private Liste l;
	private Grille g;
	
	/*
	 * Création d'un nouveau score
	 */
	
	public Score(Liste l, Grille g) {
		Carte = new ArrayList<String>();
		this.g = g;
		this.l = l;
	}
	
	/*
	 * compte le nombre de ligne complète
	 */
	
	public int nbNiveauxComplet() {
		int cpt = 0;
		int valide = 0;
		for(int i = 0; i < this.g.getMur().size(); i++) {
			for(int j = 0; j <= this.g.getlargeur(); j++) {
				if (this.g.getMur().get(i)[j] != ' ') {			//pour chaque case de chaque ligne vérifie si elle est vide
					cpt++;
				}
			}
			if (cpt == 5) {
				valide++;
			}
			cpt = 0;
		}
		return valide;											//retourne le nombre de ligne pleine
	}
	/*
	 * ajout dans une liste les cartes écartées
	 */
	
	public void ajoutCarte(String s) {
		Carte.add(s);											//ajout dans une liste les cartes écartées
	}
	
	/*
	 * affichage du score dans une order précis
	 */
	
	public String toString() {
		int point = nbNiveauxComplet() * 5 - Carte.size() - l.getTailleListe();		
		String s;
		s = point + " points" + " (" + nbNiveauxComplet() + " niveaux complets, " + l.getTailleListe() + " carreaux non posés, " + Carte.size() + " cartes écartées)";
		return s.toString();
	}
	
}
