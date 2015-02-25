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
	//boolean game_started = false;
	JButton game_resume = new JButton("Resume Game");
	boolean developer_mode = false;

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
				exit_title = new JButton("Exit"),
				developer = new JButton ("Developer Mode");
		
		start_game.addActionListener(new Model(game_panel, developer_mode));
		instructions_title.addActionListener(new Control());
		developer.addActionListener(new Model(game_panel, developer_mode));
		exit_title.addActionListener(new Model());
		
		start_game.setBounds(183, 500, 125, 40); // sets where the button goes as well as the height and width
		instructions_title.setBounds(318, 500, 125, 40);
		developer.setBounds(453, 500, 125, 40);
		exit_title.setBounds(588, 500, 125, 40);
		
		title_panel.add(start_game);	// puts the button on the screen
		title_panel.add(instructions_title);	
		title_panel.add(developer);
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
		
		back_menu.addActionListener(new Model());		
		game_resume.addActionListener(new Model(info_panel, developer_mode)); 
		
		back_menu.setBounds(900-175 , 25, 150, 40);		
		game_resume.setBounds(25 , 25, 150, 40);

		info_panel.add(back_menu);
		info_panel.add(game_resume);

		//game_resume.setVisible(game_started);
		
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
		
		JButton new_game = new JButton ("New Game"), // buttons for game board
				exit = new JButton("Exit"),
				instructions_game = new JButton ("Instructions");

		JLabel blueDisk = new JLabel(blueimage),
			   redDisk = new JLabel (redimage);
		
		new_game.addActionListener(new Model());
		instructions_game.addActionListener(new Model());
		exit.addActionListener(new Model());
		
		new_game.setBounds(798, 400, 120, 40);
		instructions_game.setBounds(798, 460, 120, 40);
		exit.setBounds(798, 520, 120, 40);
		blueDisk.setBounds(0, 0, 95, 99);
		redDisk.setBounds(798, 0, 95, 99);
		
		game_panel.add(new_game);
		game_panel.add(instructions_game);
		game_panel.add(exit);
		game_panel.add(blueDisk);
		game_panel.add(redDisk);
		
		game_panel.addMouseListener(new Model(game_panel, developer_mode));
		
		deck_panel.add(game_panel, "GamePanel");
	}
	void developerScreen () throws IOException{
		final BufferedImage image = ImageIO.read(new File("Images/gameScreen.png")); 
		final ImageIcon blueimage = new ImageIcon("Images/Bluedisk.png");
		final ImageIcon redimage = new ImageIcon("Images/Reddisk.png");
		
		JPanel dev_panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
		dev_panel.setLayout(null);
		
		JButton redbutton = new JButton ("Red Button"),
				bluebutton = new JButton ("Blue Button"),
				startbutton = new JButton ("Start"),
				reset = new JButton ("Reset");

		JLabel blueDisk = new JLabel(blueimage),
			   redDisk = new JLabel (redimage);
		
		redbutton.addActionListener(new Model());
		bluebutton.addActionListener(new Model());
		startbutton.addActionListener(new Model());
		reset.addActionListener(new Model());
		
		redbutton.setBounds(798, 460, 120, 40);
		bluebutton.setBounds(798, 520, 120, 40);
		startbutton.setBounds(798, 400, 120, 40);
		reset.setBounds(798, 340, 120, 40);
		blueDisk.setBounds(0, 0, 95, 99);
		redDisk.setBounds(798, 0, 95, 99);
		
		dev_panel.add(redbutton);
		dev_panel.add(bluebutton);
		dev_panel.add(startbutton);
		dev_panel.add(reset);
		dev_panel.add(blueDisk);
		dev_panel.add(redDisk);
		
		//dev_mode = true;
		dev_panel.addMouseListener(new Model(dev_panel, developer_mode));
		deck_panel.add(dev_panel, "DeveloperPanel");
	}
}
