package h2;

public class Spielbrett {

	// Attribute

	private Feld[][] brett;
	int dim = 0;

	// Konstruktor
 
	public Spielbrett(int dim) {
		this.dim = dim;
		this.brett = new Feld[dim][dim];
	}

	// Getter/Setter

	public Feld[][] getBrett() {
		return brett;
	}

	public void setBrett(Feld[][] brett) {
		this.brett = brett;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}

}
