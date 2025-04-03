package cartes;

public abstract class Limite extends Carte {

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Limite) { 
			Limite limite = (Limite) obj;
			return (this.toString()).equals(limite.toString());
		}
		return false;
	}
}
