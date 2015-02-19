// COMP SCI 2ME3 

// Assignment 1
// Navleen Signh (1302228) // mother fucker you put your name above mine!
// Paul Warnick (1300963)
// Katrine Rachitsky (1306314)
// Hassaan Malik (1224997)
// Trevor Rae ()

/*
 * Things to Do!
 * 
 * 1) Kat and Trevor implement buttons for game screen (have players chose names before playing, mute button, highlight names depending on which players turn it is, exit game, main menu, instructions)
 * 2) Implement sounds in the game (pieces dropping, ingame sound)
 * 3) Check when there is a draw // Pop up when a player can no longer win (other player wins by default) / draw
 * 4) 
*/

import java.awt.Graphics; // jave imports for creating panels in a JFrame
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends Model{ // View class to create everything the user sees by using panels
	
	JPanel game_panel;
	
	void titleScreen () throws IOException{ // panel for the title screen
		final BufferedImage image = ImageIO.read(new File("Images/StartScreen.png"));        
		JPanel title_panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
		title_panel.setLayout(null);
		
		JButton start_game = new JButton("Start Game"), // buttons for title screen
				instructions_title = new JButton("Instructions"), 
				exit_title = new JButton("Exit");
		
		start_game.addActionListener(new Control());
		instructions_title.addActionListener(new Control());
		exit_title.addActionListener(new Control());
		
		start_game.setBounds(250, 500, 125, 40); // sets where the button goes as well as the height and width
		instructions_title.setBounds(385, 500, 125, 40);
		exit_title.setBounds(520, 500, 125, 40);
		
		title_panel.add(start_game);	// puts the button on the screen
		title_panel.add(instructions_title);	
		title_panel.add(exit_title);
		
		deck_panel.add(title_panel, "TitlePanel"); // adds the panel to the deck of panels
	}
	void infoScreen () throws IOException{ // info panel
		final BufferedImage image = ImageIO.read(new File("Images/Instructions.png"));        
		JPanel info_panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
		info_panel.setLayout(null); // sets up the buttons in the information panel
		
		JButton back_menu = new JButton("Main Menu");
		JButton game_resume = new JButton("Resume Game");
		
		back_menu.addActionListener(new Control());
		game_resume.addActionListener(new Control());
		
		back_menu.setBounds(900-175 , 25, 150, 40);		
		game_resume.setBounds(25 , 25, 150, 40);

		info_panel.add(back_menu);
		info_panel.add(game_resume);
		
		deck_panel.add(info_panel, "InfoPanel"); // adds to deck of panels
	}
	void gameScreen () throws IOException{ // panel for the actual game screen
		final BufferedImage image = ImageIO.read(new File("Images/gameScreen.png"));  
		final ImageIcon blueimage = new ImageIcon("Images/Bluedisk.png");
		final ImageIcon redimage = new ImageIcon("Images/Reddisk.png");
		
		game_panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
		game_panel.setLayout(null);
		
		JLabel blueDisk = new JLabel(blueimage);
		blueDisk.setBounds(5, 2, 93, 93);
		game_panel.add(blueDisk);
		
		JButton new_game = new JButton ("New Game"), // buttons for game board
				back_menu = new JButton("Main Menu"),
				instructions_game = new JButton ("Instructions"),
				player_one = new JButton("Player 1"),
				player_two = new JButton("Player 2");
		
		new_game.addActionListener(new Control());
		back_menu.addActionListener(new Control());
		instructions_game.addActionListener(new Control());
		//player_one.addActionListener(new Control()); add action later
		//player_two.addActionListener(new Control());
		
		new_game.setBounds(740, 400, 125, 40);
		back_menu.setBounds(740, 520, 125, 40);
		instructions_game.setBounds(740, 460, 125, 40);
		player_one.setBounds(740, 280, 125, 40);
		player_two.setBounds(740, 340, 125, 40); 
		
		game_panel.add(new_game);
		game_panel.add(back_menu);
		game_panel.add(instructions_game);
		game_panel.add(player_one);
		game_panel.add(player_two);
		
		game_panel.addMouseListener(new Control());
		
		deck_panel.add(game_panel, "GamePanel");
	}
	/*void endScreen (){ // TODO see declaration
		JPanel end_panel = new JPanel();
		end_panel.setBackground(Color.green);
		deck_panel.add(end_panel, "EndPanel");
	}*/
}
