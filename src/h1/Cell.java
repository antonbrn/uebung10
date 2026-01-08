package h1;

public class Cell {

	// Attribute

	private int indexRow = 0;
	private int indexCol = 0;
	private boolean alive = false;
	private int numLivingNeighbors = 0;
	private boolean isAliveNextGen = false;

	// Konstruktoren

	public Cell(int indexRow, int indexCol, boolean alive) {
		this.indexRow = indexRow;
		this.indexCol = indexCol;
		this.alive = alive;
	}

	public Cell(int indexRow, int indexCol) {
		this.indexRow = indexRow;
		this.indexCol = indexCol;
	}

	// Getter/Setter

	public int getIndexRow() {
		return indexRow;
	}

	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}

	public int getIndexCol() {
		return indexCol;
	}

	public void setIndexCol(int indexCol) {
		this.indexCol = indexCol;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getNumLivingNeighbors() {
		return numLivingNeighbors;
	}

	public void setNumLivingNeighbors(int numLivingNeighbors) {
		this.numLivingNeighbors = numLivingNeighbors;
	}

	public boolean isAliveNextGen() {
		return isAliveNextGen;
	}

	public void setAliveNextGen(boolean isAliveNextGen) {
		this.isAliveNextGen = isAliveNextGen;
	}

	// Methoden

	public void countLivingNeighbors(Cell[][] gridArray) {
		int zahl = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				int aktRow = indexRow + i;
				int aktCol = indexCol + j;
				if (aktRow >= 0 && aktCol >= 0 && aktRow < gridArray.length && aktCol < gridArray[0].length) {
					if (i != 0 || j != 0) {
						if (gridArray[aktRow][aktCol].alive == true) {
							zahl += 1;
						}
					}
				}
			}
		}
		numLivingNeighbors = zahl;
		decideNextStatus();
	}

	private void decideNextStatus() {
		if (alive == true) {
			if (numLivingNeighbors != 2 && numLivingNeighbors != 3) {
				isAliveNextGen = false;
			} else {
				isAliveNextGen = true;
			}
		} else {
			if (numLivingNeighbors == 3) {
				isAliveNextGen = true;
			} else {
				isAliveNextGen = false;
			}
		}
	}

}
