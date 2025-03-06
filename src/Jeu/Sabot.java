package Jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.*;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nombreOperations = 0;
	private int nombreCartes = 0;

	private class Iterateur implements Iterator<Carte> {

		private int indiceIterator = 0;
		private boolean nextEffectue = false;
		private int nombreOperationsReference = nombreOperations;

		public boolean hasNext() {
			return indiceIterator < nombreCartes;
		}

		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterator];
				indiceIterator++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}
		@Override
		public void remove() {
			verificationConcurrence();
			if (nombreCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterator - 1; i < nombreCartes - 1; i++) {
				cartes[i] = cartes[i + 1];
			}
			nextEffectue = false;
			indiceIterator--;
			nombreCartes--;
			nombreOperations++;
			nombreOperationsReference++;
		}

		private void verificationConcurrence() {
			if (nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}

	}

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
	}

	public boolean estVide() {
		return nombreCartes == 0;
	}

	public void ajouterCarte(Carte carte) {
		if (nombreCartes >= cartes.length) {
			throw new IllegalStateException();
		} else {
			cartes[nombreCartes] = carte;
			nombreCartes++;
			nombreOperations++;
		}
	}



	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	public Carte piocher() {
		Iterateur toto = new Iterateur();
		Carte carte;
		if(toto.hasNext()) {
			carte = toto.next();
			toto.remove();
			return carte;
		}else {
			throw new IllegalStateException();
		}
	}


}
