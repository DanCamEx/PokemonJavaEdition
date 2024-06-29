import javax.swing.ImageIcon;

public class Pokemon {
	
	private ImageIcon frontSprite, backSprite;
	private String name, type;
	private double[] stages = new double[4];
	private double[] stats = new double[6];
	private PokeMove[] moveSet = new PokeMove[4];
	
	Pokemon() {
		
	}
	Pokemon(String name, String type, PokeMove[] moveSet, double[] stats, double[] stages, ImageIcon frontSprite, ImageIcon backSprite){
		this.name = name;
		this.type = type;
		this.moveSet = moveSet;
		this.stats = stats;
		this.stages = stages;
		this.frontSprite = frontSprite;
		this.backSprite = backSprite;
	}
	
	String getName(){
		return name;
	}
	
	double getLevel() {
		return stats[0];
	}
	
	double getHp() {
		return stats[1];
	}
	
	double getAttack() {
		return stats[2];
	}
	
	double getDefense() {
		return stats[3];
	}
	
	double getSpeed() {
		return stats[4];
	}
	
	double getSpecial() {
		return stats[5];
	}
	
	double getAttackStage() {
		return stages[0];
	}
	
	double getDefenseStage() {
		return stages[1];
	}
	
	double getSpecialStage() {
		return stages[2];
	}
	
	double getSpeedStage() {
		return stages[3];
	}

	PokeMove getMove1() {
		return moveSet[0];
	}
	PokeMove getMove2() {
		return moveSet[1];	
	}
	PokeMove getMove3() {
		return moveSet[2];
	}
	PokeMove getMove4() {
		return moveSet[3];
	}
	ImageIcon getBackSprite() {
		return backSprite;
	}
	ImageIcon getFrontSprite() {
		return frontSprite;
	}
	
	String getType() {
		return type;
	}
	
	public void setHp(double hp) {
		this.stats[1] = hp;
	}
	
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
	
	public static Pokemon createPokemon(String pokemonName) {
		
		Pokemon[] pokemonList = {
				
				new Pokemon("Bulbasaur", "grass", new PokeMove[]{PokeMove.vine_whip, PokeMove.growl, PokeMove.razorleaf, PokeMove.tackle}, 
						new double[]{5, 19.5, 14.9, 14.9, 16.5, 14.5}, new double[]{0, 0, 0, 0}, 
						new ImageIcon(Pokemon.class.getResource("images/bulbasaurFRONT.gif")), 
						new ImageIcon(Pokemon.class.getResource("images/bulbasaurBACK.gif"))),	
				
				
				new Pokemon("Charmander", "fire", new PokeMove[] {PokeMove.ember, PokeMove.growl, PokeMove.scratch, PokeMove.flamethrower}, 
						new double[]{5, 18.9, 15.2, 14.3, 15, 16.5}, new double[]{0, 0, 0, 0}, 
						new ImageIcon(Pokemon.class.getResource("images/charmanderFRONT.gif")), 
						new ImageIcon(Pokemon.class.getResource("images/charmanderBACK.gif"))),
				
				new Pokemon("Squirtle", "water", new PokeMove[] {PokeMove.bubble, PokeMove.tail_whip, PokeMove.bite, PokeMove.water_gun}, 
						new double[]{5, 19.4, 14.8, 16.5, 15, 14.3}, new double[] {0, 0, 0, 0}, 
						new ImageIcon(Pokemon.class.getResource("images/squirtleFRONT.gif")), 
						new ImageIcon(Pokemon.class.getResource("images/squirtleBACK.gif")))
				
		};
		
		for (int i=0; i<3; i++) {
			if (pokemonList[i].getName() == pokemonName) {
				return pokemonList[i];
			} 
		}
		return pokemonList[0];
	}
	
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