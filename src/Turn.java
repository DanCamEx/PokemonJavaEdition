import java.util.Random;

public class Turn {
	
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
	
	public static void attack(Player p) {
		
		Player otherP = Player.reversePlayer(p);
		
		double modifiedDamage = checkStage(p.getCurrentPokemon().getAttack(), p.getCurrentPokemon().getAttackStage());
		double modifiedDefense = checkStage(otherP.getCurrentPokemon().getDefense(), otherP.getCurrentPokemon().getDefenseStage());
		
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