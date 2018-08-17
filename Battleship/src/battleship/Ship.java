package battleship;

public class Ship {
	
	private int begin, end, lives, constant;
	private char type;


	public Ship(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
		
	}


	public Ship(int begin, int end,int constant,  char type) {
		super();
		this.begin = begin;
		this.end = end;
		this.constant = constant;
		this.lives =  end - begin;
		this.type = type;
	}


	public int getBegin() {
		return begin;
	}


	public int getEnd() {
		return end;
	}


	public int getSize() {
		return lives;
	}


	public char getType() {
		return type;
	}

		

}
