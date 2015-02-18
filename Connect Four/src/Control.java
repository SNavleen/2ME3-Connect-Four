// COMP SCI 2ME3 
// Assignment 1
// Navleen Signh (1302228)
// Paul Warnick (1300963)
// Katrine Ratchitsky ()
// Hassaan Malik ()
// Trevor Rae ()

import java.awt.event.ActionEvent; // imports for user actions
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Control extends View implements ActionListener{ // the control class determines what happens when clicks a button in one of the JPanels
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start Game")){ 
			card_layout.show(deck_panel, "GamePanel"); } // TODO
		else if (e.getActionCommand().equals("Instructions")){
			card_layout.show(deck_panel, "InfoPanel");
			}
		else if (e.getActionCommand().equals("Exit")){ System.exit(0); }
		else if (e.getActionCommand().equals("Back to Main Menu")){ 
		}
		
	}
	
}
