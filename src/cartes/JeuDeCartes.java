package cartes;

public class JeuDeCartes {

	private Configuration[] typesDeCartes = { new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12), new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14), new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.ESSENCE), 6), new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6), new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new DebutLimite(), 4), new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Botte(Type.FEU), 1), new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ACCIDENT), 1),

	};

	private static class Configuration {
		private int nbExemplaires;
		private Carte carte;

		private Configuration(Carte carte, int nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;

		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCartes() {
			return carte;
		}
	}

	public String affichageDeCartes() {
		StringBuilder sb = new StringBuilder();
		sb.append("Jeu:\n");
		for (Configuration configuration : typesDeCartes) {
			sb.append(configuration.getNbExemplaires() + " " + configuration.getCartes() + "\n");
		}
		return sb.toString();
	}
	
	public Carte[] donnerCartes() {
		Carte[] jeu = new Carte[106];
		int jorys = 0;
		for (int i = 0; i<19; i++) {
			for(int j = 0; j< typesDeCartes[i].getNbExemplaires(); j++) {
				jeu[jorys] = typesDeCartes[i].getCartes();
				jorys++;
			}
		}
		
		return jeu;
		
		
	}
	
	public boolean checkCount() {
		Carte[] cartes = new Carte[106];
		cartes = this.donnerCartes();
		for (int i = 0; i< cartes.length; i++ ) {
			for(int j = 0; i<typesDeCartes[i].getNbExemplaires();j++) {
				if(typesDeCartes[i].getCartes() != cartes[i])
					return false;
			}
		}
		return true;
		
	}
}
