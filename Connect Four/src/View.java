// COMP SCI 2ME3 

// Assignment 1
// Hassaan Malik (1224997)
// Katrine Rachitsky (1306314)
// Trevor Rae (1324949)
// Navleen Signh (1302228)
// Paul Warnick (1300963)


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics; // jave imports for creating panels in a JFrame
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		//main_frame.setTitle("Connect Four (Title Screen)");
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
		//main_frame.setTitle("Connect Four (Instruction Screen)");
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
		
		JButton mainmenu = new JButton ("Main Menu"), // buttons for game board
				exit = new JButton("Exit"),
				instructions_game = new JButton ("Instructions");

		JLabel blueDisk = new JLabel(blueimage),
			   redDisk = new JLabel (redimage);
		
		mainmenu.addActionListener(new Model());
		instructions_game.addActionListener(new Model());
		exit.addActionListener(new Model());	
		
		mainmenu.setBounds(798, 380, 93, 40);
		mainmenu.setMargin(new Insets(0,0,0,0));
		instructions_game.setBounds(798, 440, 93, 40);
		instructions_game.setMargin(new Insets(0,0,0,0));
		exit.setBounds(798, 500, 93, 40);
		exit.setMargin(new Insets(0,0,0,0));
		
		blueDisk.setBounds(0, 0, 95, 99);
		redDisk.setBounds(798, 0, 95, 99);
		
		blueDisk.setLayout(new FlowLayout(FlowLayout.LEFT));
		redDisk.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		game_panel.add(mainmenu);
		game_panel.add(instructions_game);
		game_panel.add(exit);
		game_panel.add(blueDisk);
		game_panel.add(redDisk);
		
		game_panel.addMouseListener(new Model(game_panel, developer_mode));
		
		deck_panel.add(game_panel, "GamePanel");
		//main_frame.setTitle("Connect Four (Game Screen)");
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
		
		JButton redbutton = new JButton ("Select Red"),
				bluebutton = new JButton ("Select Blue"),
				startbutton = new JButton ("Start Game "),
				reset = new JButton ("Reset"),
				mainmenu = new JButton ("Main Menu");

		JLabel blueDisk = new JLabel(blueimage),
			   redDisk = new JLabel (redimage),
			   devmode = new JLabel ("Developer Mode");
		
		redbutton.addActionListener(new Model());
		bluebutton.addActionListener(new Model());
		startbutton.addActionListener(new Model());
		reset.addActionListener(new Model());
		mainmenu.addActionListener(new Model());
		
		redbutton.setBounds(798, 110, 93, 40);
		redbutton.setMargin(new Insets(0,0,0,0));
		bluebutton.setBounds(3, 110, 93, 40);
		bluebutton.setMargin(new Insets(0,0,0,0));
		startbutton.setBounds(798, 380, 93, 40);
		startbutton.setMargin(new Insets(0,0,0,0));
		reset.setBounds(798, 440, 93, 40);
		mainmenu.setBounds(798, 500, 93, 40);
		mainmenu.setMargin(new Insets(0,0,0,0));
		blueDisk.setBounds(0, 0, 95, 99);
		redDisk.setBounds(798, 0, 95, 99);
		
		blueDisk.setLayout(new FlowLayout(FlowLayout.LEFT));
		redDisk.setLayout(new FlowLayout(FlowLayout.LEFT));
		devmode.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		devmode.setBounds(1, 520, 96, 40);
		devmode.setHorizontalAlignment(SwingConstants.CENTER);
		devmode.setOpaque(true);
		devmode.setForeground(new Color (200, 0, 0));
		devmode.setBackground(new Color (0, 0, 0, 50));
		
		dev_panel.add(redbutton);
		dev_panel.add(bluebutton);
		dev_panel.add(startbutton);
		dev_panel.add(reset);
		dev_panel.add(mainmenu);
		dev_panel.add(blueDisk);
		dev_panel.add(redDisk);
		dev_panel.add(devmode);
		
		//dev_mode = true;
		dev_panel.addMouseListener(new Model(dev_panel, developer_mode));
		deck_panel.add(dev_panel, "DeveloperPanel");
		//main_frame.setTitle("Connect Four (Developer Screen)");
	}
}
