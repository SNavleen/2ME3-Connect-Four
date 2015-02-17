// COMP SCI 2ME3 
// Assignment 1
// Navleen Signh (1302228)
// Paul Warnick (1300963)
// Katrine Ratchitsky ()
// Hassaan Malik ()
// Trevor Rae ()

public class Disk { // ADT for each disk in the connect four board
	
	private int x; // x coordinate
	private int y; // y coordinate

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
	public int getX (){ // returns the x coordinate
		return (x);
	}
	public int getY (){ // returns the y coordinate
		return (y);
	}
	
}
