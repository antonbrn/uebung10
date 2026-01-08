package h1;

public class Grid {

	// Attribute

	private Cell[][] gridArray;

	// Konstruktor

	public Grid(Cell[] cells, int gridRows, int gridCols) {
		gridArray = new Cell[gridRows][gridCols];
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[0].length; j++) {
				Cell neu = new Cell(i, j, false);
				gridArray[i][j] = neu;
			}
		}

		for (int i = 0; i < cells.length; i++) {
			int aktRow = cells[i].getIndexRow();
			int aktCol = cells[i].getIndexCol();
			if (aktRow < gridRows && aktCol < gridCols && aktRow >= 0 && aktCol >= 0) {
				gridArray[aktRow][aktCol].setAlive(true);
			}
		}
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[0].length; j++) {
				gridArray[i][j].countLivingNeighbors(this.gridArray);
			}
		}
	}

	// Getter/Setter

	public Cell[][] getGridArray() {
		return gridArray;
	}

	public void setGridArray(Cell[][] gridArray) {
		this.gridArray = gridArray;
	}

	// Weitere Methoden

	public void computeNextGen() {
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[0].length; j++) {
				gridArray[i][j].setAlive(gridArray[i][j].isAliveNextGen());
			}
		}
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[0].length; j++) {
				gridArray[i][j].countLivingNeighbors(this.gridArray);
			}
		}
	}

	public void computeGeneration(int n) {
		for (int i = 0; i < n; i++) {
			computeNextGen();
		}
	}

}
