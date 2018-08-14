package battleship;

import java.util.Scanner;

public  class Main {
	

	public static void main(String[] args) {
		
		int rows;
		int columns;
		
		
		//Scanner implementation
		Scanner input = new Scanner(System.in);
		 
		System.out.println("Enter number of rows");
		rows = input.nextInt();
		
		System.out.println("Enter number of columns");
		columns = input.nextInt();
		
		//Creates a rows x columns size game.
		Battleship game = new Battleship(rows,columns);
		
		game.print();
		
		
	}

}
