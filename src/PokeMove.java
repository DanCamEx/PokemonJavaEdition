
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
	String getType() {
		return type;
	}
	
	
	//Moves List:
	
	//Bulbasaur:
	static PokeMove vine_whip = new PokeMove("Vine Whip", "grass", "physical", 40, 100, "empty", "empty");
	static PokeMove razorleaf = new PokeMove("Razor Leaf", "grass", "physical", 55, 95, "empty", "empty");
	static PokeMove growth = new PokeMove("Growth", "normal", "status", 0, 100, "special", "+"); //Itself
	static PokeMove solarbeam = new PokeMove("Solar Beam", "grass", "special", 120, 100, "empty", "empty"); //it does it on the second turn
	
	//Squirtle:
	static PokeMove tail_whip = new PokeMove("Tail Whip", "normal", "status", 0, 100, "defense", "-");		
	static PokeMove bubble = new PokeMove("Bubble", "water", "special", 20, 100, "empty", "empty");		
	static PokeMove water_gun = new PokeMove("Water Gun", "water", "special", 40, 100, "empty", "empty");
	static PokeMove bite = new PokeMove("Bite", "normal", "physical", 60, 100, "empty", "empty");
	static PokeMove withdraw = new PokeMove("Withdraw", "water", "status", 0, 100, "defence", "+"); //itself
	static PokeMove skull_bash = new PokeMove("Skull Bash", "normal", "physical", 100, 100, "empty", "empty"); //it does it on the second turn
	static PokeMove hydropump = new PokeMove("Hydro Pump", "water", "special", 120, 80, "empty", "empty");

	//Charmander:
	static PokeMove scratch = new PokeMove("Scratch", "normal", "physical", 40, 100, "empty", "empty");		
	static PokeMove ember = new PokeMove("Ember", "fire", "special", 40, 100, "empty", "empty");	
	static PokeMove leer = new PokeMove("Leer", "normal", "status", 0, 100, "defense", "-");
	static PokeMove rage = new PokeMove("Rage", "normal", "physical", 20, 100, "attack", "+"); //It continues to use this move until he dies. Everytime he uses it his Attack increases.
	static PokeMove slash = new PokeMove("Slash", "normal", "physical", 70, 100, "empty", "empty");		
	static PokeMove flamethrower = new PokeMove("Flamethrower", "fire", "special", 95, 100, "empty", "empty");		
	static PokeMove fire_spin = new PokeMove("Fire Spin", "fire", "physical", 15, 70, "empty", "empty"); //It remains for 5 turn, making his opponnent losing everytime 1/8 of its maximum hp.

	//Bulbasaur and Squirtle
	static PokeMove tackle = new PokeMove("Tackle", "normal", "physical", 35, 95, "empty", "empty");

	//Bulbasaur and Charmander
	static PokeMove growl = new PokeMove("Growl", "normal", "status", 0, 100, "attack", "-");

	//Do nothing
	static PokeMove empty = new PokeMove("empty", "empty", "empty", 0, 0, "empty", "empty");
	
	//Switch
	static PokeMove switchPokemon = new PokeMove("switch");
}
