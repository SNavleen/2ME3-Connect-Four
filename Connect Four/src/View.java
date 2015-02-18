// COMP SCI 2ME3 
// Assignment 1
// Navleen Signh (1302228)
// Paul Warnick (1300963)
// Katrine Ratchitsky ()
// Hassaan Malik ()
// Trevor Rae ()

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

	public CardLayout card_layout; // creates a new type CardLayout to determine how the panels are shown
	
	JPanel deck_panel = new JPanel(),  // main panel in which all other panels are displayed
		   contentpane_panel = new JPanel(), // used for showing the current panel
		   title_panel = new JPanel(), // panel that contains the title screen with start, help, exit, etc. buttons
		   info_panel = new JPanel(),  // panel for instructions/help
		   game_panel = new JPanel(),  // panel in which the actually connect four game is played
		   end_panel = new JPanel(); // finish screen panel for once the game is over // TODO (Navleen, do we need this? Could we just display this via the game panel saying something like "You Won!" or w/e)
	
	void mainView (JFrame main_frame) throws IOException{ // main function to call all the panels in the correct order
		deck_panel.setLayout(card_layout = new CardLayout()); // sets the layout style of our window to Java's "Card Layout"
		contentpane_panel = (JPanel) main_frame.getContentPane(); // shows the first card (pane)
		
		titleScreen(); // call the title screen panel to display // TODO (is this temporary just for testing? or are we going to call the title screen then go from there)
		infoScreen();
		gameScreen();
		endScreen();
		
		panelPick();
		
		card_layout.show (deck_panel,"Deck Panel"); // shows the first panel 
	}
	
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
	
	void panelPick(){
		titleButtons();
	}
	
	private void titleScreen () throws IOException{ // panel for the title screen
		final BufferedImage title_backimage = ImageIO.read(new File("Images/TitleBackground.jpg"));        
		title_panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(title_backimage, 0, 0, null);
            }
        };
		title_panel.setLayout(null);
		deck_panel.add(title_panel, "Title Panel"); // adds the panel to the deck of panels
	}
	private void infoScreen (){ // info panel
		JButton back = new JButton("Back to Main Menu");
		info_panel.setBackground(Color.yellow); // colour is changed to yellow
		deck_panel.add(info_panel, "Info Panel"); // adds to deck of panels
	}
	private void gameScreen (){ // panel for the actual game
		game_panel.setBackground(Color.blue);
		deck_panel.add(game_panel, "Game Panel");
	}
	private void endScreen (){ // TODO see declaration
		end_panel.setBackground(Color.green);
		deck_panel.add(end_panel, "End Panel");
	}
	void titleButtons(){
		
		JButton start_game = new JButton("Start Game"), 
				instructions = new JButton("Instructions"), 
				exit = new JButton("Exit");
		
		//Image startButtonImage = ImageIO.read(getClass().getResource("image\\startbutton.png"));
		//start_game.setIcon(new ImageIcon(startButtonImage));
		start_game.addActionListener(new Control());
		instructions.addActionListener(new Control());
		exit.addActionListener(new Control());
		
		start_game.setBounds(150, 500, 125, 40);
		instructions.setBounds(285, 500, 125, 40);
		exit.setBounds(420, 500, 125, 40);
		title_panel.add(start_game);	
		title_panel.add(instructions);	
		title_panel.add(exit);	
	}
}
