// COMP SCI 2ME3 
// Assignment 1
// Navleen Signh (1302228)
// Paul Warnick (1300963)
// Katrine Rachitsky ()
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

// jave imports for creating panels in a JFrame
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class View extends Model{ // View class to create everything the user sees by using panels
	
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
				instructions_title = new JButton("Instructions"), 
				exit_title = new JButton("Exit");
		
		start_game.addActionListener(new Control());
		instructions_title.addActionListener(new Control());
		exit_title.addActionListener(new Control());
		
		start_game.setBounds(250, 500, 125, 40);
		instructions_title.setBounds(385, 500, 125, 40);
		exit_title.setBounds(520, 500, 125, 40);
		
		title_panel.add(start_game);	
		title_panel.add(instructions_title);	
		title_panel.add(exit_title);	
		
		deck_panel.add(title_panel, "TitlePanel"); // adds the panel to the deck of panels
	}
	void infoScreen () throws IOException{ // info panel
		final BufferedImage image = ImageIO.read(new File("Images/Instructions.png"));        
		JPanel info_panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
		info_panel.setLayout(null);
		
		JButton back = new JButton("Back to Main Menu");
		
		back.addActionListener(new Control());
		
		back.setBounds(900-175 , 25, 150, 40);
		
		info_panel.add(back);
		
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
		
		JButton new_game = new JButton ("New Game"),
				exit_game = new JButton ("Exit"),
				instructions_game = new JButton ("Instructions");
		
		new_game.addActionListener(new Control());
		exit_game.addActionListener(new Control());
		instructions_game.addActionListener(new Control());

		new_game.setBounds(250, 500, 125, 40);
		exit_game.setBounds(520, 500, 125, 40);
		instructions_game.setBounds(385, 500, 125, 40);
		
		game_panel.add(new_game);
		game_panel.add(exit_game);
		game_panel.add(instructions_game);
		
		deck_panel.add(game_panel, "GamePanel");
	}
	void endScreen (){ // TODO see declaration
		JPanel end_panel = new JPanel();
		end_panel.setBackground(Color.green);
		deck_panel.add(end_panel, "EndPanel");
	}
}
