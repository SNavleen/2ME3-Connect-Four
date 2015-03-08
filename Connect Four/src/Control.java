// COMP SCI 2ME3 

// Assignment 1
// Hassaan Malik (1224997)
// Katrine Rachitsky (1306314)
// Trevor Rae (1324949)
// Navleen Signh (1302228)
// Paul Warnick (1300963)

import java.awt.Color;  // imports for user actions and JFrame components
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;

import javax.jws.WebParam.Mode;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Control extends View{ // a class to determines what happens when the user clicks a button in one of the JPanels and also anything the user can do / edit during the run
	
	private static Random rand = new Random (); // a random used for determining who moves first
	private static int mouseClick = rand.nextInt(2), coordinates [][] = new int [7][6], bluecount = 0, redcount = 0; // ints throughout the program, mouseclick is for which player moves first, coordinates is the where the user clicks in a grid format and the counts determine how many moves each player has done
	private String player1, player2; // strings for the player names
	@SuppressWarnings("unused") // TODO temp to avoid warnings
	private String winner; // string for the name of the player that wins TODO will be implemented fully in assignment 2
	private boolean wrongFormat = false; // used to see if the users names are in the correct format
	
	private void blueDisk(int x, int y, JPanel panel) throws IOException{ // method for placing a blue disk
		final ImageIcon blueimage = new ImageIcon(getClass().getResource("/Bluedisk.png")); // loads in the image
		JLabel blueDisk = new JLabel(blueimage); // creates a label with the above image
		blueDisk.setBounds(102+(x), 2+(y), 93, 93); // sets the location based on the arguements (which come from the players click)
		panel.add(blueDisk); // adds the disk to the panel
		
		if (Model.dev_mode == false){ // below if statments determine if the user is in dev mode or not
			card_layout.show(deck_panel, "GamePanel"); // shows on the actual game board
		}
		
		else{
			card_layout.show(deck_panel, "DeveloperPanel"); // shows on the dev mode board
		}
		
		Control.coordinates[x/99][y/95] = 1; // updates the coordinates 1 at the appropriate place to show that a disk is in that position
		main_frame.repaint(); // repaints the mainframe to update the board
		main_frame.validate(); // insure that the frame has repainted correctly
	}
	
	private void redDisk(int x, int y, JPanel panel) throws IOException{ //  same as the above method but for the red disk
		final ImageIcon redimage = new ImageIcon(getClass().getResource("/Reddisk.png"));
		JLabel redDisk = new JLabel(redimage);
		redDisk.setBounds(102+(x), 2+(y), 93, 93);
		panel.add(redDisk);	
		
		if (Control.dev_mode == false){
			card_layout.show(deck_panel, "GamePanel");
		}
		
		else{
			card_layout.show(deck_panel, "DeveloperPanel");
		}
		
		Control.coordinates[x/99][y/95] = -1;
		main_frame.repaint();
		main_frame.validate();
	}
	
	private void playerNameSet(JPanel panel){ // method for setting the names of the players before the game starts
		
		JLabel p1 = new JLabel(); // label for player 1
		JLabel p2 = new JLabel(); // player 2
		
		p1.setFont(new Font("Calibri", Font.ITALIC, 25)); // sets the font and size of the labels 
		p2.setFont(new Font("Calibri", Font.ITALIC, 25));
		
		player1 = JOptionPane.showInputDialog("Please enter Player 1's name: "); // pop up window that takes player 1's name
		player2 = JOptionPane.showInputDialog("Please enter Player 2's name: "); //  same for player 2
		Model.player1name = player1;
		Model.player2name = player2;
		p1.setText(player1); // sets the labels text to the text recieved above
		p2.setText(player2); // same for p2
		
		if ((p1.getText().equals(p2.getText())) || (p1.getText().length() < 1) || (p2.getText().length() < 1) || (p1.getText() == " ") || (p2.getText() == " ")){ // simple error check to see if the user inputed a proper name. doesn't check all cases
			JOptionPane.showMessageDialog(main_frame,
				    "The players name is not in the correct format!",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE); // gives an error pop up to tell the user the name was inputed incorrectly
			wrongFormat = true; // if this is true, the program will go back to the title screen
		}

		p1.setBounds(3, 110, 93, 40); // sets the location of the name label
		p1.setHorizontalAlignment(SwingConstants.CENTER); // centers the text
		p2.setBounds(798, 110, 93, 40);
		p2.setHorizontalAlignment(SwingConstants.CENTER);
		p2.setForeground(Color.red); // changes the colour
		p1.setForeground(Color.blue);
		
		panel.add(p1); // adds to the game panel
		panel.add(p2);	
		
		card_layout.show(deck_panel, "GamePanel"); // adds the panel to the deck
		main_frame.repaint(); // repaints to show change
		main_frame.validate(); // checks if properly repainted
	}
	
	private boolean pieceAir (){ // method to check if a piece has been place floating in dev mode
		for (int x = 0; x < 7; x++){ // runs through every position
			for (int y = 0; y < 5; y++){ // except the bottom row 
				if (Control.coordinates[x][y] == 1 || Control.coordinates[x][y] == -1){ //checks if a piece has been placed there
					if ( Control.coordinates[x][y+1] == 0){ // if there is no piece below that piece
						return true; // the method return true
					}
				}
			}
		}
		return false; // other wise no pieces are floating and method returns false
	}
	
	private boolean win (){ // TODO for Assignment 2
		/* This method will be used to check if a player has won the game. It will be implemented in assignment 2, the reason we left it in the code is because we had it working but with a few bugs, and because it's not a requirement for Assignment 1
		 * we ended up just deleting the actual win check part. The method is called throughout our code but doesn't actually do anything at the moment so instead of deleteing all the method calls we just left them as is and kept this method
		*/
		
		int x_counter = 0,
			y_counter = 0;
		
		while(x_counter != 7){
			while(y_counter != 6){
				int total_pieces = 0,
					piece = Control.coordinates[x_counter][y_counter];
				if (piece == 1 || piece == -1){
					if (x_counter <= 3){
						for(int i = 0; i < 4; i++){
							if(piece == Control.coordinates[x_counter+i][y_counter]) total_pieces++;
							else break;
						}
					}
					if (total_pieces == 4) {
						return true;
					}
					total_pieces = 0;
					if (y_counter <= 2){
						for(int i = 0; i < 4; i++){
							if(piece == Control.coordinates[x_counter][y_counter+i])total_pieces++;
							else break;
						}
					}
					if (total_pieces == 4) {
						return true;
					}
					total_pieces = 0;
					if (y_counter <= 2 && x_counter >= 3){
						for(int i = 0; i < 4; i++){
							if(piece == Control.coordinates[x_counter-i][y_counter+i])total_pieces++;
							else break;
						}
					}
					if (total_pieces == 4) {
						return true;
					}
					total_pieces = 0;
					if (y_counter <= 2 && x_counter <= 3){
						for(int i = 0; i < 4; i++){
							if(piece == Control.coordinates[x_counter+i][y_counter+i])total_pieces++;
							else break;
						}
					}
				}
				if (total_pieces == 4) {
					return true;
				}
				y_counter++;
			}
			y_counter = 0;
			x_counter++;
		}
		return false;
	}
	
	void buttonFunction(ActionEvent e, JPanel panel, boolean dev_mode) throws IOException{ // the method determines the actions of each click on each button throughout the code
		if (e.getActionCommand().equals("Instructions")){ // if instructions is clicked on the title screen, go to infopanel
			infoScreen();
			card_layout.show(deck_panel, "InfoPanel");
		}
		else if (e.getActionCommand().equals("Exit")){ // if exit is clicked throughout the program, ask the user first, then close
			int exit = JOptionPane.showConfirmDialog(main_frame, "Are you sure you want to close?", "", 0); // checks to see if the user really wants to close the window
			if (exit == 0){ System.exit (0); }// if so the window closes
		}
		else if (e.getActionCommand().equals("Main Menu")){ // if user want to return to the main menu
			card_layout.show(deck_panel, "TitlePanel");
		}	
		else if (e.getActionCommand().equals("Resume Game") ){ // resume game button on the info panel to return the player to the current game
			card_layout.show(deck_panel, "GamePanel"); 
		}
		else if (e.getActionCommand().equals("Start Game")|| // if the user wants to play a standard game with dev mode
				 e.getActionCommand().equals("New Game") ||
				 e.getActionCommand().equals("Resume Game")){
				gameScreen(); // calls the game
				panel = game_panel;
				playerNameSet(panel); // asks player for there names

				if (wrongFormat == false){ // checks if the formatting of the name is correct
					for (int ix = 0; ix < 7; ix++){ // if so the board is set up
						for (int iy = 0; iy < 6; iy++){
							check_disk[ix][iy] = false;
							Control.coordinates[ix][iy] = 0;
						}
					}
					card_layout.show(deck_panel, "GamePanel"); // shows the game panel
					
					if (mouseClick % 2 == 0){ // determines which player is going to move first
						JOptionPane.showMessageDialog(main_frame,
								"Random selection has chosen " + player1 + " to move first. After this the turns will alternate.",
								"First Move",
								JOptionPane.WARNING_MESSAGE); // tells the players who is going to move first 
					}

					else{ // if player 1 is not moving first
						JOptionPane.showMessageDialog(main_frame,
								"Random selection has chosen " + player2 + " to move first. After this the turns will alternate.",
								"First Move",
								JOptionPane.WARNING_MESSAGE);
					}	
				}
				
				else{ // if the names are in the wrong format return to main menu
					card_layout.show(deck_panel, "TitlePanel");
				}			
		}
		
		else if (e.getActionCommand().equals("Developer Mode") ||
				 e.getActionCommand().equals("Reset")){ // check if teh user want to use dev mode
				developerScreen();
				Model.dev_mode = true; // set to true so the system know the user is in dev mode
				Control.redcount = 0;
				Control.bluecount = 0;
				for (int x = 0; x < 7; x++){ // creates the board as normal
					for (int y = 0; y < 6; y++){
						Control.coordinates[x][y] = 0;
						check_disk[x][y] = false;
					}
				}
				card_layout.show(deck_panel, "DeveloperPanel");
		}
		else if (e.getActionCommand().equals("Select Blue")){ // while in dev mode checks if user want to play blue disks (will place blue while selected)
			Control.mouseClick = 0;
		}
		else if (e.getActionCommand().equals("Select Red")){ // same for red disk
			Control.mouseClick = 1;
		}
		else if (e.getActionCommand().equals("Start Game ")){ // in dev mode if user wants to start a game from the current state
			boolean piece_air = pieceAir(), // checks if piece is in air
					win_check = win(); // TODO for Assignment 2
			int piece_diff = Math.abs(Control.bluecount - Control.redcount); // checks if the count of the piece is correct
			if (piece_diff > 1 && piece_air == true && win_check == true){ // if all errors occur the program will list them
				JOptionPane.showMessageDialog(main_frame,
					    "                    ERROR"+
				        "\n1) Too many of one colour \n2) A piece is in the air \n3) One of the players has a Connect 4",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			else if (piece_diff > 1 && piece_air == true){ // colours are uneven and piece are floating
				JOptionPane.showMessageDialog(main_frame,
					    "                    ERROR"+
				        "\n1) Too many of one colour \n2) A piece is in the air ",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			else if (piece_diff > 1 && win_check == true){ //if colours are uneven and a player has a winning combination
				JOptionPane.showMessageDialog(main_frame,
					    "                    ERROR"+
				        "\n1) Too many of one colour \n2) One of the players has a Connect 4",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			else if (piece_air == true && win_check == true){ // if piece in air and a player has a winning combination
				JOptionPane.showMessageDialog(main_frame,
					    "                    ERROR"+
				        "\n1) A piece is in the air \n2) One of the players has a Connect 4",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			else if (piece_diff > 1){ // if colours are uneven
				JOptionPane.showMessageDialog(main_frame,
					    "                    ERROR"+
					    "\n1) Too many of one colour",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}

			else if(piece_air == true){ // if piece in air
				JOptionPane.showMessageDialog(main_frame,
					    "                    ERROR"+
					    "\n1) A piece is in the air",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			
			else if (win_check == true){ // if player has winning combination
				JOptionPane.showMessageDialog(main_frame,
					    "                    ERROR"+
					    "\n1) One of the players has a Connect 4",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			else if (piece_diff == 1 ||piece_diff == 0 || piece_air == false ||	win_check == false) { // if game state is correct start the game
				gameScreen();
				panel = game_panel;
				playerNameSet(panel); // check names
				
				if (wrongFormat == false){ // check if formates okay
				card_layout.show(deck_panel, "GamePanel"); 
					for (int ix = 0; ix < 7; ix++){
						for (int iy = 0; iy < 6; iy++){
							if (Control.coordinates[ix][iy] == 1){
								blueDisk((ix)*99, (iy)*95, panel);
							}
							else if (Control.coordinates[ix][iy] == -1){
								redDisk((ix)*99, (iy)*95, panel);
							}
						}
					}
					if (mouseClick % 2 == 0){ // tell the users who is playing first
						JOptionPane.showMessageDialog(main_frame,
								"Random selection has chosen " + player1 + " to move first. After this the turns will alternate.",
								"First Move",
								JOptionPane.WARNING_MESSAGE);
					}

					else{
						JOptionPane.showMessageDialog(main_frame,
								"Random selection has chosen " + player2 + " to move first. After this the turns will alternate.",
								"First Move",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				
				else{ // if names are correct 
					card_layout.show(deck_panel, "DeveloperPanel"); 
				}				
				
				if(Control.bluecount > Control.redcount) mouseClick = 1; // checks to see who goes first depending on the developer mode state
				else if(Control.bluecount < Control.redcount) mouseClick = 0; // same 
				else mouseClick = rand.nextInt(2);
			}
		}
	}
	
	void mouseFunction(MouseEvent e, JPanel panel, boolean dev_model){ // used for determining location of mouse click
		try{
			int pointX = e.getX(), pointY = e.getY(); // gets the X/Y grid coordinates
			
			if (pointX <= 199  && pointX >= 100)  // the below if statements to see where the mouse click was and return a grid coordinate depending on the click
				setX(0);
			else if (pointX <= 299  && pointX >= 200)
				setX(1);
			else if (pointX <= 399  && pointX >= 300)
				setX(2);
			else if (pointX <= 499  && pointX >= 400)
				setX(3);
			else if (pointX <= 599  && pointX >= 500)
				setX(4);
			else if (pointX <= 699  && pointX >= 600)
				setX(5);
			else if (pointX <= 799  && pointX >= 700)
				setX(6);
			else
				setX(-5);

			if (pointY <= 99  && pointY >= 0)
				setY(0);
			else if (pointY <= 199  && pointY >= 100)
				setY(1);
			else if (pointY <= 299  && pointY >= 200)
				setY(2);
			else if (pointY <= 399  && pointY >= 300)
				setY(3);
			else if (pointY <= 499  && pointY >= 400)
				setY(4);
			else if (pointY <= 599  && pointY >= 500)
				setY(5);
			else
				setY(-5);
			
			if (Model.dev_mode == false){ // if the game is not in dev mode
				if(Model.check_disk[Disk.getX()][Disk.getY()] != true){ // makes sure a disk is not in the position
					Model.check_disk[Disk.getX()][Disk.getY()] = true;

					for(int i = Disk.getY()+1; i < 6; i++){ // checking to see if a dish is in the position
						if (Model.check_disk[Disk.getX()][i] == false){
							Model.check_disk[Disk.getX()][Disk.getY()] = false;
							setY(i);
							Model.check_disk[Disk.getX()][Disk.getY()] = true;
						}
						else{ // breaks if a disk is already there
							break;
						}
					}
					if(mouseClick%2==0){ // places the actuall disk depending on whos turn it is
						blueDisk((Disk.getX())*99, (Disk.getY())*95, panel);
						winner = player1name;
					}
					else{
						redDisk((Disk.getX())*99, (Disk.getY())*95, panel);
						winner = player2name;
					}
					mouseClick++; // increments mouse click
				}
				if (win() == true){
					JOptionPane.showMessageDialog(main_frame, winner + " has won!");
					card_layout.show(deck_panel, "TitlePanel");
					card_layout.removeLayoutComponent(panel);
				}
			}
			else{ // if user is in dev mode, the same happens with different properties (disks don't fall)
				if(Model.check_disk[Disk.getX()][Disk.getY()] != true){
					Model.check_disk[Disk.getX()][Disk.getY()] = true;
						
					if(mouseClick == 0){
						blueDisk((Disk.getX())*99, (Disk.getY())*95, panel);
						Control.bluecount++;
					}
					else if (mouseClick == 1){
						redDisk((Disk.getX())*99, (Disk.getY())*95, panel);
						Control.redcount++;
					}
				}
			}
		}
		catch(Exception error){ // catch if there's an exception
		}
	}
}