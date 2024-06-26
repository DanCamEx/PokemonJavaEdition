import java.io.File;
import java.io.IOException;

public class LoadNSave {
	
	public static void save(Player p) {
		try {
			
			File savedData = new File("saves/characters/"+p.getNickname()+".txt");
			
			 
			if (savedData.createNewFile()) {
				System.out.println("File created");
				
				
				
				
				
				
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
			System.out.println("this is not a directory");
			return false;
		}
	}
}
