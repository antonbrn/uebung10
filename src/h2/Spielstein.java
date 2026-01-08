package h2;

public class Spielstein {

	// Attribute

	private int currentRow = 0;
	private int currentCol = 0;
	private Spielbrett brett;

	// Konstruktor

	public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
		this.brett = brett;
		this.currentCol = indexCol;
		this.currentRow = indexRow;
	}

	// Getter/Setter

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getCurrentCol() {
		return currentCol;
	}

	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}

	public Spielbrett getBrett() {
		return brett;
	}

	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}

	// Weitere Methoden

	private boolean movesOut() {
		Feld[][] felder = brett.getBrett();
		if (currentCol == 0 && felder[currentRow][0].getDirection() == 'L') {
			return true;
		}
		if (currentCol == brett.getDim() - 1 && felder[currentRow][brett.getDim() - 1].getDirection() == 'R') {
			return true;
		}
		if (currentRow == 0 && felder[0][currentCol].getDirection() == 'U') {
			return true;
		}
		if (currentRow == brett.getDim() - 1 && felder[brett.getDim() - 1][currentCol].getDirection() == 'D') {
			return true;
		}
		return false;
	}

	public void go(int n) { 
		for (int i = 0; i < n; i++) {
			Feld aktFeld = brett.getBrett()[currentRow][currentCol];
			if (movesOut() == true || aktFeld.isBoese() == true) {
				break;
			}
			if (aktFeld.getDirection() == 'U') {
				currentRow -= 1;
			}
			else if (aktFeld.getDirection() == 'D') {
				currentRow += 1;
			}
			else if (aktFeld.getDirection() == 'L') {
				currentCol -= 1;
			}
			else if (aktFeld.getDirection() == 'R') {
				currentCol += 1;
			}
		}
	}

}
