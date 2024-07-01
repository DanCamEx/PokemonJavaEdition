package pokemonjavaedition;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * It manages the saving and loading system of the game. The saving files are created with the .txt extension, as they only need to contain 4 info of the character: his name and the games played, won and lost.
 */
public class LoadNSave {
	
	/**
	 * The directory which contains the saves of the game.
	 */
	private static File charactersDir = new File("saves/");
	
	/**
	 * The list of all the files contained in the directory charactersDir.
	 * @see #charactersDir
	 */
	private static File[] charactersDirFiles = charactersDir.listFiles();
	
	/**
	 * Gets all the saves of the game.
	 * @return an array of files, with each of its elements representing a different character's save in the game.
	 */
	public static File[] getDirFiles() {
		return charactersDirFiles;
	}
	
	/**
	 * It creates a new save with the .txt extension naming it with the nickname of the character choosen while creating it form the corresponding menu.
	 * The save already contains all the info with a default value. In this case, 0.
	 * @param characterName the name of the save and also the nickname of the profile.
	 */
	public static void create(String characterName) {
		try {
			File createdData = new File("saves/"+characterName+".txt");
			FileWriter scriviBene = new FileWriter(createdData.getPath());
			scriviBene.write("Nickname: "+characterName+"\nGames played: 0\nWins: 0\nLoses: 0");
			scriviBene.close();
			System.out.println("File created!");

		} catch(IOException e) {
			System.out.println("There is an error somewhere :)");
			e.printStackTrace();
		}
	}
	
	/**
	 * It rewrites the file named as the nickname associated with the player, adding all the new info acquired when a battle ends, like the fact that now the profile has win a game, lost a game, or just played it.
	 * @param p the player of which nickname is taken to find which file have to be rewritten.
	 */
	public static void save(Player p) {
		try {
			File savedData = new File("saves/"+p.getNickname()+".txt");
			FileWriter scriviBene2 = new FileWriter(savedData.getPath());
			
				scriviBene2.write("Nickname: "+p.getNickname()+"\nGames played: "+p.getGamesPlayed()+"\nWins: "+p.getGamesWon()+"\nLoses: "+p.getGamesLost());
				scriviBene2.close();
				System.out.println("File saved!");
				
		} catch(IOException e) {
			System.out.println("Error! File not found or failed to save");
			e.printStackTrace();
		}
	}
	
	/**
	 * It sets all the parameters in a save file to the player 1 or player 2, reading the file info needed to be set. This info are then set as player attributes.
	 * @param character the name of the file to be read
	 * @param p the player where you want to set all the info of a save
	 * @throws IOException if something goes wrong :(
	 */
	public static void load(String character, Player p) throws IOException {
		File loadedData = new File("saves/"+character+".txt");
		FileReader leggiBene = new FileReader(loadedData.getPath());
		String path = "";
		int data = leggiBene.read();
		while(data!=-1) {
			path = path+(char)data;
			data=leggiBene.read();
		}
		leggiBene.close();
		String short_path = path.substring(11+character.length());
		char[] charArray = short_path.toCharArray();
		int index = 0;
		String[] gamesCounters = {"", "", ""};
		for (char c : charArray) {
			try {
				int i = Integer.valueOf(String.valueOf(c));
				
				gamesCounters[index]+=c;

			} catch (NumberFormatException n) {
				if (gamesCounters[0]!="") {
					index=1;
				}
				if (gamesCounters[1]!="") {
					index=2;
				}
			}
		}
		p.setNickname(character);
		try {
			p.setGamesPlayed(Integer.valueOf(short_path.substring(14, 14+gamesCounters[0].length())));
			p.setGamesWon(Integer.valueOf(short_path.substring(21+gamesCounters[0].length(), 21+gamesCounters[0].length()+gamesCounters[1].length())));
			p.setGamesLost(Integer.valueOf(short_path.substring(29+gamesCounters[0].length()+gamesCounters[1].length())));
		} catch (NumberFormatException n) {
			System.out.println("Index sbagliati");
		}
	}
	
	public static String read(String character) throws IOException {
		File loadedData = new File("saves/"+character+".txt");
		FileReader leggiBene = new FileReader(loadedData.getPath());
		String path = "<html>";
		int data = leggiBene.read();
		while(data!=-1) {
			if ((char)data=='\n') {
				path+="<br>";
			}
			path = path+(char)data;
			data=leggiBene.read();
		}
		leggiBene.close();
		path+="</html>";
		return path;
	}
	
	public static boolean checkIfLong2(String folderPath) {
		File file = new File(folderPath);
		if (file.isDirectory()){
			if (file.list().length < 2) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			System.out.println(folderPath+" is not a directory path");
			return false;
		}
	}
}
