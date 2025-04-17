package utils;
import cartes.*;
import java.util.Collections;
import jeu.*;
import tests_fonctionnnels.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GestionCartes {

	private <E> E extrairev1(List<E> liste) {
		Random randomNumbers = new Random();
		return liste.get(randomNumbers.nextInt(liste.size()));
	}
	
	private <E> List <E> melanger(List<E> liste) {
		List<E> newlist = new ArrayList<>();
		for(int i =0; i< liste.size(); i++) {
			newlist.add(extrairev1(liste));
		}
		return newlist;
	}
	
	private <E> boolean verifierMelange(List<E> liste, List<E> liste2) {
		boolean v = true;
		if(liste.size() == liste2.size()) {
			for(int i = 0; i< liste2.size(); i++) {
				v = v && ((Collections.frequency(liste2, liste2.get(i)) == Collections.frequency(liste, liste2.get(i))));
			}
		}
		return v;
	}
	
}
	private <E> List <E> rassembler(List<E> liste){
		List<E> newlist = new ArrayList<>();
		for(int i = 0 ; i < liste.size(); i++) {
			if(!newlist.contains(liste.get(i))) {
				for(int j = 0; j< Collections.frequency(liste, liste.get(i)); j++) {
					newlist.add(liste.get(i));
				}
			}
		}
		return newlist;
	}
	
	private <E> boolean verifierRassemblement(List<E> liste) {
		boolean v = true;
		if(!)
		
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
