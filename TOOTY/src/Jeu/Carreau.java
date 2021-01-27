package Jeu;


public class Carreau {
	protected char lettre;
	protected int largeur;
	protected int hauteur;
	protected String couleur;
	
	/*
	 * Création d'un carreau 
	 */
	
	public Carreau(char lettre,int largeur, int hauteur, String couleur) {
		this.lettre = lettre;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleur = couleur;
	}
	
	/*
	 * affiche le nom d'un carreau
	 */
	
	public String toString() {
		String s = getlettre() + "";
		return s.toString();
	}
	
	/*
	 * permet d'accéder à la largeur du carreau
	 */
	
	public int getlargeur() {
		return this.largeur;
	}
	
	/*
	 * permet d'accéder à la hauteur du carreau
	 */
	
	public int gethauteur() {
		return this.hauteur;
	}
	
	/*
	 * permet d'accéder à la couleur du carreau
	 */
	
	public String getcouleur() {
		return this.couleur;
	}
	
	/*
	 * permet d'accéder à la lettre du carreau
	 */
	
	public char getlettre() {
		return this.lettre;
	}
}
