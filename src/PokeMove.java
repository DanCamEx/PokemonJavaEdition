
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
	
	
	//Moves List:
	
	//Common:
	static PokeMove tackle = new PokeMove("Tackle", "normal", "physical", 35, 95, "empty", "empty");
	static PokeMove growl = new PokeMove("Growl", "normal", "status", 0, 100, "attack", "-");

	//Bulbasaur:
	static PokeMove vinewhip = new PokeMove("Vine Whip", "grass", "physical", 40, 100, "empty", "empty");
	static PokeMove razorleaf = new PokeMove("Razor Leaf", "grass", "physical", 55, 95, "empty", "empty");
	static PokeMove growth = new PokeMove("Growth", "normal", "status", 0, 100, "special attack", "+");
	static PokeMove seedbomb = new PokeMove("Seed Bomb", "grass", "physical", 80, 100, "empty", "empty");
	static PokeMove takedown = new PokeMove("Take Down", "normal", "physical", 90, 85, "empty", "empty"); //1/4 damage recoil
	static PokeMove sweetscent = new PokeMove("Sweet Scent", "normal", "status", 0, 100, "evasion", "-");
	static PokeMove powerwhip = new PokeMove("Power Whip", "grass", "physical", 120, 85, "empty", "empty");
	static PokeMove solarbeam = new PokeMove("Solar Beam", "grass", "special", 120, 100, "empty", "empty"); //Turn 1) "Bulb. has taken sunlight", Turn 2) Attack.
	
	//Squirtle:
	static PokeMove tailwhip = new PokeMove("TailWhip", "normal", "status", 0, 100, "defense", "-");		
	static PokeMove watergun = new PokeMove("Water Gun", "water", "special", 40, 100, "empty", "empty");
	static PokeMove withdraw = new PokeMove("Withdraw", "water", "status", 0, 100, "defence", "+");
	static PokeMove rapidspin = new PokeMove("Rapid Spin", "normal", "physical", 50, 100, "empty", "empty"); //Remove effects
	static PokeMove bite = new PokeMove("Bite", "dark", "physical", 60, 100, "empty", "empty");
	static PokeMove waterpuls = new PokeMove("Water Pulse", "water", "special", 60, 100, "empty", "empty");
	static PokeMove protect = new PokeMove("Protect", "normal", "status", 0, 100, "empty", "empty"); //Protect from everything (damage included)
	static PokeMove aquatail = new PokeMove("Aqua Tail", "water", "physical", 85, 90, "empty", "empty");
	static PokeMove irondefence = new PokeMove("Iron Defence", "steel", "status", 0, 100, "defence", "++");
	static PokeMove hydropump = new PokeMove("Hydro Pump", "water", "special", 120, 80, "empty", "empty");
	static PokeMove wavecrash = new PokeMove("Wave Crash", "water", "physical", 120, 100, "empty", "empty"); //1/3 recoil

	//Charmender:
	static PokeMove scratch = new PokeMove("Scratch", "normal", "physical", 40, 100, "empty", "empty");		
	static PokeMove ember = new PokeMove("Ember", "fire", "special", 40, 100, "empty", "empty");		
	static PokeMove smokescreen = new PokeMove("Smoke Screen", "normal", "status", 0, 100, "accuracy", "-");		
	static PokeMove dragonbreath = new PokeMove("Dragon Breath", "dragon", "special", 60, 100, "empty", "empty");		
	static PokeMove firefang = new PokeMove("Fire Fang", "fire", "physical", 65, 95, "empty", "empty");		
	static PokeMove slash = new PokeMove("Slash", "normal", "physical", 70, 100, "empty", "empty");		
	static PokeMove flamethrower = new PokeMove("Flamethrower", "fire", "special", 90, 100, "empty", "empty");		
	static PokeMove scaryface = new PokeMove("Scary Face", "normal", "status", 0, 100, "speed", "--");	
	static PokeMove inferno = new PokeMove("Inferno", "fire", "special", 100, 50, "attack", "-");
	static PokeMove flarebits = new PokeMove("Flare Bits", "fire", "physical", 120, 100, "attack", "-");


	//Place holder
	static PokeMove empty = new PokeMove("empty", "empty", "empty", 0, 0, "empty", "empty"); //placeholder
	
	//Switch
	static PokeMove switchPokemon = new PokeMove("switch");
}
