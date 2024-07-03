package pokemonjavaedition;
import java.util.Random;
/**
 * It manages all the calculation and checks that has to be done during a battle turn or before starting it, like the damage done, which pokemon is the faster ecc...
 */
public class Turn {
	
	/**
	 * It check which pokemon is faster, returning then the "faster" player between the two.
	 * If the move choosen is switch, the player has a priority, 'cause in pokemon if a player change a pokemon, it acts as the first in every case.
	 * @return
	 */
	public static Player speedCheck() {
		if (Player.p1.getChoice().getCategory()=="switch") {
			return(Player.p1);
		}
		else if (Player.p2.getChoice().getCategory()=="switch") {
			return(Player.p2);
		}
		else if (Player.p1.getCurrentPokemon().getSpeed() > Player.p2.getCurrentPokemon().getSpeed()) {
			return(Player.p1);
		}
		else if (Player.p1.getCurrentPokemon().getSpeed() < Player.p2.getCurrentPokemon().getSpeed()) {
			return(Player.p2);
		}
		else {
			Random i = new Random();
			boolean j = i.nextBoolean();
			if (j==true) {
				return(Player.p1);
			}
			else {
				return(Player.p2);
			}
		}
	}
	
	/**
	 * It calculates the total damage that a player's pokemon does against the enemy. 
	 * It also check if a move is supereffective using the checkType() method and if a stat needs to be boosted or nerfed using the checkStage() method.
	 * @param p the player who will use his current pokemon to attack the other player.
	 */
	public static void attack(Player p) {
		
		Player otherP = Player.reversePlayer(p);
		
		double modifiedDamage;
		double modifiedDefense;
		
		if (p.getChoice().getCategory()=="special") {
			modifiedDamage = checkStage(p.getCurrentPokemon().getSpecial(), p.getCurrentPokemon().getSpecialStage());
			modifiedDefense = checkStage(otherP.getCurrentPokemon().getSpecial(), otherP.getCurrentPokemon().getSpecialStage());
		}
		else {
			modifiedDamage = checkStage(p.getCurrentPokemon().getAttack(), p.getCurrentPokemon().getAttackStage());
			modifiedDefense = checkStage(otherP.getCurrentPokemon().getDefense(), otherP.getCurrentPokemon().getDefenseStage());
		}
		
		double finalDamage = (p.getCurrentPokemon().getLevel() * 2 / 5 + 2 ) * p.getChoice().getPower() * modifiedDamage / modifiedDefense / 50;
		if(finalDamage > 997) {
			finalDamage = 999; 
		}
		
		if (checkType(p.getChoice(), otherP.getCurrentPokemon())=="It's super effective!") {
			finalDamage=finalDamage*2;
		}
		else if (checkType(p.getChoice(), otherP.getCurrentPokemon())=="It's not very effective...") {
			finalDamage=finalDamage/2;
		}
		
		double remainedHp = otherP.getCurrentPokemon().getHp() - finalDamage;
		if (remainedHp < 0){
			remainedHp=0;
		}
		
		otherP.getCurrentPokemon().setHp(remainedHp);
		
	}
	
	/**
	 * It change the status based on which sign the player choice move has and which stat is modifying.
	 * @param p the player who used the move with a category "status", inflicting it to the other
	 */
	public static void changeStatus(Player p) {
		Player otherP = Player.reversePlayer(p);
		
		String stat = p.getChoice().getStatModifier();
		String sign = p.getChoice().getStatSign();
		
		if (stat=="attack") {
			otherP.getCurrentPokemon().changeStage(sign, 0);
		}
		else if (stat=="defense") {
			otherP.getCurrentPokemon().changeStage(sign, 1);
		}
	}
	
	/**
	 * It boost or nerf the damage dealth based on the argument "stage".
	 * @param stageStat stat that will be alterated
	 * @param stage the stage given 
	 * @return the value modified
	 */
	public static double checkStage(double stageStat, double stage) {
		
		switch((int)stage) {
		case(+6): return stageStat * 4;
		case(+5): return stageStat * 3.5;
		case(+4): return stageStat * 3;
		case(+3): return stageStat * 2.5;
		case(+2): return stageStat * 2;
		case(+1): return stageStat * 1.5;
		case(-1): return stageStat * 0.66;
		case(-2): return stageStat * 0.50;
		case(-3): return stageStat * 0.40;
		case(-4): return stageStat * 0.33;
		case(-5): return stageStat * 0.28; 
		case(-6): return stageStat * 0.25; 
		default: return stageStat;
		}
	}
	
	/**
	 * It checks if a move is super effective or not, returning a string.
	 * @param pm the move dealing the damage
	 * @param p the pokemon receiving the damage
	 * @return the string based on which combination is composed
	 */
	public static String checkType(PokeMove pm, Pokemon p) {
		
		switch(pm.getType()+"-"+p.getType()) {
		case("water-fire"):return("It's super effective!");
		case("grass-water"):return("It's super effective!");
		case("fire-grass"):return("It's super effective!"); 
		case("fire-water"):return("It's not very effective...");
		case("water-grass"):return("It's not very effective...");
		case("grass-fire"):return("It's not very effective...");
		default: return("");
		}
	}
	
	/**
	 * It check if a move missed or not, returning an empty string if it not missed, and a string "move missed!", if it missed.
	 * @param pm the move where the stat accuracy is taken
	 * @return the string which tells if the move missed or not
	 */
	public static String checkMiss(PokeMove pm) {
		double accuracy = pm.getAccuracy();
		Random r = new Random();
		int i = r.nextInt(1, 101);
		if (i<=accuracy) {
			return ("");
		}
		else {
			return("move missed!");
		}
	}
	
	
	
}