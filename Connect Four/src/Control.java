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
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Control extends View implements ActionListener, MouseListener{ // the control class determines what happens when clicks a button in one of the JPanels
	
	private JPanel panel;
	private boolean dev_mode;
	private Random rand = new Random ();
	private int mouseClick = rand.nextInt(2);
	private String player1, player2;

	Control(){
	}
	
	Control(JPanel game_panel, boolean developermode){
		this.panel = game_panel;
		this.dev_mode = developermode;
	}
	
	private void blueDisk(int x, int y, JPanel panel) throws IOException{
		final ImageIcon blueimage = new ImageIcon("Images/Bluedisk.png");
		JLabel blueDisk = new JLabel(blueimage);
		blueDisk.setBounds(102+(x), 2+(y), 93, 93);
		panel.add(blueDisk);	
		card_layout.show(deck_panel, "GamePanel");
		main_frame.repaint();
		main_frame.validate();
	}
	
	private void redDisk(int x, int y, JPanel panel) throws IOException{
		final ImageIcon redimage = new ImageIcon("Images/Reddisk.png");
		JLabel redDisk = new JLabel(redimage);
		redDisk.setBounds(102+(x), 2+(y), 93, 93);
		panel.add(redDisk);	
		card_layout.show(deck_panel, "GamePanel");
		main_frame.repaint();
		main_frame.validate();
	}
	
	private void playerNameSet(JPanel panel){
		
		JLabel p1 = new JLabel();
		JLabel p2 = new JLabel();
		
		p1.setFont(new Font("Serif", Font.BOLD, 34));
		p2.setFont(new Font("Serif", Font.BOLD, 34));
		
		if(mouseClick % 2 == 0){
			player1 = JOptionPane.showInputDialog("Player "+ ((mouseClick % 2) + 1)+" Name: ");
			player2 = JOptionPane.showInputDialog("Player "+ ((mouseClick % 2) + 2)+" Name: ");
			p1.setText(player1);
			p2.setText(player2);
			
			p2.setBounds(740, 340, 125, 40);
			p1.setBounds(740, 280, 125, 40);
			p1.setForeground(Color.blue);
			p2.setForeground(Color.red);
		}
		else{
			player1 = JOptionPane.showInputDialog("Player "+ ((mouseClick % 2))+" Name: ");
			player2 = JOptionPane.showInputDialog("Player "+ ((mouseClick % 2) + 1)+" Name: ");
			p1.setText(player1);
			p2.setText(player2);
			
			p2.setBounds(740, 280, 125, 40);
			p1.setBounds(740, 340, 125, 40);
			p1.setForeground(Color.red);
			p2.setForeground(Color.blue);
		}

		panel.add(p1);	
		panel.add(p2);	
		
		card_layout.show(deck_panel, "GamePanel");
		main_frame.repaint();
		main_frame.validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//View call_view = new View();
		if (e.getActionCommand().equals("Start Game")){  // if start game is clicked, go to gamepanel
			playerNameSet(panel);
			//call_view.game_started = true;
			//call_view.game_resume.setVisible(game_started);
			//System.out.println();
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
			//call_view.game_started = false;
			card_layout.show(deck_panel, "TitlePanel");
		}	
		else if (e.getActionCommand().equals("Resume Game")){
			card_layout.show(deck_panel, "GamePanel"); 
		}
		else if (e.getActionCommand().equals("New Game")){
			try {
				gameScreen();
				panel = game_panel;
				playerNameSet(panel);
				card_layout.show(deck_panel, "GamePanel"); 
				for (int ix = 0; ix < 7; ix++){
					for (int iy = 0; iy < 6; iy++){
						check_disk[ix][iy] = false;
					}
				}
			} catch (IOException e1) {
			}
		}
		else if (e.getActionCommand().equals("Developer Mode")){
			try {
				dev_mode = true;
				developer_mode = dev_mode;
				//playerNameSet(panel);
				gameScreen();
				card_layout.show(deck_panel, "GamePanel"); 
			} catch (IOException e1) {
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
			if (dev_mode == false){
				if(Model.check_disk[Disk.getX()][Disk.getY()] != true){
					if(mouseClick%2==0){
						Model.check_disk[Disk.getX()][Disk.getY()] = true;
					}
					else{
						Model.check_disk[Disk.getX()][Disk.getY()] = true;
					}
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
					}
					else{
						redDisk((Disk.getX())*99, (Disk.getY())*95, panel);
					}
				}
			}
			else{
				if(mouseClick%2==0){
					blueDisk((Disk.getX())*99, (Disk.getY())*95, panel);
				}
				else{
					redDisk((Disk.getX())*99, (Disk.getY())*95, panel);
				}
			}
			mouseClick++;
		}catch(Exception error){
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
}
