// COMP SCI 2ME3 

// Assignment 1
// Navleen Signh (1302228)
// Paul Warnick (1300963)
// Katrine Rachitsky (1306314)
// Hassaan Malik (1224997)
// Trevor Rae ()

import java.awt.event.ActionEvent; // imports for user actions
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Control extends View implements ActionListener, MouseListener{ // the control class determines what happens when clicks a button in one of the JPanels

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start Game")){  // if start game is clicked, go to gamepanel
			card_layout.show(deck_panel, "GamePanel"); 
		}
		else if (e.getActionCommand().equals("Instructions")){ // if instructions is clicked, go to infopanel
			card_layout.show(deck_panel, "InfoPanel");
		}
		else if (e.getActionCommand().equals("Exit")){ 
			int exit = JOptionPane.showConfirmDialog(main_frame, "Are you sure you want to close?", "", 0); // checks to see if the user really wants to close the window
			if (exit == 0){ System.exit (0); }// if so the window closes
		}
		else if (e.getActionCommand().equals("Main Menu")){ 
			card_layout.show(deck_panel, "TitlePanel");
		}	
		else if (e.getActionCommand().equals("Resume Game")){

		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println(e.getX() + " " + e.getY());
		for (int x = 0; x <= 600;){ // runs through each column
			for (int y = 0; y <= 500;){ // runs through each row
				if (y == 0){ // if the click was in the first row
					if (x == 0){ // if the click was in the first column
						if (((e.getX() >= x) && (e.getX() <= (x + 100))) && ((e.getY() >= y) && (e.getY() <= (y + 96)))){ // 
							System.out.println(x/100 + " " + y/96);
						}
					}
					else{
						if (((e.getX() >= (x + 1)) && (e.getX() <= (x + 100))) && ((e.getY() >= (y)) && (e.getY() <= (y + 96)))){
							System.out.println(x/100 + " " + y/96);
						}
					}
				}
				else{
					if (x == 0){
						if (((e.getX() >= x) && (e.getX() <= (x + 100))) && ((e.getY() >= (y + 1)) && (e.getY() <= (y + 96)))){
							System.out.println(x/100 + " " + y/96);
						}
					}
					else{
						if (((e.getX() >= (x + 1)) && (e.getX() <= (x + 100))) && ((e.getY() >= (y + 1)) && (e.getY() <= (y + 96)))){
							System.out.println(x/100 + " " + y/96);
						}
					}
				}
				y += 96;
			}
			x += 100;
		}
	}	
}
