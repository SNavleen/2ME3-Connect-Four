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

/*	JButton info_button, play_button, exit_button; // creating JButtons
	
	void mainControl(){	
		titleButtons();
	}
	
	void titleButtons(){
		exit_button = new JButton("Exit");
		exit_button.addActionListener(this);
		//exit_button.setLocation(50, 50);
		
		
		info_button = new JButton("Information");
		play_button = new JButton("Play");
		
		title_panel.add(exit_button);
		//title_panel.validate();
	}*/
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start Game")){  } // TODO
		if (e.getActionCommand().equals("Instructions")){ 
			//card_layout.show (info_panel,"Info Panel");
			}
		if (e.getActionCommand().equals("Exit")){ System.exit(0); }
		if (e.getActionCommand().equals("Back to Main Menu")){ 
			//titleScreen();
			//card_layout.show (deck_panel,"Deck Panel");
		}
		
	}
	
}
