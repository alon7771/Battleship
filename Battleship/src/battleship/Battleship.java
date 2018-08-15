package battleship;

public class Battleship {

	int rows, columns;

	/**
	 * Construct rows x columns size game
	 * @param rows
	 * @param columns
	 * 
	 */
	public Battleship(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
	
	public void addShip(int row, int column){
		
		
		
	
	}
	
	/**
	 * Prints the board game
	 */
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
					System.out.print(" *");
			}
			System.out.println();
		}
		
	}
	
	

}
