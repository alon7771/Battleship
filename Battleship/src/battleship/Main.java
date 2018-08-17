package battleship;

import java.util.Scanner;

public  class Main {


	public static void main(String[] args) {

		int rows, columns, numOfShips;
		Battleship player1, player2;

		//Scanner implementation
		Scanner input = new Scanner(System.in);

		/*
		 * TODO: 
		 * 
		 * 3. Guess a ship location.
		 * 4. Check if hit or missed.
		 * 5. Update and respond.
		 */

		try {
			System.out.println("Enter number of rows");
			rows = input.nextInt();

			System.out.println("Enter number of columns");
			columns = input.nextInt();

			System.out.println("Enter number of ships");
			numOfShips = input.nextInt();

			//Creates a rows x columns size game.
			player1 = new Battleship(rows, columns, numOfShips);
			player2 = new Battleship(rows, columns, numOfShips);

			System.out.println("Player 1 - locate your ships");
			while(player1.shipLeft()){
				
				addShip(player1, input);
			}
			
			System.out.println("Player 1 located all ships");
			player1.print();
			System.out.println("Player 2 - locate your ships");
			while(player2.shipLeft()){
				
				addShip(player2, input);
			}
			
			System.out.println("Player 2 located all ships");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	private static void addShip(Battleship player1, Scanner input) throws Exception {
		
		char type;
		System.out.println("Enter type of ships - H for horizontal or V for vertical");
		type = input.next().charAt(0) ;

		int begin, end, constant;
		switch (type) {
		
		case 'H':

			System.out.print("Enter row");
			constant = (int)input.next().charAt(0);

			System.out.print("Enter first column");
			begin = input.nextInt();

			System.out.print("Enter last column");
			end = input.nextInt();

			player1.addShip(begin, end, constant - 64, type);

			break;

		case 'V': 

			System.out.print("Enter column");
			constant = input.nextInt();

			System.out.print("Enter first row");
			begin = (int)input.next().charAt(0);

			System.out.print("Enter last row");
			end = (int)input.next().charAt(0);

			player1.addShip(begin - 65, end - 65, constant, type);

			break;

		default:
			System.out.println("Please enter a valid type");
			break;
		}

	}

}
