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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Control extends View implements ActionListener, MouseListener{ // the control class determines what happens when clicks a button in one of the JPanels
	
	private JPanel panel;
	private int mouseClick = 0;

	Control(){
	}
	
	Control(JPanel game_panel){
		this.panel = game_panel;
	}
	
	private void blueDisk(int x, int y, JPanel panel) throws IOException{
		final ImageIcon blueimage = new ImageIcon("Images/Bluedisk.png");
		JLabel blueDisk = new JLabel(blueimage);
		blueDisk.setBounds(6+(100*x), 2+(96*y), 93, 93);
		panel.add(blueDisk);	
		card_layout.show(deck_panel, "GamePanel");
	}
	
	private void redDisk(int x, int y, JPanel panel) throws IOException{
		final ImageIcon redimage = new ImageIcon("Images/Reddisk.png");
		JLabel redDisk = new JLabel(redimage);
		redDisk.setBounds(6+(100*x), 2+(96*y), 93, 93);
		panel.add(redDisk);	
		card_layout.show(deck_panel, "GamePanel");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start Game")){  // if start game is clicked, go to gamepanel
			//game_started = true;
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
			//game_started = false;
			card_layout.show(deck_panel, "TitlePanel");
		}	
		else if (e.getActionCommand().equals("Resume Game")){

		}
		//panel.add(game_resume);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		try{
			for (int x = 0; x <= 600;){ // runs through each column
				for (int y = 0; y <= 500;){ // runs through each row
					if (y == 0){ // if the click was in the first row
						if (x == 0){ // if the click was in the first column
							if (((e.getX() >= x) && (e.getX() <= (x + 100))) && ((e.getY() >= y) && (e.getY() <= (y + 96)))){ // 
								if(mouseClick%2==0){
									blueDisk(x/100, y/96, panel);
									main_frame.repaint();
									main_frame.validate();
									mouseClick++;
								}
								else{
									redDisk(x/100, y/96, panel);
									main_frame.repaint();
									main_frame.validate();
									mouseClick++;
								}
							}
						}
						else{
							if (((e.getX() >= (x + 1)) && (e.getX() <= (x + 100))) && ((e.getY() >= (y)) && (e.getY() <= (y + 96)))){
								if(mouseClick%2==0){
									blueDisk(x/100, y/96, panel);
									main_frame.repaint();
									main_frame.validate();
									mouseClick++;
								}
								else{
									redDisk(x/100, y/96, panel);
									main_frame.repaint();
									main_frame.validate();
									mouseClick++;
								}
							}
						}
					}
					else{
						if (x == 0){
							if (((e.getX() >= x) && (e.getX() <= (x + 100))) && ((e.getY() >= (y + 1)) && (e.getY() <= (y + 96)))){
								if(mouseClick%2==0){
									blueDisk(x/100, y/96, panel);
									main_frame.repaint();
									main_frame.validate();
									mouseClick++;
									System.out.println(mouseClick);
								}
								else{
									redDisk(x/100, y/96, panel);
									main_frame.repaint();
									main_frame.validate();
									mouseClick++;
									System.out.println(mouseClick);
								}
							}
						}
						else{
							if (((e.getX() >= (x + 1)) && (e.getX() <= (x + 100))) && ((e.getY() >= (y + 1)) && (e.getY() <= (y + 96)))){
								if(mouseClick%2==0){
									blueDisk(x/100, y/96, panel);
									main_frame.repaint();
									main_frame.validate();
									mouseClick++;
									System.out.println(mouseClick);
								}
								else{
									redDisk(x/100, y/96, panel);
									main_frame.repaint();
									main_frame.validate();
									mouseClick++;
									System.out.println(mouseClick);
								}
							}
						}
					}
					y += 96;
				}
				x += 100;
			}
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
