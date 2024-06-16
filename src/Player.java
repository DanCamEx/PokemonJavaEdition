
public class Player {
	
	//Attributes
	private String nickname;
	private int gamesPlayed, victories, loses;
	private Pokemon[] pokemonSquad = {new Pokemon(), new Pokemon(), new Pokemon()};
	private PokeMove turnChoice;
	private Pokemon currentPokemon;
	private int currentPosition;
	private int[] otherPositions = {0, 0};
	
	//Constructor
	Player(String nickname){
		this.nickname = nickname;
	}
	
	//Getters
	public Pokemon[] getPokemonSquad() {
		return pokemonSquad;
	}
	public Pokemon getPokemon(int position) {
		return pokemonSquad[position];
	}
	public Pokemon getCurrentPokemon() {
		return currentPokemon;
	}
	public String getNickname(){
		return nickname;
	}
	public PokeMove getChoice() {
		return turnChoice;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public int getOtherPosition(int position) {
		return otherPositions[position];
	}
	
	//Setters
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPokemonSquad(String pokemonName, int pokemonPosition) {
		if (pokemonName.equals("Bulbasaur")){
			Pokemon bulbasaur = Pokemon.createPokemon("Bulbasaur");
			pokemonSquad[pokemonPosition] = bulbasaur;
		}
		else if (pokemonName.equals("Charmander")) {
			Pokemon charmander = Pokemon.createPokemon("Charmander");
			pokemonSquad[pokemonPosition]  = charmander;
		}
		else if (pokemonName.equals("Squirtle")){
			Pokemon squirtle = Pokemon.createPokemon("Squirtle");
			pokemonSquad[pokemonPosition]  = squirtle;
		}
	}
	public void setChoice(PokeMove choice) {
		this.turnChoice = choice;
	}
	
	public void setCurrentPokemon(int pokemonPosition) {
		this.currentPokemon = pokemonSquad[pokemonPosition];
		this.currentPosition = pokemonPosition;
	}
	public void setOtherPositions(Player p) {
		int i1;
		int i2 = 0;
		for (i1=0;i1<3;i1++) {
			if (i1==p.getCurrentPosition()) {
				continue;
			}
			else {
				this.otherPositions[i2] = i1;
				i2++;
			}
		}
	}
	
	//Methods
	public static Player reversePlayer(Player p) {
		if (p == p1) {
			return p2;
		}
		else {
			return p1;
		}
	}
	
	//Players List
	static Player p1 = new Player("Player1");
	static Player p2 = new Player("Player2");
	
	
}