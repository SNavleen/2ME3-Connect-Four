// COMP SCI 2ME3 
// Assignment 1
// Paul Warnick (1300963)
// Navleen Signh ()
// Katrine Ratchitsky ()
// Hassaan Malik ()
// Trevor Rae ()

import java.awt.Dimension; // imports for creating a JFrame
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Model extends Disk { // Model class that sets up the JFrame as a window to play connect four in
	
	private Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize (); // used for finding the dimensions of the users screen
	
	private int screen_width = screen.width, screen_height = screen.height; // creates ints for the width and the height
	//int [][] coordinates = new int [7][6];

	private void createFrame (JFrame main_frame){ // method to create the actual window with the specified dimensions
		main_frame.setResizable(false); // disables the ability to maximize or change the dimensions of the window
		main_frame.setLocation(screen_width/4, screen_height/6); // sets the location to 1/4 the width of the screen and 1/6 the height to center the window
		main_frame.setSize (800 , 700); // sets the size of the window
	}
	
	public static void main(String [] args){ // calls all methods to create the JFrame
		JFrame main_frame = new JFrame("Connect Four"); // makes a new JFrame type named "Connect Four" (This will be the name of the window)
		
		Model model_call = new Model(); // allows model to be called in main (static function) without being static
		View view_call = new View(); // same as above 
		//Control control_call = new Control(); // same

		model_call.createFrame(main_frame); // creates a JFrame of the dimensions specified in createFrame
		view_call.mainView(main_frame);	// TODO
		
		view_call.contentpane_panel.add(view_call.deck_panel); // TODO
		
		main_frame.setVisible(true); // shows the screen to the user		
		main_frame.addWindowListener(new WindowAdapter(){ // checks to see if the window controls (top right) are clicked
			public void windowClosing (WindowEvent WE){  // checks if the "X" button is pressed
		        System.exit (0); // if so the window closes
		      }
			});		
	}
}
