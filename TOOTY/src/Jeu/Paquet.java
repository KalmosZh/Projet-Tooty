package Jeu;
import java.util.ArrayList;
import java.util.Collections;
public class Paquet {
	private static final int nbCarte = 33;
	private ArrayList<String> paquet; 
	private String carteTiree;
	private static int cpt = 0;
	
	/*
	 * Création d'un paquet de carte 
	 */
	
	public Paquet() {
		paquet = new ArrayList<String>();
		for (int i = 0; i < 9; i++) 	
			paquet.add("ROUGE");				//ajout des différentes cartes dans le paquet
		for (int i = 0; i < 9; i++) 
			paquet.add("BLEU");
		for (int i = 0; i < 5; i++) 
			paquet.add("TAILLE 1");
		for (int i = 0; i < 5; i++) 
			paquet.add("TAILLE 2");
		for (int i = 0; i < 5; i++) 
			paquet.add("TAILLE 3");
		Collections.shuffle(paquet);			//mélange du paquet de carte crée
	}
	
	/*
	 * permet de tirer la première carte du paquet
	 */
	public void tirer() {
		carteTiree = this.paquet.get(cpt);
		cpt++;
	}
	
	/*
	 * affiche la carte tirée
	 */
	
	public String toString() {
		String s = this.carteTiree;
		return s.toString();
	}
	
	/*
	 * permet d'accéder au nombre de carte que contient le paquet
	 */
	
	public int getnbcarte() {
		return Paquet.nbCarte;
	}
	
	/*
	 * permet d'accéder à l'indice de la carte tirée
	 */
	
	public int getcpt() {
		return this.cpt;
	}
	/*
	 * vérifie que le paquet n'est pas vide
	 */
	
	public Boolean Vide() {
		return this.paquet.isEmpty();
	}
}