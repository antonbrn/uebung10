package h2;

public class Feld {

	// Attribute

	private boolean boese = false;
	private char direction;

	// Konstruktor

	public Feld(boolean boese, char direction) {
		this.boese = boese;
		this.direction = direction;
	}

	// Getter/Setter

	public boolean isBoese() {
		return boese;
	}

	public void setBoese(boolean boese) {
		this.boese = boese;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

}
