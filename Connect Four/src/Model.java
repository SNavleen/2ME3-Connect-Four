// COMP SCI 2ME3 

// Assignment 1
// Navleen Signh (1302228)
// Paul Warnick (1300963)
// Katrine Rachitsky (1306314)
// Hassaan Malik (1224997)
// Trevor Rae ()

import java.awt.CardLayout;
import java.awt.Dimension; // imports for creating a JFrame
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Model extends Disk { // Model class that sets up the JFrame as a window to play connect four in
	
	private Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize (); // used for finding the dimensions of the users screen
	
	static CardLayout card_layout  = new CardLayout(); // creates a new type CardLayout to determine how the panels are shown
	static JPanel deck_panel = new JPanel();//,  // main panel in which all other panels are displayed
	
	final static JFrame main_frame = new JFrame("Connect Four"); // makes a new JFrame type named "Connect Four" (This will be the name of the window)
	
	private int screen_width = screen.width, screen_height = screen.height; // creates ints for the width and the height

	private void createFrame (JFrame main_frame){ // method to create the actual window with the specified dimensions
		main_frame.setResizable(false); // disables the ability to maximize or change the dimensions of the window
		main_frame.setLocation((screen_width/2) - (900/2), (screen_height/2) - (600/2)); // sets the location to 1/4 the width of the screen and 1/6 the height to center the window
		main_frame.setSize (900 , 600); // sets the size of the window
	}
	
	public static void main(String [] args) throws IOException{ // calls all methods to create the JFrame

		Model model_call = new Model(); // allows model to be called in main (static function) without being static
		View view_call = new View(); // same as above 

		model_call.createFrame(main_frame); // creates a JFrame of the dimensions specified in createFrame
		
		deck_panel.setLayout(card_layout); // sets the layout style of our window to Java's "Card Layout"

		view_call.gameScreen();
		view_call.infoScreen();
		view_call.titleScreen(); // call the title screen panel to display 
		
		card_layout.show (deck_panel,"TitlePanel"); // shows the first panel 
		
		main_frame.add(deck_panel);
		
		main_frame.setVisible(true); // shows the screen to the user		
		main_frame.addWindowListener(new WindowAdapter(){ // checks to see if the window controls (top right) are clicked
			public void windowClosing (WindowEvent WE){  // checks if the "X" button is pressed
				System.exit (0);// if so the window closes
		      }
			});		
	}
}
