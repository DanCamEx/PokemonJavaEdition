package pokemonjavaedition;
/**
 * It manages all the info that has a pokemon move in the game.
 */
public class PokeMove {
	
	/**
	 * The characteristics of a typical pokemon move, like his name, his type, category, ecc...
	 */
	private String name, type, category, statModifier, statSign;
	
	/**
	 * The power and accuracy of a pokemon move.
	 */
	private double power, accuracy;
	
	/**
	 * Creates a pokemove with just his category, used for special pokemove objects like the switch.
	 * @param category the category of a move. It can be special, physical, status or of a special type, like switch, or empty.
	 */
	public PokeMove(String category){
		this.category = category;
	}
	
	/**
	 * Create a complete pokemove, with all his principal stats already set.
	 * @param name the name of the move
	 * @param type the type of the move (fire, water, grass ecc...)
	 * @param category the category of the move (physical, special, status ecc...)
	 * @param power the damage that does a move
	 * @param accuracy the chance that a move have to not miss
	 * @param statModifier the stat that a move can modify. It is empty if no stat is influenced.
	 * @param statSign the stat sign, which can be + or -, if the stat is boosted or nerfed. It is strictly correlated to the statModifier.
	 */
	public PokeMove(String name, String type, String category, double power, double accuracy, String statModifier, String statSign){
		this.name = name;
		this.type = type;
		this.category = category;
		this.power = power;
		this.accuracy = accuracy;
		this.statModifier = statModifier;
		this.statSign = statSign;
	}
	
	/**
	 * Gets the name of a pokemon move.
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the category of a pokemon move (physical, status, special, ecc...)
	 * @return
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Gets the power of a pokemon move, which represents its damage.
	 * @return
	 */
	public double getPower() {
		return power;
	}
	
	/**
	 * Gets the stat that is influenced by that move. It can be empty if no stat is influenced.
	 * @return
	 */
	public String getStatModifier() {
		return statModifier;
	}
	
	/**
	 * Gets the stat sign, which can be + or - if the stat modified is boosted or nerfed. Strictly related to the statModifier attribute.
	 * @return
	 * @see #statModifier
	 * @see #getStatModifier()
	 */
	public String getStatSign() {
		return statSign;
	}
	
	/**
	 * Gets the type of a pokemon move (fire, water, grass or normal).
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Gets the accuracy of a pokemon move, which represents his chance to be effective in battle.
	 * @return
	 */
	public double getAccuracy() {
		return accuracy;
	}
	
	//Moves List
	
	//Bulbasaur
	static PokeMove vine_whip = new PokeMove("Vine Whip", "grass", "physical", 40, 100, "empty", "empty");
	static PokeMove razorleaf = new PokeMove("Razor Leaf", "grass", "physical", 55, 95, "empty", "empty");
	static PokeMove growth = new PokeMove("Growth", "normal", "status", 0, 100, "special", "+"); 
	static PokeMove solarbeam = new PokeMove("Solar Beam", "grass", "special", 120, 100, "empty", "empty");
	
	//Squirtle
	static PokeMove tail_whip = new PokeMove("Tail Whip", "normal", "status", 0, 100, "defense", "-");		
	static PokeMove bubble = new PokeMove("Bubble", "water", "special", 20, 100, "empty", "empty");		
	static PokeMove water_gun = new PokeMove("Water Gun", "water", "special", 40, 100, "empty", "empty");
	static PokeMove bite = new PokeMove("Bite", "normal", "physical", 60, 100, "empty", "empty");
	static PokeMove withdraw = new PokeMove("Withdraw", "water", "status", 0, 100, "defence", "+"); 
	static PokeMove skull_bash = new PokeMove("Skull Bash", "normal", "physical", 100, 100, "empty", "empty"); 
	static PokeMove hydropump = new PokeMove("Hydro Pump", "water", "special", 120, 80, "empty", "empty");

	//Charmander
	static PokeMove scratch = new PokeMove("Scratch", "normal", "physical", 40, 100, "empty", "empty");		
	static PokeMove ember = new PokeMove("Ember", "fire", "special", 40, 100, "empty", "empty");	
	static PokeMove leer = new PokeMove("Leer", "normal", "status", 0, 100, "defense", "-");
	static PokeMove rage = new PokeMove("Rage", "normal", "physical", 20, 100, "attack", "+"); 
	static PokeMove slash = new PokeMove("Slash", "normal", "physical", 70, 100, "empty", "empty");		
	static PokeMove flamethrower = new PokeMove("Flamethrower", "fire", "special", 95, 100, "empty", "empty");		
	static PokeMove fire_spin = new PokeMove("Fire Spin", "fire", "physical", 15, 70, "empty", "empty"); 

	//Bulbasaur and Squirtle
	static PokeMove tackle = new PokeMove("Tackle", "normal", "physical", 35, 95, "empty", "empty");

	//Bulbasaur and Charmander
	static PokeMove growl = new PokeMove("Growl", "normal", "status", 0, 100, "attack", "-");

	//Do nothing
	static PokeMove empty = new PokeMove("empty", "empty", "empty", 0, 0,"empty", "empty");
	
	//Switch
	static PokeMove switchPokemon = new PokeMove("switch");
}
