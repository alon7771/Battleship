package battleship;

public class Battleship {

	int rows, columns, shipCounter;
	
	int[][] hits;
	Ship[] ships;
	

	public Battleship(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		hits = new int[rows][columns];		
		
	}
	
	public Battleship(int rows, int columns, int numofShips) {
		this.rows = rows;
		this.columns = columns;
		shipCounter = 1;
		ships = new Ship[numofShips];
		hits = new int[rows][columns];		
	}

	/**
	 * Add a ship to the game
	 * 
	 * @param begin - The first index of the ship
	 * @param end - The last index of the ship
	 * @param permanent - The row if the ship is horizontal or the column if the ship is vertical
	 * @param type - Horizontal(H) or Vertical(V)
	 * @throws Exception 
	 */
	public void addShip(int begin, int end,int permanent, String type) throws Exception{
		
		//Checks that you have ships
		if(shipCounter >ships.length)
			throw new Exception("You loacated all your ships");
		
	
		
		//Add the ship to the game board
		switch (type) {
		case "H":
			for (int i = begin - 1 ; i < end; i++) {
				thereIsNoShipInIndexes(permanent - 1, i);
			}
			
			for (int i = begin - 1 ; i < end; i++) {
				updateBoard(permanent - 1, i);
			}
			break;

		case "V":
			for (int i = begin - 1 ; i < end; i++) {
				thereIsNoShipInIndexes(i, permanent - 1);
			}
			for (int i = begin - 1 ; i < end; i++) {
				updateBoard(i, permanent - 1);
			}
			break;
			
		default:
			throw new Exception("Please enter a valid type");
		}
		
		//Construct the ship and add it to the ships list
		ships[shipCounter++ - 1] = new Ship(begin, end,permanent, type);
		
	}
	
	
	
	private void thereIsNoShipInIndexes(int row, int column) throws Exception {
		if(hits[row][column] != 0)
			throw new Exception("The indexes intersect with an existing ship");
	}

	/*
	 * Updates the board.
	 */
	private void updateBoard(int row, int column) {

		hits[row][column] = shipCounter;
	}

	public void print(){
		for (int i = 0; i <= columns; i++) {
			if(i != 0)
				System.out.print(" " + i);
			else
				System.out.print(" ");
		}
		System.out.println();

		for (int i = 0; i < rows; i++) {
				System.out.print(Character.toChars(65 + i));
			for (int j = 0; j < columns; j++) {
					System.out.print(" " + hits[i][j]);
			}
			System.out.println();
		}
		
		
	}
	
	
	/**
	 * Prints the board game
	 */
	public void printCleanBoard(){
		
		for (int i = 0; i <= columns; i++) {
			if(i != 0)
				System.out.print(" " + i);
			else
				System.out.print(" ");
		}
		
		System.out.println();

		for (int i = 0; i < rows; i++) {
				System.out.print(Character.toChars(65 + i));
			for (int j = 0; j < columns; j++) {
					System.out.print(" *");
			}
			System.out.println();
		}
		
	}
	
	

}
