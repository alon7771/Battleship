package battleship;

import java.util.Scanner;

public  class Main {
	

	public static void main(String[] args) {
		
		int rows;
		int columns;
		
		
		//Scanner implementation
		Scanner input = new Scanner(System.in);
		 
//		System.out.println("Enter number of rows");
//		rows = input.nextInt();
//		
//		System.out.println("Enter number of columns");
//		columns = input.nextInt();
		
		//Creates a rows x columns size game.
		Battleship game = new Battleship(5,5,5);
//		Battleship game = new Battleship(rows,columns);
		/*
		 * TODO: 
		 * 2. Add ships.
		 * 3. Guess a ship location.
		 * 4. Check if hit or missed.
		 * 5. Update and respond.
		 */
		
		try {
			game.addShip(2, 4, 2, "H");
			game.addShip(2, 3, 1, "V");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game.print();
		
		
	}

}
