package pokemonjavaedition;
/**
 * The main class of the game. It simply act as an initializer of the game, creating a MainMenu session, the actual core of the game.
 */
public class JPokeBattle {
	
	public static void main(String[] args) {
		
		try {
			MainMenu Session = new MainMenu();
			Session.startMenu();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
