// COMP SCI 2ME3 
// Assignment 1
// Paul Warnick (1300963)
// Navleen Signh ()
// Katrine Ratchitsky ()
// Hassaan Malik ()
// Trevor Rae ()

import java.awt.CardLayout; // jave imports for creating panels in a JFrame
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends Model{ // View class to create everything the user sees by using panels

	private CardLayout card_layout; // creates a new type CardLayout to determine how the panels are shown
	
	JPanel deck_panel = new JPanel(),  // main panel in which all other panels are displayed
			contentpane_panel = new JPanel(), // used for showing the current panel
			title_panel = new JPanel(), // panel that contains the title screen with start, help, exit, etc. buttons
			info_panel = new JPanel(),  // panel for instructions/help
			game_panel = new JPanel(),  // panel in which the actually connect four game is played
			end_panel = new JPanel(); // finish screen panel for once the game is over // TODO (Navleen, do we need this? Could we just display this via the game panel saying something like "You Won!" or w/e)
	
	void mainView (JFrame main_frame){ // main function to call all the panels in the correct order
		//View view_call = new View(); // TODO
		//Control control_call = new Control(); // TODO
		
		deck_panel.setLayout(card_layout = new CardLayout()); // sets the layout style of our window to Java's "Card Layout"
		contentpane_panel = (JPanel) main_frame.getContentPane(); // shows the first card (pane)
		titleScreen(); // call the title screen panel to display // TODO (is this temporary just for testing? or are we going to call the title screen then go from there)
		//control_call.mainControl(); // TODO
		card_layout.show (deck_panel,"Deck Panel"); // shows the first panel 
	}
	private void titleScreen (){ // panel for the title screen
		JButton exit = new JButton("Test"); // TODO
		title_panel.add(exit);
		//Control control_call = new Control();
		//control_call.mainControl();
		title_panel.setBackground(Color.red); // sets the background colour to red
		deck_panel.add(title_panel, "Title Panel"); // adds the panel to the deck of panels
	}
	private void infoScreen (){ // info panel
		info_panel.setBackground(Color.yellow); // colour is changed to yellow
		deck_panel.add(info_panel, "Info Panel"); // adds to deck of panels
	}
	private void gameScreen (){ // panel for the actual game
		game_panel.setBackground(Color.blue);
		deck_panel.add(game_panel, "Game Panel");
	}
	private void endScreen (){ // TODO see declaration
		end_panel.setBackground(Color.green);
		deck_panel.add(end_panel, "End Panel");
	}
	
}
