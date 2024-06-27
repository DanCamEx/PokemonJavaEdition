import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoadNSave {
	
	private static File charactersDir = new File("saves/characters");
	private static File[] charactersDirFiles = charactersDir.listFiles();
	
	static File[] getDirFiles() {
		return charactersDirFiles;
	}
	
	
	
	
	public static void save(String characterName) {
		try {
			
			File savedData = new File("saves/characters/"+characterName+".txt");
			 
			if (savedData.createNewFile()) {
				FileWriter scriviBene = new FileWriter(savedData.getPath());
				scriviBene.write("Nickname: "+characterName+"\nGames played: 0\nWins: 0\nLoses: 0");
				scriviBene.close();
				System.out.println("File created!");
				
			}
			else {
				System.out.println("File already exist");
			}
		} catch(IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	
	public static void load() {
		
	}
	
	
	public static boolean checkIfEmpty(String folderPath) {
		File file = new File(folderPath);
		if (file.isDirectory()){
			if (file.list().length > 0) {
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
