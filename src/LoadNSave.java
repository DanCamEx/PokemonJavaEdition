import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoadNSave {
	
	private static File charactersDir = new File("saves/");
	private static File[] charactersDirFiles = charactersDir.listFiles();
	
	public static File[] getDirFiles() {
		return charactersDirFiles;
	}
	
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
