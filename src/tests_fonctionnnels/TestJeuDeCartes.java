package tests_fonctionnnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println("JEU:\n" + jeu.affichageDeCartes());
			
        if (!jeu.checkCount()) {
            System.out.println("erreur de nombre");
        }

	}		

	}
