package pokemonjavaedition;
import javax.swing.ImageIcon;
/**
 * It creates an instance of a pokemon, which can be without attributes, if you just need to initialize one, or with different stats describing its characteristics.
 */
public class Pokemon {
	
	/**
	 * The front/back sprite image of a pokemon
	 */
	private ImageIcon frontSprite, backSprite;
	
	/**
	 * The name and type of a pokemon.
	 */
	private String name, type;
	
	/**
	 * An array containing the stages of a pokemon. Every position represents the stage of a stat. The order is (attack, defense, special, speed). 
	 * The default value is 0, which mean that the stat is still unmodified.
	 */
	private double[] stages = new double[4];
	
	/**
	 * An array with all the main stats of a pokemon, from its level to its speed.
	 */
	private double[] stats = new double[6];
	private PokeMove[] moveSet = new PokeMove[4];
	
	/**
	 * It creates an empty pokemon, useful if you want to just initialize it without giving it any information.
	 */
	Pokemon() {
		
	}
	
	/**
	 * It creates a full built pokemon, with all its characteristics to make it works.
	 * @param name the name of the pokemon
	 * @param type the type of the pokemon
	 * @param moveSet an arry with all his moves
	 * @param stats its main stats
	 * @param stages the stages of its attack, defense, special and speed stats in this specified order
	 * @param frontSprite its front sprite image
	 * @param backSprite its back sprite image
	 */
	Pokemon(String name, String type, PokeMove[] moveSet, double[] stats, double[] stages, ImageIcon frontSprite, ImageIcon backSprite){
		this.name = name;
		this.type = type;
		this.moveSet = moveSet;
		this.stats = stats;
		this.stages = stages;
		this.frontSprite = frontSprite;
		this.backSprite = backSprite;
	}
	
	/**
	 * Gets the name of the pokemon.
	 * @return a string with its name
	 */
	String getName(){
		return name;
	}
	
	/**
	 * Gets the level of the pokemon.
	 * @return a double value, which is its level
	 */
	double getLevel() {
		return stats[0];
	}
	
	/**
	 * Gets the hp of a pokemon.
	 * @return a double value, which is its hp
	 */
	double getHp() {
		return stats[1];
	}
	
	/**
	 * Gets the attack of a pokemon.
	 * @return a double value, which is its attack
	 */
	double getAttack() {
		return stats[2];
	}
	
	/**
	 * Gets the defense of a pokemon.
	 * @return a double value, which is its defense
	 */
	double getDefense() {
		return stats[3];
	}
	
	/**
	 * Gets the speed of a pokemon.
	 * @return a double value, which is its speed
	 */
	double getSpeed() {
		return stats[4];
	}
	
	/**
	 * Gets the special stat of a pokemon.
	 * @return a double value, which is its special stat
	 */
	double getSpecial() {
		return stats[5];
	}
	
	/**
	 * Gets the attack stage of a pokemon.
	 * @return a double value, which is its attack stage (default is 0)
	 */
	double getAttackStage() {
		return stages[0];
	}
	
	/**
	 * Gets the defense stage of a pokemon.
	 * @return a double value, which is its defense stage (default is 0)
	 */
	double getDefenseStage() {
		return stages[1];
	}
	
	/**
	 * Gets the special stage of a pokemon.
	 * @return a double value, which is its special stage (default is 0)
	 */
	double getSpecialStage() {
		return stages[2];
	}
	
	/**
	 * Gets the speed stage of a pokemon.
	 * @return a double value, which is its speed stage (default is 0)
	 */
	double getSpeedStage() {
		return stages[3];
	}
	
	/**
	 * Gets the first move of a pokemon.
	 * @return a pokemove, which is the first move
	 */
	PokeMove getMove1() {
		return moveSet[0];
	}
	
	/**
	 * Gets the second move of a pokemon.
	 * @return a pokemove, which is the second move in the array of the pokemon moves
	 */
	PokeMove getMove2() {
		return moveSet[1];	
	}
	
	/**
	 * Gets the third move of a pokemon.
	 * @return a pokemove, which is the third move in the array of the pokemon moves
	 */
	PokeMove getMove3() {
		return moveSet[2];
	}
	
	/**
	 * Gets the fourth move of a pokemon.
	 * @return a pokemove, which is the fourth move in the array of the pokemon moves
	 */
	PokeMove getMove4() {
		return moveSet[3];
	}
	
	/**
	 * Gets the back sprite image of the pokemon.
	 * @return an imageIcon object, which is its back sprite
	 */
	ImageIcon getBackSprite() {
		return backSprite;
	}
	
	/**
	 * Gets the front sprite image of the pokemon.
	 * @return an imageIcon object, which is its front sprite
	 */
	ImageIcon getFrontSprite() {
		return frontSprite;
	}
	
	/**
	 * Gets the type of the pokemon
	 * @return a string which represents the type of the pokemon (fire, water, grass ecc...)
	 */
	String getType() {
		return type;
	}
	
	/**
	 * Sets the hp of a pokemon to a new value
	 * @param hp the new double value 
	 */
	public void setHp(double hp) {
		this.stats[1] = hp;
	}
	
	/**
	 * It makes one of the stages in the array stages of a pokemon to go -1 or +1 or remain unmodified if it is already at +6 or -6, which is the max boost/nerf that a stat can receive in pokemon games.
	 * @param sign it can be + or -, if the stage has to be increased or decreased
	 * @param stat the stat of which stage is increased or decreased.
	 */
	public void changeStage(String sign, int stat) {
		if (sign=="-") {
			if (this.stages[stat] == -6) {
				this.stages[stat] = -6;
			}
			else {
				this.stages[stat] -= 1;
			}
		}
		else if (sign=="+") {
			if (this.stages[stat] == -6)
			this.stages[stat] += 1;
		}
	}
	
	/**
	 * It creates a pokemon by searching it in the list created inside. 
	 * @param pokemonName the pokemon name that needs to be created
	 * @return the pokemon based on the string written
	 */
	public static Pokemon createPokemon(String pokemonName) {
		
		Pokemon[] pokemonList = {
				
				new Pokemon("Bulbasaur", "grass", new PokeMove[]{PokeMove.vine_whip, PokeMove.growl, PokeMove.razorleaf, PokeMove.tackle}, 
						new double[]{5, 19.5, 14.9, 14.9, 16.5, 14.5}, new double[]{0, 0, 0, 0}, 
						new ImageIcon(JPokeBattle.class.getResource("/images/bulbasaurFRONT.gif")), 
						new ImageIcon(JPokeBattle.class.getResource("/images/bulbasaurBACK.gif"))),	
				
				
				new Pokemon("Charmander", "fire", new PokeMove[] {PokeMove.ember, PokeMove.growl, PokeMove.scratch, PokeMove.flamethrower}, 
						new double[]{5, 18.9, 15.2, 14.3, 15, 16.5}, new double[]{0, 0, 0, 0}, 
						new ImageIcon(JPokeBattle.class.getResource("/images/charmanderFRONT.gif")), 
						new ImageIcon(JPokeBattle.class.getResource("/images/charmanderBACK.gif"))),
				
				new Pokemon("Squirtle", "water", new PokeMove[] {PokeMove.bubble, PokeMove.tail_whip, PokeMove.bite, PokeMove.water_gun}, 
						new double[]{5, 19.4, 14.8, 16.5, 15, 14.3}, new double[] {0, 0, 0, 0}, 
						new ImageIcon(JPokeBattle.class.getResource("/images/squirtleFRONT.gif")), 
						new ImageIcon(JPokeBattle.class.getResource("/images/squirtleBACK.gif")))
				
		};
		
		for (int i=0; i<3; i++) {
			if (pokemonList[i].getName() == pokemonName) {
				return pokemonList[i];
			} 
		}
		return pokemonList[0];
	}
	
	/**
	 * It checks if the move is special or physical, useful especially when attacking to see which stat needs to be taken for the calculation.
	 * @param pokemon
	 * @param move
	 * @return
	 */
	public static double findAttackStat(Pokemon pokemon, PokeMove move) {
		if (move.getCategory()=="special") {
			return pokemon.getSpecial();
		}
		else if (move.getCategory()=="physical") {
			return pokemon.getAttack();
		}
		else {
			return 0;
		}
	}
	
	/**
	 * It resets the entire pokemon team of a player, restoring its stages, stats and positions.
	 * @param p
	 */
	public static void resetTeam(Player p) {
		int index = 0;
		for (Pokemon pk : p.getPokemonSquad()) {
			p.setPokemonSquad(pk.getName(), index);
			index++;
		}
		p.setCurrentPokemon(0);
		p.setOtherPositions(p);
		
	}
}