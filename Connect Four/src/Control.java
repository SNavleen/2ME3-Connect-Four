// COMP SCI 2ME3 

// Assignment 1
// Navleen Signh (1302228)
// Paul Warnick (1300963)
// Katrine Rachitsky (1306314)
// Hassaan Malik (1224997)
// Trevor Rae ()

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent; // imports for user actions
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Control extends View{ // the control class determines what happens when clicks a button in one of the JPanels
	
	private static Random rand = new Random ();
	private static int mouseClick = rand.nextInt(2),
					   coordinates [][] = new int [7][6],
					   bluecount = 0,
					   redcount = 0;
	private String player1, player2;
	String winner;
	
	private void blueDisk(int x, int y, JPanel panel) throws IOException{
		final ImageIcon blueimage = new ImageIcon("Images/Bluedisk.png");
		JLabel blueDisk = new JLabel(blueimage);
		blueDisk.setBounds(102+(x), 2+(y), 93, 93);
		panel.add(blueDisk);	
		if (Model.dev_mode == false){
			card_layout.show(deck_panel, "GamePanel");
		}
		else{
			card_layout.show(deck_panel, "DeveloperPanel");
		}
		Control.coordinates[x/99][y/95] = 1;
		main_frame.repaint();
		main_frame.validate();
	}
	
	private void redDisk(int x, int y, JPanel panel) throws IOException{
		final ImageIcon redimage = new ImageIcon("Images/Reddisk.png");
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
	
	private void playerNameSet(JPanel panel){
		
		JLabel p1 = new JLabel();
		JLabel p2 = new JLabel();
		
		p1.setFont(new Font("Serif", Font.BOLD, 25));
		p2.setFont(new Font("Serif", Font.BOLD, 25));
		
		if(mouseClick % 2 == 0){
			player1 = JOptionPane.showInputDialog("Player "+ ((mouseClick % 2) + 1)+" Name: ");
			player2 = JOptionPane.showInputDialog("Player "+ ((mouseClick % 2) + 2)+" Name: ");
			p1.setText(player1);
			p2.setText(player2);
			
			p1.setBounds(5, 105, 120, 40);
			p2.setBounds(795, 105, 1250, 40);
			p1.setForeground(Color.blue);
			p2.setForeground(Color.red);
		}
		else{
			player1 = JOptionPane.showInputDialog("Player "+ ((mouseClick % 2))+" Name: ");
			player2 = JOptionPane.showInputDialog("Player "+ ((mouseClick % 2) + 1)+" Name: ");
			p1.setText(player1);
			p2.setText(player2);

			p1.setBounds(795, 105, 120, 40);
			p2.setBounds(5, 105, 120, 40);
			p1.setForeground(Color.red);
			p2.setForeground(Color.blue);
		}

		panel.add(p1);	
		panel.add(p2);	
		
		card_layout.show(deck_panel, "GamePanel");
		main_frame.repaint();
		main_frame.validate();
	}
	
	private boolean pieceAir (){
		for (int x = 0; x < 7; x++){
			for (int y = 0; y < 5; y++){
				if (Control.coordinates[x][y] == 1 || Control.coordinates[x][y] == -1){
					if ( Control.coordinates[x][y+1] == 0){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean win (){
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
	
	void buttonFunction(ActionEvent e, JPanel panel, boolean dev_mode) throws IOException{
		if (e.getActionCommand().equals("Instructions")){ // if instructions is clicked, go to infopanel
			infoScreen();
			card_layout.show(deck_panel, "InfoPanel");
		}
		else if (e.getActionCommand().equals("Exit")){ 
			int exit = JOptionPane.showConfirmDialog(main_frame, "Are you sure you want to close?", "", 0); // checks to see if the user really wants to close the window
			if (exit == 0){ System.exit (0); }// if so the window closes
		}
		else if (e.getActionCommand().equals("Main Menu")){ 
			//call_view.game_started = false;
			card_layout.show(deck_panel, "TitlePanel");
		}	
		else if (e.getActionCommand().equals("Resume Game")){
			card_layout.show(deck_panel, "GamePanel"); 
		}
		else if (e.getActionCommand().equals("Start Game")||
				 e.getActionCommand().equals("New Game")){
				gameScreen();
				panel = game_panel;
				playerNameSet(panel);
				card_layout.show(deck_panel, "GamePanel"); 
				for (int ix = 0; ix < 7; ix++){
					for (int iy = 0; iy < 6; iy++){
						check_disk[ix][iy] = false;
						Control.coordinates[ix][iy] = 0;
					}
				}
		}
		
		else if (e.getActionCommand().equals("Developer Mode") || 
				 e.getActionCommand().equals("Reset")){
				developerScreen();
				Model.dev_mode = true;
				card_layout.show(deck_panel, "DeveloperPanel");
				for (int x = 0; x < 7; x++){
					for (int y = 0; y < 6; y++){
						Control.coordinates[x][y] = 0;
						check_disk[x][y] = false;
					}
				}
		}
		else if (e.getActionCommand().equals("Blue Button")){
			Control.mouseClick = 0;
		}
		else if (e.getActionCommand().equals("Red Button")){
			Control.mouseClick = 1;
		}
		else if (e.getActionCommand().equals("Start")){
			boolean piece_air = pieceAir();
			boolean win_check = win();
			int piece_diff = Math.abs(Control.bluecount - Control.redcount);
			if (piece_diff > 1){
				JOptionPane.showMessageDialog(main_frame,
					    "Too many of one color",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}

			else if(piece_air == true){
				JOptionPane.showMessageDialog(main_frame,
					    "A piece is in the air",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			
			else if (win_check == true){
				JOptionPane.showMessageDialog(main_frame,
					    "One of the players has a Connect 4",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			else if (piece_diff == 1 ||piece_diff == 0 || piece_air == false ||	win_check == false) {
				gameScreen();
				panel = game_panel;
				playerNameSet(panel);
				card_layout.show(deck_panel, "GamePanel"); 
				for (int ix = 0; ix < 7; ix++){
					for (int iy = 0; iy < 6; iy++){
						if (Control.coordinates[ix][iy] == 1){
							//Model.check_disk[ix][iy] = true;
							blueDisk((ix)*99, (iy)*95, panel);
						}
						else if (Control.coordinates[ix][iy] == -1){
							//Model.check_disk[ix][iy] = true;
							redDisk((ix)*99, (iy)*95, panel);
						}
						//else
						//Model.check_disk[ix][iy] = false;
					}
				}
			}
		}
	}
	
	void mouseFunction(MouseEvent e, JPanel panel, boolean dev_model){
		try{
			int pointX = e.getX(), pointY = e.getY();
			
			if (pointX <= 199  && pointX >= 100)
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
			
			//System.out.println(Model.check_disk[Disk.getX()][Disk.getY()]);
			
			if (Model.dev_mode == false){
				if(Model.check_disk[Disk.getX()][Disk.getY()] != true){
					Model.check_disk[Disk.getX()][Disk.getY()] = true;

					for(int i = Disk.getY()+1; i < 6; i++){
						if (Model.check_disk[Disk.getX()][i] == false){
							Model.check_disk[Disk.getX()][Disk.getY()] = false;
							setY(i);
							Model.check_disk[Disk.getX()][Disk.getY()] = true;
						}
						else{
							break;
						}
					}
					if(mouseClick%2==0){
						blueDisk((Disk.getX())*99, (Disk.getY())*95, panel);
						winner = "Blue Player";
					}
					else{
						redDisk((Disk.getX())*99, (Disk.getY())*95, panel);
						winner = "Red Player";
					}
					mouseClick++;
				}
				if (win() == true){
					JOptionPane.showMessageDialog(main_frame, winner);
					card_layout.show(deck_panel, "InfoPanel");
				}
			}
			else{	
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
		}catch(Exception error){
		}
	}
}
