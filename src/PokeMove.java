
public class PokeMove {
	
	//Attributes
	private String name, type, category, statModifier, statSign;
	private double power, accuracy;
	
	PokeMove(String category){
		this.category = category;
	}
	
	PokeMove(String name, String type, String category, double power, double accuracy, String statModifier, String statSign){
		this.name = name;
		this.type = type;
		this.category = category;
		this.power = power;
		this.accuracy = accuracy;
		this.statModifier = statModifier;
		this.statSign = statSign;
	}
	
	//Getters
	String getName() {
		return name;
	}
	String getCategory() {
		return category;
	}
	double getPower() {
		return power;
	}
	String getStatModifier() {
		return statModifier;
	}
	String getStatSign() {
		return statSign;
	}
	
	
	//Moves List
	static PokeMove tackle = new PokeMove("Tackle", "normal", "physical", 35, 95, "empty", "empty");
	static PokeMove growl = new PokeMove("Growl", "normal", "status", 0, 100, "attack", "-");				
	static PokeMove tailwhip = new PokeMove("TailWhip", "normal", "status", 0, 100, "defense", "-");		
	static PokeMove scratch = new PokeMove("Scratch", "normal", "physical", 40, 100, "empty", "empty");		
	static PokeMove empty = new PokeMove("empty", "empty", "empty", 0, 0, "empty", "empty"); //placeholder
	
	static PokeMove switchPokemon = new PokeMove("switch");
}
