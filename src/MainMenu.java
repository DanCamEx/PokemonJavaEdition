import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu {
	
	private JFrame mainFrame = new JFrame();
	
	private JPanel battlePanel = new JPanel(new GridBagLayout());
	
	private JLabel[] pokemon1 = {new JLabel(), new JLabel(), new JLabel()};
	private JLabel[] pokemon2 = {new JLabel(), new JLabel(), new JLabel()};
	
	private JLabel player1Info = new JLabel();
	private JLabel player2Info = new JLabel();
	
	private ImageIcon battleBackground = new ImageIcon(getClass().getResource("/images/battleBackground.png"));
	private JLabel battleBackgroundLabel = new JLabel(battleBackground);
	
	private ImageIcon startBackground = new ImageIcon(getClass().getResource("/images/startBackground.png"));
	private JLabel startBackgroundLabel = new JLabel(startBackground);
	
	private ImageIcon squadBackground = new ImageIcon(getClass().getResource("/images/chooseStarter.jpg"));
	private JLabel squadBackgroundLabel = new JLabel(squadBackground);
	
	private ImageIcon loadBackground = new ImageIcon(getClass().getResource("/images/loadBackground.jpg"));
	private JLabel loadBackgroundLabel = new JLabel(loadBackground);
	
	private ImageIcon transitionBackground = new ImageIcon(getClass().getResource("/images/transitionBackground.jpg"));
	private JLabel transitionBackgroundLabel = new JLabel(transitionBackground);
	
	private ImageIcon profileBackground = new ImageIcon(getClass().getResource("/images/profileBackground.jpg"));
	private JLabel profileBackgroundLabel = new JLabel(profileBackground);
	
	private int chosenPosition1;
	private int chosenPosition2;

	private GridBagConstraints gbc = new GridBagConstraints();
	
	private int battleCounter = 1;

	//GUI IMPLEMENTATION
	public MainMenu() {
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		mainFrame.setTitle("Pokémon Java Version");
		mainFrame.setSize(1296, 759);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLayout(new GridBagLayout());
		mainFrame.setVisible(true);		
		
		Image gameIcon = Toolkit.getDefaultToolkit().getImage("src/images/gameIcon.png");
		mainFrame.setIconImage(gameIcon);
	}
	
	public void startMenu() {
		
		//MENU SETTING
		JPanel startPanel = new JPanel(new GridBagLayout());
		
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("images/logo.png"));
		JLabel logoLabel = new JLabel("", logo, JLabel.CENTER);
		gbc.insets = new Insets(0, 0, 250, 30);
		startPanel.add(logoLabel, gbc);
		
		JLabel title = new JLabel("JAVA VERSION");
		title.setFont(applyPokemonFont(40f));
		gbc.insets = new Insets(0, 0, 80, 0);
		startPanel.add(title, gbc);
		
		//BUTTON SETTING
		JButton startButton = new JButton("    Start    ");
		startButton.setFont(applyPokemonFont(30f));
		startButton.setBackground(Color.WHITE);
		gbc.insets = new Insets(150, 0, 0, 0);
		startPanel.add(startButton, gbc);
		
		JButton quitButton = new JButton("      Quit      ");
		quitButton.setFont(applyPokemonFont(30f));
		quitButton.setBackground(Color.WHITE);
		gbc.insets = new Insets(350, 0, 0, 0);
		startPanel.add(quitButton, gbc);
		
		JButton loadButton = new JButton("     Load     ");
		loadButton.setFont(applyPokemonFont(30f));
		loadButton.setBackground(Color.WHITE);
		gbc.insets = new Insets(250, 0, 0, 0);
		startPanel.add(loadButton, gbc);
		
		//BUTTON INPUT
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (LoadNSave.checkIfLong2("saves")==false) {
					
					JLabel clickLoad = new JLabel("<html>You must load at least two profiles in order to start the game. <br> Please go to \"load\" and create them.</html>");
					clickLoad.setFont(applyPokemonFont(30f));
					clickLoad.setForeground(Color.RED);
					gbc.insets = new Insets(150, 700, 0, 0);
					startPanel.add(clickLoad, gbc);
					
					updateBackground(startBackgroundLabel, startPanel);
					
				}
				else {
					
					startPanel.removeAll();
					mainFrame.remove(startPanel);
					squadSelectionMenu(Player.p1, 0);
					
				}
			}
		});
		
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.setVisible(false);
				System.exit(0);
				
			}
		});
		
		loadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				startPanel.removeAll();
				mainFrame.remove(startPanel);
				loadMenu();
				
			}
		});
		
		//FRAME SETTING
		updateBackground(startBackgroundLabel, startPanel);
		mainFrame.add(startPanel);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void loadMenu() {
		
		//MENU SETTING
		JPanel loadPanel = new JPanel(new GridBagLayout());
		
		JLabel titleLabel = new JLabel("LOAD MENU'");
		titleLabel.setFont(applyPokemonFont(100f));
		titleLabel.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 600, 0);
		loadPanel.add(titleLabel, gbc);
		
		JLabel profilesLabel = new JLabel("PROFILES");
		profilesLabel.setFont(applyPokemonFont(70f));
		profilesLabel.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 500, 1000);
		loadPanel.add(profilesLabel, gbc);
		
		
		int position=300;
		int number=1;
		
		for (File character : LoadNSave.getDirFiles()) {
			
			JButton characterButton = new JButton(number+". "+character.getName().substring(0, character.getName().length()-4));
			characterButton.setFont(applyPokemonFont(30f));
			characterButton.setBackground(Color.WHITE);
			gbc.insets = new Insets(0, 0, position, 1000);
			loadPanel.add(characterButton, gbc);
			
			JButton chooseP1Button = new JButton("Set as Player 1");
			chooseP1Button.setFont(applyPokemonFont(30f));
			chooseP1Button.setBackground(Color.BLUE);
			chooseP1Button.setForeground(Color.WHITE);
			gbc.insets = new Insets(0, 0, position, 600);
			loadPanel.add(chooseP1Button, gbc);
			chooseP1Button.setVisible(false);
			
			JButton chooseP2Button = new JButton("Set as Player 2");
			chooseP2Button.setFont(applyPokemonFont(30f));
			chooseP2Button.setBackground(Color.RED);
			chooseP2Button.setForeground(Color.WHITE);
			gbc.insets = new Insets(0, 0, position, 200);
			loadPanel.add(chooseP2Button, gbc);
			chooseP2Button.setVisible(false);
			
			JButton viewProfileButton = new JButton("View profile");
			viewProfileButton.setFont(applyPokemonFont(30f));
			viewProfileButton.setBackground(Color.WHITE);
			gbc.insets = new Insets(0, 200, position, 0);
			loadPanel.add(viewProfileButton, gbc);
			viewProfileButton.setVisible(false);
			
			JLabel profile1LoadedLabel = new JLabel("Correctly loaded as Player 1!");
			profile1LoadedLabel.setFont(applyPokemonFont(30f));
			profile1LoadedLabel.setForeground(Color.GREEN);
			gbc.insets = new Insets(0, 0, position+100, 600);
			loadPanel.add(profile1LoadedLabel, gbc);
			profile1LoadedLabel.setVisible(false);
			
			JLabel profile2LoadedLabel = new JLabel("Correctly loaded as Player 2!");
			profile2LoadedLabel.setFont(applyPokemonFont(30f));
			profile2LoadedLabel.setForeground(Color.GREEN);
			gbc.insets = new Insets(0, 0, position+100, 200);
			loadPanel.add(profile2LoadedLabel, gbc);
			profile2LoadedLabel.setVisible(false);
			
			number++;
			position=position-200;
			
			characterButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					chooseP1Button.setVisible(true);
					chooseP2Button.setVisible(true);
					viewProfileButton.setVisible(true);
				}
			});
			
			chooseP1Button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						LoadNSave.load(character.getName().substring(0, character.getName().length()-4), Player.p1);
						
						profile2LoadedLabel.setVisible(false);
						profile1LoadedLabel.setVisible(true);
					} catch (IOException e1) {
						System.out.println("Error. Can't load the profile.");
						e1.printStackTrace();
					}
				}
			});
			
			chooseP2Button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						LoadNSave.load(character.getName().substring(0, character.getName().length()-4), Player.p2);
						
						profile2LoadedLabel.setVisible(true);
						profile1LoadedLabel.setVisible(false);
					} catch (IOException e1) {
						System.out.println("Error. Can't load the profile.");
						e1.printStackTrace();
					}
				}
			});
			
			viewProfileButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					loadPanel.removeAll();
					mainFrame.remove(loadPanel);
					viewProfileMenu(character.getName().substring(0, character.getName().length()-4));
				}
			});
			
		}
		
		JTextField profileName = new JTextField();
		profileName.setBackground(Color.WHITE);
		profileName.setForeground(Color.BLACK);
		profileName.setFont(applyPokemonFont(30f));
		profileName.setPreferredSize(new Dimension(150, 40));
		gbc.insets = new Insets(0, 0, 0, 200);
		loadPanel.add(profileName, gbc);
		
		JButton createProfileButton = new JButton("Create profile");
		createProfileButton.setFont(applyPokemonFont(30f));
		createProfileButton.setBackground(Color.WHITE);
		gbc.insets = new Insets(0, 120, 0, 0);
		loadPanel.add(createProfileButton, gbc);
		
		JButton back = new JButton("Back");
		back.setFont(applyPokemonFont(40f));
		back.setBackground(Color.WHITE);
		gbc.insets = new Insets(600,0,0,0);
		loadPanel.add(back, gbc);
		
		createProfileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (profileName.getText().length()==0) {
					JLabel notPossible = new JLabel("You must choose a nickname");
					notPossible.setFont(applyPokemonFont(30f));
					notPossible.setForeground(Color.RED);
					gbc.insets=new Insets(0, 0, 150, 50);
					loadPanel.add(notPossible, gbc);
					updateBackground(loadBackgroundLabel, loadPanel);
				}
				
				else if (profileName.getText().length()>10) {
					JLabel notPossible = new JLabel("Nickname is too long");
					notPossible.setFont(applyPokemonFont(30f));
					notPossible.setForeground(Color.RED);
					gbc.insets=new Insets(0, 0, 100, 50);
					loadPanel.add(notPossible, gbc);
					updateBackground(loadBackgroundLabel, loadPanel);
				}
				
				else {
					LoadNSave.create(profileName.getText());
					JLabel success = new JLabel("Profile created! To see it, restart the game.");
					success.setFont(applyPokemonFont(30f));
					success.setForeground(Color.GREEN);
					gbc.insets=new Insets(0, 0, 200, 50);
					loadPanel.add(success, gbc);
					updateBackground(loadBackgroundLabel, loadPanel);
				}
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadPanel.removeAll();
				mainFrame.remove(loadPanel);
				startMenu();
			}
		});
		
		updateBackground(loadBackgroundLabel, loadPanel);
		
		mainFrame.add(loadPanel);
		mainFrame.revalidate();
		mainFrame.repaint();	
	}
	
	public void viewProfileMenu(String characterName) {
		
		JPanel profilePanel = new JPanel(new GridBagLayout());
		
		JLabel title =  new JLabel("Profile stats");
		title.setFont(applyPokemonFont(100f));
		title.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 500, 600);
		profilePanel.add(title, gbc);
		
		JButton back = new JButton("Back");
		back.setFont(applyPokemonFont(40f));
		back.setBackground(Color.WHITE);
		gbc.insets = new Insets(600,0,0,800);
		profilePanel.add(back, gbc);
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				profilePanel.removeAll();
				mainFrame.remove(profilePanel);
				loadMenu();
			}
		});
		
		try {
			JLabel info =  new JLabel(LoadNSave.read(characterName));
			info.setFont(applyPokemonFont(70f));
			info.setForeground(Color.WHITE);
			gbc.insets = new Insets(0, 0, 0, 600);
			profilePanel.add(info, gbc);
		} catch (IOException e) {
			System.out.println("I can't view this info :(");
			e.printStackTrace();
		}
		
		updateBackground(profileBackgroundLabel, profilePanel);
		
		mainFrame.add(profilePanel);
		mainFrame.revalidate();
		mainFrame.repaint();	
		
	}
	
	public void squadSelectionMenu(Player p, int pokemonPosition) {
		int i = pokemonPosition;
	
		if (pokemonPosition == 3 && p==Player.p2) {
			setSprites();
			choiceMenu(Player.p1);
		}
		else if (pokemonPosition == 3) {
			squadSelectionMenu(Player.p2, 0);
		}
		else {
			
			JPanel squadSelectionPanel = new JPanel(new GridBagLayout());
			
			JLabel chooseLabel = new JLabel("Hello "+p.getNickname()+ ", please choose pokémon number " + (i+1));
			chooseLabel.setFont(applyPokemonFont(70f));
			chooseLabel.setForeground(Color.BLACK);
			gbc.insets = new Insets(0, 0, 600, 0);
			squadSelectionPanel.add(chooseLabel, gbc);
			
			JButton chooseBulbasaur = new JButton("Bulbasaur");
			chooseBulbasaur.setFont(applyPokemonFont(30f));
			chooseBulbasaur.setBackground(Color.GREEN);
			gbc.insets = new Insets(250, 0, 0, 585);
			squadSelectionPanel.add(chooseBulbasaur, gbc);
			
			JButton chooseSquirtle = new JButton("Squirtle");
			chooseSquirtle.setFont(applyPokemonFont(30f));
			chooseSquirtle.setBackground(Color.CYAN);
			gbc.insets = new Insets(250, 585, 0, 0);
			squadSelectionPanel.add(chooseSquirtle, gbc);
			
			JButton chooseCharmander = new JButton("Charmander");
			chooseCharmander.setFont(applyPokemonFont(30f));
			chooseCharmander.setBackground(Color.RED);
			gbc.insets = new Insets(450, 0, 0, 0);
			squadSelectionPanel.add(chooseCharmander, gbc);
			
			chooseBulbasaur.addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
					p.setPokemonSquad("Bulbasaur", i);
					mainFrame.remove(squadSelectionPanel);
					if (i==0) {
						p.setCurrentPokemon(0);
						p.setOtherPositions(p);
						squadSelectionMenu(p, i+1);
					}
					else {
						squadSelectionMenu(p, i+1);
					}
				}
			});
			
			chooseSquirtle.addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
					p.setPokemonSquad("Squirtle", i);
					mainFrame.remove(squadSelectionPanel);
					if (i==0) {
						p.setCurrentPokemon(0);
						p.setOtherPositions(p);
						squadSelectionMenu(p, i+1);
					}
					else {
						squadSelectionMenu(p, i+1);
					}
				}
			});
			
			chooseCharmander.addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
					p.setPokemonSquad("Charmander", i);
					mainFrame.remove(squadSelectionPanel);
					if (i==0) {
						p.setCurrentPokemon(0);
						p.setOtherPositions(p);
						squadSelectionMenu(p, i+1);
					}
					else {
						squadSelectionMenu(p, i+1);
					}
				}
			});
			
			updateBackground(squadBackgroundLabel, squadSelectionPanel);
			
			mainFrame.add(squadSelectionPanel);
			mainFrame.revalidate();
			mainFrame.repaint();
		}
	}
	
	public void choiceMenu(Player p) {
		
		try {
			updatePlayerInfo(Player.p1);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			updatePlayerInfo(Player.p2);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		JLabel battleCounterLabel = new JLabel("Match n."+battleCounter);
		battleCounterLabel.setFont(applyPokemonFont(30f));
		battleCounterLabel.setForeground(Color.BLACK);
		gbc.insets = new Insets(0,0,670,1170);
		battlePanel.add(battleCounterLabel, gbc);

		JButton fightButton = new JButton("Fight");
		fightButton.setFont(applyPokemonFont(25f));
		fightButton.setBackground(Color.WHITE);
		gbc.insets = new Insets(350,450,0,0);
		battlePanel.add(fightButton, gbc);
		if ((int)p.getCurrentPokemon().getHp()<=0) {
			fightButton.setEnabled(false);
		}
		
		JButton surrenderButton = new JButton("Surrender");
		surrenderButton.setFont(applyPokemonFont(25f));
		surrenderButton.setBackground(Color.WHITE);
		gbc.insets = new Insets(510,450,0,0);
		battlePanel.add(surrenderButton, gbc);
		
		JButton moveButton1 = new JButton(p.getCurrentPokemon().getMove1().getName());
		moveButton1.setFont(applyPokemonFont(25f));
		moveButton1.setBackground(Color.WHITE);
		gbc.insets = new Insets(350,450,0,0);
		battlePanel.add(moveButton1, gbc);
		moveButton1.setVisible(false);
		
		JButton moveButton2 = new JButton(p.getCurrentPokemon().getMove2().getName());
		moveButton2.setFont(applyPokemonFont(25f));
		moveButton2.setBackground(Color.WHITE);
		gbc.insets = new Insets(430,450,0,0);
		battlePanel.add(moveButton2, gbc);
		moveButton2.setVisible(false);
		
		JButton moveButton3 = new JButton(p.getCurrentPokemon().getMove3().getName());
		moveButton3.setFont(applyPokemonFont(25f));
		moveButton3.setBackground(Color.WHITE);
		gbc.insets = new Insets(510,450,0,0);
		battlePanel.add(moveButton3, gbc);
		moveButton3.setVisible(false);
		
		JButton moveButton4 = new JButton(p.getCurrentPokemon().getMove4().getName());
		moveButton4.setFont(applyPokemonFont(25f));
		moveButton4.setBackground(Color.WHITE);
		gbc.insets = new Insets(590,450,0,0);
		battlePanel.add(moveButton4, gbc);
		moveButton4.setVisible(false);
		
		JButton back = new JButton("Back");
		back.setFont(applyPokemonFont(25f));
		back.setBackground(Color.WHITE);
		gbc.insets = new Insets(670,450,0,200);
		battlePanel.add(back, gbc);
		back.setVisible(false);
		
		JButton pk1 = new JButton(p.getPokemon(p.getOtherPosition(0)).getName()+"  "+(int)p.getPokemon(p.getOtherPosition(0)).getHp()+" HP");
		pk1.setFont(applyPokemonFont(25f));
		pk1.setBackground(Color.WHITE);
		gbc.insets = new Insets(350,450,0,0);
		battlePanel.add(pk1, gbc);
		if ((int)p.getPokemon(p.getOtherPosition(0)).getHp()<=0) {
			pk1.setEnabled(false);
		}
		pk1.setVisible(false);
		
		JButton pk2 = new JButton(p.getPokemon(p.getOtherPosition(1)).getName()+"  "+(int)p.getPokemon(p.getOtherPosition(1)).getHp()+" HP");
		pk2.setFont(applyPokemonFont(25f));
		pk2.setBackground(Color.WHITE);
		gbc.insets = new Insets(430,450,0,0);
		battlePanel.add(pk2, gbc);
		if ((int)p.getPokemon(p.getOtherPosition(1)).getHp()<=0) {
			pk2.setEnabled(false);
		}
		pk2.setVisible(false);
		
		JLabel choiceText = new JLabel(p.getNickname()+", what do you want to do?");
		choiceText.setFont(applyPokemonFont(25f));
		choiceText.setForeground(Color.BLACK);
		gbc.insets = new Insets(250,450,0,0);
		battlePanel.add(choiceText, gbc);
		
		JButton changePokemonButton = new JButton("Change  Pokémon");
		changePokemonButton.setFont(applyPokemonFont(25f));
		changePokemonButton.setBackground(Color.WHITE);
		gbc.insets = new Insets(430,450,0,0);
		battlePanel.add(changePokemonButton, gbc);
		if (pk1.isEnabled()==false && pk2.isEnabled()==false) {
			changePokemonButton.setEnabled(false);
		}
		
		fightButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fightButton.setVisible(false);
				surrenderButton.setVisible(false);
				changePokemonButton.setVisible(false);
				
				moveButton1.setVisible(true);
				moveButton2.setVisible(true);
				moveButton3.setVisible(true);
				moveButton4.setVisible(true);
				back.setVisible(true);
				
				mainFrame.revalidate();
				mainFrame.repaint();
			}
		});
		
		changePokemonButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fightButton.setVisible(false);
				surrenderButton.setVisible(false);
				changePokemonButton.setVisible(false);
				
				back.setVisible(true);
				pk1.setVisible(true);
				pk2.setVisible(true);
				
				mainFrame.revalidate();
				mainFrame.repaint();
		}
		});
		
		pk1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setChoice(PokeMove.switchPokemon);
				if (p == Player.p1) {
					chosenPosition1 = p.getOtherPosition(0);
					if ((int)p.getCurrentPokemon().getHp()<=0) {
						pk1.setEnabled(false);
						pk2.setEnabled(false);
						back.setEnabled(false);
						
						Player.p2.setChoice(PokeMove.empty);
						turnMenu(Turn.speedCheck(), 500, false);
					}
					else {
						battlePanel.removeAll();
						choiceMenu(Player.p2);
					}
				}
				else {
					chosenPosition2  = p.getOtherPosition(0);
					if ((int)p.getCurrentPokemon().getHp()<=0) {
						pk1.setEnabled(false);
						pk2.setEnabled(false);
						back.setEnabled(false);
						
						Player.p1.setChoice(PokeMove.empty);
						turnMenu(Turn.speedCheck(), 500, false);
					}
					else {
						pk1.setEnabled(false);
						pk2.setEnabled(false);
						back.setEnabled(false);
						
						turnMenu(Turn.speedCheck(), 500, false);
					}
				}
			}
			
		});
		
		pk2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setChoice(PokeMove.switchPokemon);
				if (p == Player.p1) {
					chosenPosition1 = p.getOtherPosition(1);
					if ((int)p.getCurrentPokemon().getHp()<=0) {
						pk1.setEnabled(false);
						pk2.setEnabled(false);
						back.setEnabled(false);
						
						Player.p2.setChoice(PokeMove.empty);
						turnMenu(Turn.speedCheck(), 500, false);
					}
					else {
						battlePanel.removeAll();
						choiceMenu(Player.p2);
					}
				}
				else {
					chosenPosition2 = p.getOtherPosition(1);
					if ((int)p.getCurrentPokemon().getHp()<=0) {
						pk1.setEnabled(false);
						pk2.setEnabled(false);
						back.setEnabled(false);
						
						Player.p1.setChoice(PokeMove.empty);
						turnMenu(Turn.speedCheck(), 500, false);
					}
					else {
						pk1.setEnabled(false);
						pk2.setEnabled(false);
						back.setEnabled(false);
						
						turnMenu(Turn.speedCheck(), 500, false);
					}
				}
			}
			
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				fightButton.setVisible(true);
				surrenderButton.setVisible(true);
				changePokemonButton.setVisible(true);
				
				moveButton1.setVisible(false);
				moveButton2.setVisible(false);
				moveButton3.setVisible(false);
				moveButton4.setVisible(false);
				back.setVisible(false);
				pk2.setVisible(false);
				pk1.setVisible(false);
				
				mainFrame.revalidate();
				mainFrame.repaint();
			}
		});
		
		moveButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setChoice(p.getCurrentPokemon().getMove1());
				if (p == Player.p1) {
					battlePanel.removeAll();
					choiceMenu(Player.p2);
				}
				else {
					moveButton2.setEnabled(false);
					moveButton1.setEnabled(false);
					moveButton3.setEnabled(false);
					moveButton4.setEnabled(false);
					back.setEnabled(false);
					
					turnMenu(Turn.speedCheck(), 500, false);
				}
			}
		});
		
		moveButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setChoice(p.getCurrentPokemon().getMove2());
				if (p == Player.p1) {
					battlePanel.removeAll();
					choiceMenu(Player.p2);
				}
				else {
					moveButton2.setEnabled(false);
					moveButton1.setEnabled(false);
					moveButton3.setEnabled(false);
					moveButton4.setEnabled(false);
					back.setEnabled(false);
					
					turnMenu(Turn.speedCheck(), 500, false);
				}
			}
		});
		
		moveButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setChoice(p.getCurrentPokemon().getMove3());
				if (p == Player.p1) {
					battlePanel.removeAll();
					choiceMenu(Player.p2);
				}
				else {
					moveButton2.setEnabled(false);
					moveButton1.setEnabled(false);
					moveButton3.setEnabled(false);
					moveButton4.setEnabled(false);
					back.setEnabled(false);
					
					turnMenu(Turn.speedCheck(), 500, false);
				}
			}
		});
		
		moveButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setChoice(p.getCurrentPokemon().getMove4());
				if (p == Player.p1) {
					battlePanel.removeAll();
					choiceMenu(Player.p2);
				}
				else {
					moveButton2.setEnabled(false);
					moveButton1.setEnabled(false);
					moveButton3.setEnabled(false);
					moveButton4.setEnabled(false);
					back.setEnabled(false);
					
					turnMenu(Turn.speedCheck(), 500, false);
				}
			}
		});
		
		surrenderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				surrenderButton.setEnabled(false);
				fightButton.setEnabled(false);
				changePokemonButton.setEnabled(false);
				Player otherP = Player.reversePlayer(p);
				
				if (battleCounter!=3) {
					p.setLoses(p.getLoses()+1);
					otherP.setVictories(otherP.getVictories()+1);
					Pokemon.resetTeam(p);
					finishMenu("match", otherP, p);
				}	
				
				else {
					int gamePlayed1 = Player.p1.getGamesPlayed();
					int gamePlayed2 = Player.p2.getGamesPlayed();
					Player.p1.setGamesPlayed(gamePlayed1+1);
					Player.p2.setGamesPlayed(gamePlayed2+1);
					
					JLabel loseLabel = new JLabel ("You Lose");
					JLabel winLabel = new JLabel ("You Win!");
					winLabel.setFont(applyPokemonFont(70f));
					winLabel.setForeground(Color.GREEN);
					loseLabel.setFont(applyPokemonFont(70f));
					loseLabel.setForeground(Color.RED);
					
					if (Player.p2.getLoses()==2) {
						int gameLost = Player.p2.getGamesLost();
						int gameWon = Player.p1.getGamesWon();	
						
						p.setGamesLost(gameLost+1);
						p.setGamesPlayed(gamePlayed1+1);
						otherP.setGamesWon(gameWon+1);
						otherP.setGamesPlayed(gamePlayed2+1);
						
						LoadNSave.save(p);
						LoadNSave.save(otherP);
						
						gbc.insets = new Insets(50, 420, 0, 0);
						battlePanel.add(loseLabel, gbc);
						gbc.insets = new Insets(450, 0, 0, 500);
						battlePanel.add(winLabel, gbc);
						
						updateBackground(battleBackgroundLabel, battlePanel);
						finishMenu("end", Player.p1, Player.p2);
					}
					
					else if (Player.p1.getLoses()==2){
						
						int gameLost = Player.p1.getGamesLost();
						int gameWon = Player.p2.getGamesWon();	
						
						Player.p1.setGamesLost(gameLost+1);
						Player.p2.setGamesWon(gameWon+1);
						
						LoadNSave.save(Player.p1);
						LoadNSave.save(Player.p2);
						
						gbc.insets = new Insets(450, 0, 0, 500);
						battlePanel.add(loseLabel, gbc);
						
						gbc.insets = new Insets(50, 420, 0, 0);
						battlePanel.add(winLabel, gbc);
						
						updateBackground(battleBackgroundLabel, battlePanel);
						finishMenu("end", Player.p2, Player.p1);
					}
				}
			}
		});
			
		updateSprites();
		updateBackground(battleBackgroundLabel, battlePanel);

		mainFrame.add(battlePanel);
		mainFrame.revalidate();
		mainFrame.repaint();
		
		
	}
	
	public void finishMenu(String finishType, Player winner, Player loser) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets=new Insets(0,0,300,0);
		JPanel finishPanel = new JPanel(new GridBagLayout());
		JLabel label = new JLabel();
		Timer t = new Timer();
		TimerTask tsk = new TimerTask() {
			int counter = 3;
			@Override
			public void run() {
				if (counter==3) {
					counter--;
				}
				else if (counter==2) {
					if (finishType=="match") {
						mainFrame.remove(battlePanel);
						battlePanel.removeAll();
						label.setText("Match "+battleCounter+" finished. "+winner.getNickname()+" win!");
						label.setFont(applyPokemonFont(100f));
						label.setForeground(Color.BLACK);
						finishPanel.add(label, gbc);
						updateBackground(transitionBackgroundLabel, finishPanel);
						mainFrame.add(finishPanel);
						mainFrame.revalidate();
						mainFrame.repaint();
						battleCounter+=1;
						counter--;
					}
					else if (finishType=="end") {
						
					JButton restartGameButton = new JButton("Restart game");
					restartGameButton.setFont(applyPokemonFont(40f));
					restartGameButton.setBackground(Color.WHITE);
					gbc.insets = new Insets(200,0,0,500);
					restartGameButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							 Pokemon.resetTeam(Player.p1);
							 Pokemon.resetTeam(Player.p2);
							 battleCounter=1;
							 finishPanel.removeAll();
							 mainFrame.remove(finishPanel);
							 choiceMenu(Player.p1);
						}
					});
					finishPanel.add(restartGameButton, gbc);
					
					JButton returnButton = new JButton("Return to main menu");
					returnButton.setFont(applyPokemonFont(40f));
					returnButton.setBackground(Color.WHITE);
					gbc.insets = new Insets(400, 0, 0, 500);
					returnButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							finishPanel.removeAll();
							mainFrame.remove(finishPanel);
							startMenu();
						}
					});
					finishPanel.add(returnButton, gbc);
					
						mainFrame.remove(battlePanel);
						battlePanel.removeAll();
						label.setText("Battle finished.     "+winner.getNickname()+" win! "+loser.getNickname()+" lose...");
						label.setFont(applyPokemonFont(70f));
						label.setForeground(Color.BLACK);
						gbc.insets=new Insets(0,0,300,0);
						finishPanel.add(label, gbc);
						updateBackground(transitionBackgroundLabel, finishPanel);
						mainFrame.add(finishPanel);
						mainFrame.revalidate();
						mainFrame.repaint();
						counter--;
					}
				}
				else if (counter==1) {
					if (finishType=="match") {
						mainFrame.remove(finishPanel);
						choiceMenu(Player.p1);
						counter--;
					}
					else if (finishType=="end") {
						
						counter--;
					}
				}
			}
		};
		t.scheduleAtFixedRate(tsk, 0, 2000);
	}
	
	

	public void turnMenu(Player p, int position, boolean stop) {
		String moveCategory = p.getChoice().getCategory();
		Player otherP = Player.reversePlayer(p);

		switch(moveCategory) {
			
		case("special"): case("physical"): 
			Turn.attack(p);
			Timer t1 = new Timer();
			TimerTask task1 = new TimerTask() {
				int counter = 3;
				
				@Override
				public void run() {
					
					if (counter==3) {
						JLabel label1 = new JLabel("<html>"+p.getNickname()+"'s "+p.getCurrentPokemon().getName()+" uses "+p.getChoice().getName()+"<br>"+Turn.checkType(p.getChoice(), otherP.getCurrentPokemon())+"</html>");
						label1.setFont(applyPokemonFont(30f));
						label1.setForeground(Color.BLACK);
						gbc.insets = new Insets(0, 0, position, 800);
						battlePanel.add(label1, gbc);
						updateBackground(battleBackgroundLabel, battlePanel);
						counter--;
					}
					
					else if (counter==2) {
						JLabel label2 = new JLabel("<html>"+otherP.getNickname()+"'s "+otherP.getCurrentPokemon().getName()+" hp are now "+(int)otherP.getCurrentPokemon().getHp()+"</html>");
						label2.setFont(applyPokemonFont(30f));
						label2.setForeground(Color.BLACK);
						gbc.insets = new Insets(0, 0, position-110, 800);
						battlePanel.add(label2, gbc);
						
						try {
							updatePlayerInfo(otherP);
						} catch (FontFormatException | IOException e) {
							e.printStackTrace();
						}
						
						updateBackground(battleBackgroundLabel, battlePanel);
						counter--;
					}
					
					else if (counter==1) {
						if ((int)otherP.getCurrentPokemon().getHp()<=0) {
							JLabel loseLabel = new JLabel (otherP.getCurrentPokemon().getName()+" is dead!");
							loseLabel.setFont(applyPokemonFont(70f));
							loseLabel.setForeground(Color.RED);
							if (otherP==Player.p2) {
								gbc.insets = new Insets(50, 420, 0, 0);
								gbc.gridx = 0;
								gbc.gridy = 0;
								battlePanel.add(loseLabel, gbc);
								updateBackground(battleBackgroundLabel, battlePanel);
								counter--;
							}
							else {
								gbc.insets = new Insets(450, 0, 0, 500);
								gbc.gridx = 0;
								gbc.gridy = 0;
								battlePanel.add(loseLabel, gbc);
								updateBackground(battleBackgroundLabel, battlePanel);
								counter--;
							}
						}
						
						else if (stop==true) {
							battlePanel.removeAll();
							updateBackground(battleBackgroundLabel, battlePanel);
							counter--;
							counter--;
							choiceMenu(Player.p1);
						}
						else {
							counter--;
							counter--;
							turnMenu(Player.reversePlayer(p), 300, true);
						}	
					}
					
					else if (counter==0) {
					battlePanel.removeAll();
					updateBackground(battleBackgroundLabel, battlePanel);
					if (otherP==Player.p2) {
						choiceMenu(Player.p2);
					}
					else {
						choiceMenu(Player.p1);
					}
					counter--;
					}
				}
			};
			t1.scheduleAtFixedRate(task1, 0, 2500);
			break;
			
		case("status"):
			Turn.changeStatus(p);
			Timer t2 = new Timer();
			TimerTask task2 = new TimerTask() {
				int counter = 3;
				
				@Override
				public void run() {
					
					if (counter == 3) {
						JLabel label3 = new JLabel("<html>"+p.getNickname()+"'s "+p.getCurrentPokemon().getName()+" uses "+p.getChoice().getName()+"</html>");
						label3.setFont(applyPokemonFont(30f));
						label3.setForeground(Color.BLACK);
						gbc.insets = new Insets(0, 0, position, 800);
						battlePanel.add(label3, gbc);
						updateBackground(battleBackgroundLabel, battlePanel);
						counter--;
					}
					
					else if (counter==2) {
						JLabel label4 = new JLabel("<html>"+otherP.getNickname()+"'s "+otherP.getCurrentPokemon().getName()+" "+p.getChoice().getStatModifier()+" has changed by "+p.getChoice().getStatSign()+"1</html>");
						label4.setFont(applyPokemonFont(30f));
						label4.setForeground(Color.BLACK);
						gbc.insets = new Insets(0, 0, position-50, 800);
						battlePanel.add(label4, gbc);
						
						try {
							updatePlayerInfo(otherP);
						} catch (FontFormatException | IOException e) {
							e.printStackTrace();
						}
						
						updateBackground(battleBackgroundLabel, battlePanel);
						counter--;
					}
					
					else if (counter==1) {
						if (stop==true) {
							battlePanel.removeAll();
							updateBackground(battleBackgroundLabel, battlePanel);
							choiceMenu(Player.p1);	
						}
						else {
							turnMenu(Player.reversePlayer(p), 350, true);
						}
						counter--;
					}
				}
			};
			t2.scheduleAtFixedRate(task2, 0, 2500);
			break;
			
		case("switch"):
			Timer t3 = new Timer();
			TimerTask task3 = new TimerTask() {
				int counter = 3;
				
				@Override
				public void run() {
					
					if (counter==3) {
						if (p==Player.p1) {
							JLabel label5 = new JLabel("<html>"+p.getNickname()+"'s "+p.getCurrentPokemon().getName()+" switched to "+p.getPokemon(chosenPosition1).getName()+"!</html>");
							label5.setFont(applyPokemonFont(30f));
							label5.setForeground(Color.BLACK);
							gbc.insets = new Insets(0, 0, position, 800);
							battlePanel.add(label5, gbc);
							updateBackground(battleBackgroundLabel, battlePanel);
							counter--;
						}
						
						else {
							JLabel label5 = new JLabel("<html>"+p.getNickname()+"'s "+p.getCurrentPokemon().getName()+" switched to "+p.getPokemon(chosenPosition2).getName()+"!</html>");
							label5.setFont(applyPokemonFont(30f));
							label5.setForeground(Color.BLACK);
							gbc.insets = new Insets(0, 0, position, 800);
							battlePanel.add(label5, gbc);
							updateBackground(battleBackgroundLabel, battlePanel);
							counter--;
						}
					}
					
					else if (counter==2) {
						if (p==Player.p1) {
							battlePanel.remove(pokemon1[p.getCurrentPosition()]);
							p.setCurrentPokemon(chosenPosition1);
						}
						else {
							battlePanel.remove(pokemon2[p.getCurrentPosition()]);
							p.setCurrentPokemon(chosenPosition2);
						}
						p.setOtherPositions(p);
						
						try {
							updatePlayerInfo(p);
						} catch (FontFormatException | IOException e) {
							e.printStackTrace();
						}
						
						updateSprites();
						updateBackground(battleBackgroundLabel, battlePanel);
						counter--;
					}
					
					else if (counter==1) {
						if (stop==true) {
						battlePanel.removeAll();
						updateBackground(battleBackgroundLabel, battlePanel);
						choiceMenu(Player.p1);
						}
						else {
						turnMenu(otherP, 350, true);
						}
						counter--;
					}
				}
			};
			t3.scheduleAtFixedRate(task3, 0, 2500);
			break;
		
		case("empty"):
			battlePanel.removeAll();
			updateBackground(battleBackgroundLabel, battlePanel);
			choiceMenu(Player.p1);
		break;
		}	
	}

	//UTILITY METHODS
	
	public void updateBackground(JLabel setLabel, JPanel setPanel) {
		gbc.insets = new Insets(0, 0, 0, 0);
		setPanel.add(setLabel, gbc);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void updatePlayerInfo(Player p) throws FontFormatException, IOException {
		if (p==Player.p1) {
			player1Info.setText("<html>"+p.getCurrentPokemon().getName() + "&nbsp;Lv."+(int)p.getCurrentPokemon().getLevel() + "<br>"+(int)p.getCurrentPokemon().getHp() + " HP</html>");
			player1Info.setFont(applyPokemonFont(35f));
			player1Info.setForeground(Color.BLACK);
			gbc.insets = new Insets(100, 0, 0, 800);
			battlePanel.add(player1Info, gbc);
			
			mainFrame.revalidate();
			mainFrame.repaint();
		}
		else {
			player2Info.setText("<html>"+ p.getCurrentPokemon().getName() + "&nbsp;Lv."+(int)p.getCurrentPokemon().getLevel() + "<br>" + (int)p.getCurrentPokemon().getHp() +" HP</html>");
			player2Info.setFont(applyPokemonFont(35f));
			player2Info.setForeground(Color.BLACK);
			gbc.insets = new Insets(0, 200, 300, 0);
			battlePanel.add(player2Info, gbc);
			
			mainFrame.revalidate();
			mainFrame.repaint();
		}
	}
	
	public Font applyPokemonFont(float size)  {
		try {
			String filepath = getClass().getResource("/fonts/pokemon_fire_red.ttf").getPath(); 
			Font fireRed = Font.createFont(Font.TRUETYPE_FONT, new File(filepath));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fireRed);
			return fireRed.deriveFont(size);
		} catch (FontFormatException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateSprites() {
		gbc.insets = new Insets(280, 0, 0, 500);
		battlePanel.add(pokemon1[Player.p1.getCurrentPosition()], gbc);
		
		gbc.insets = new Insets(0, 420, 100, 0);
		battlePanel.add(pokemon2[Player.p2.getCurrentPosition()], gbc);
	}
	
	public void setSprites() {
		Player p1 = Player.p1;
		Player p2 = Player.p2;
		int i = 0;
		for (i=0; i<3; i++) {
			Pokemon pk1 = p1.getPokemon(i);
			Pokemon pk2 = p2.getPokemon(i);
			ImageIcon img1 = pk1.getBackSprite();
			pokemon1[i].setIcon(img1);
			ImageIcon img2 = pk2.getFrontSprite();
			pokemon2[i].setIcon(img2);
		}
	}
}
