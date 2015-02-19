// COMP SCI 2ME3 
// Assignment 1
// Navleen Signh (1302228)
// Paul Warnick (1300963)
// Katrine Ratchitsky ()
// Hassaan Malik ()
// Trevor Rae ()

/*
 * Things to Do!
 * 
 * 1) Kat and Trevor implement buttons for game screen (have players chose names before playing, mute button, highlight names depending on which players turn it is, exit game, main menu, instructions)
 * 2) Implement sounds in the game (pieces dropping, ingame sound)
 * 3) Check when there is a draw // Pop up when a player can no longer win (other player wins by default) / draw
 * 4) 
*/

import java.awt.CardLayout; // jave imports for creating panels in a JFrame
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends Model{ // View class to create everything the user sees by using panels
	
	/*public void changeFrame(String frame){
		if (frame == "title"){
			deck_panel.setLayout(card_layout = new CardLayout()); // sets the layout style of our window to Java's "Card Layout"
			//contentpane_panel = (JPanel) main_frame.getContentPane(); // shows the first card (pane)
			titleScreen(); // call the title screen panel to display // TODO (is this temporary just for testing? or are we going to call the title screen then go from there)
			card_layout.show (deck_panel,"Deck Panel"); // shows the first panel
		}
		if (frame == "instruction"){
			deck_panel.setLayout(card_layout = new CardLayout()); // sets the layout style of our window to Java's "Card Layout"
			contentpane_panel = (JPanel) main_frame.getContentPane(); // shows the first card (pane)
			infoScreen(); // call the title screen panel to display // TODO (is this temporary just for testing? or are we going to call the title screen then go from there)
			card_layout.show (deck_panel,"Deck Panel"); // shows the first panel
		}
		if (frame == "game"){}
	}*/
	
	void titleScreen () throws IOException{ // panel for the title screen
		final BufferedImage image = ImageIO.read(new File("Images/StartScreen.png"));        
		JPanel title_panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
		title_panel.setLayout(null);
		
		JButton start_game = new JButton("Start Game"), 
				instructions = new JButton("Instructions"), 
				exit = new JButton("Exit");
		
		start_game.addActionListener(new Control());
		instructions.addActionListener(new Control());
		exit.addActionListener(new Control());
		
		start_game.setBounds(250, 500, 125, 40);
		instructions.setBounds(385, 500, 125, 40);
		exit.setBounds(520, 500, 125, 40);
		title_panel.add(start_game);	
		title_panel.add(instructions);	
		title_panel.add(exit);	
		
		deck_panel.add(title_panel, "TitlePanel"); // adds the panel to the deck of panels
	}
	void infoScreen (){ // info panel
		JPanel info_panel = new JPanel();
		JButton back = new JButton("Back to Main Menu");
		info_panel.setBackground(Color.yellow); // colour is changed to yellow
		deck_panel.add(info_panel, "InfoPanel"); // adds to deck of panels
	}
	void gameScreen () throws IOException{ // panel for the actual game
		final BufferedImage image = ImageIO.read(new File("Images/gameScreen.png"));        
		JPanel game_panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
		game_panel.setLayout(null);
		
		deck_panel.add(game_panel, "GamePanel");
	}
	void endScreen (){ // TODO see declaration
		JPanel end_panel = new JPanel();
		end_panel.setBackground(Color.green);
		deck_panel.add(end_panel, "EndPanel");
	}
}
