package battleship;

public class Ship {
	
	int begin, end, lives, permanent;
	String type;


	public Ship(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
		
	}


	public Ship(int begin, int end,int permanent,  String type) {
		super();
		this.begin = begin;
		this.end = end;
		this.permanent = permanent;
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


	public String getType() {
		return type;
	}

		

}
