package utils;
import cartes.*;
import jeu.*;
import tests_fonctionnnels.*;

import java.util.List;
import java.util.Random;


public class GestionCartes {

	private <E> E extrairev1(List<E> liste) {
		Random randomNumbers = new Random();
		return liste.get(randomNumbers.nextInt(liste.size()));
		
	}
}
