package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		Type type = getType();
		return type.getParade() ;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Parade) {
			return true;
		}
		return false;
	}
	

}
