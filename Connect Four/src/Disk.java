// COMP SCI 2ME3 

// Assignment 1
// Hassaan Malik (1224997)
// Katrine Rachitsky (1306314)
// Trevor Rae (1324949)
// Navleen Signh (1302228)
// Paul Warnick (1300963)

public class Disk { // ADT for each disk in the connect four board
	
	static int x; // x coordinate
	static int y; // y coordinate

	public Disk (){ } // default constructor if no arguments are entered // TODO do we need this? wouldn't it just error if no args are entered?
	
	public Disk(int x, int y){ // constructor using given arguments
		this.x = x;
		this.y = y;
	}
	public void setX (int x){ // sets the value of x // TODO we may not need this because pieces cannot move left or right only down
		this.x = x;
	}
	public void setY (int y){ // sets the value of y
		this.y = y;
	}
	public static int getX (){ // returns the x coordinate
		return (x);
	}
	public static int getY (){ // returns the y coordinate
		return (y);
	}
	
}
