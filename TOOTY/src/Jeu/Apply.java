package Jeu;
import java.util.Scanner;

public class Apply {
	
	public static void main(String[] args){
		Paquet p = new Paquet();
		Liste Carreaux = new Liste();
		Grille Mur = new Grille();
		Score Point = new Score(Carreaux,Mur);
		
		Mur.ajoutPieceNeutre();											//ajout de la pièce neutre
	
		for (int i = 0; i < p.getnbcarte(); i++) {						//continue tant que toute les cartes n'ont pas été tirée
			Scanner s = new Scanner (System.in);
			String arret = null;
			String suivant = null;
			p.tirer();													//tirage de la Carte 
			System.out.println("\n" + p.toString() + "\n"); 					//affiche la carte tirée 
			Carreaux.selectCarreau(p.toString()); 						//sélectionne les carreaux dispo corresponat à la carte tirée
			System.out.println(Carreaux.toString()); 					//affiche les carreaux séléctionée aupréalable
			
			if (Carreaux.isEmpty() != true) 	{						//vérifie qu'il éxiste encore des carreaux disponible 
				int ok = 0;
				while(ok == 0) {
					String mot = s.nextLine();							
					switch(mot) {
					
					case "stop":
						arret = "oui";									//si l'utilisateur rentre "stop" le programme s'arrête
						break;
						
						
					case "next":										//si l'utilisateur rentre "next" une nouvelle carte est piochée
						Point.ajoutCarte(p.toString());					//met la carte tirée dans un paquet à part
						System.out.println("\n" + Mur.toString());
						suivant ="oui";
						
						break;
						
						
					default :
						for(int j = 0; j < Carreaux.getArrayCarreaux().size(); j++) {
							if (mot.charAt(0) == Carreaux.getArrayCarreaux().get(j).getlettre()) {	//vérifie que le mot rentré correspond à un nom de carreau 
								Carreaux.choixCarreau(mot.charAt(0));
								System.out.println("Veuillez rentrer les coordonnées : ");
								do {
									Mur.regle = 0;
									int x = s.nextInt() - 1;										//demande les coordonées
									int	y = s.nextInt() - 1;
									Mur.Ajout(x,y,Carreaux.getcarreauChoisi());						//place le carreau dans la grille 
								} while(Mur.regle == 1);
								
								
								
								
								System.out.println("\n" + Mur.toString());							//affichage du mur avec le carreau posé
								ok++;
							}
							if (ok == 1)
								break;
						}
						if( ok == 0)
							System.out.println("Le carreaux n'est pas disponible");			
					}
					
					
					if (suivant == "oui")
						ok++;
					else if (arret == "oui")
						ok++;
				}
			}
			else
				System.out.println("Il n'y a plus de carreaux correspondant à la carte");
			if (arret == "oui")
				break;
		}
		System.out.println("La partie est finie");
		System.out.println(Point.toString());														//affichage du score
	}
}