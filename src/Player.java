/**
 * It sets up all the characteristics that a player has when playing a pokémon game, such as his pokémon squad,
 * his nickname in the game, the choice that he make in a turn, ecc...
 * See its methods for more info.
 * @author dan
 */
public class Player {
	
	/**
	 * Nickname of the player
	 * @see #getNickname()
	 * @see #setNickname(String)
	 */
	private String nickname;
	
	/**
	 * 
	 */
	private int victories, loses = 0;
	
	/**
	 * An array of 3 pokémon which represents the player's pokémon squad.
	 * It is strictly related to the positions attributes, as they determines where the pokemon are in this array.
	 * @see #setPokemonSquad(String, int)
	 * @see #getPokemonSquad()
	 * @see #currentPosition
	 * @see #otherPositions
	 */
	private Pokemon[] pokemonSquad = {new Pokemon(), new Pokemon(), new Pokemon()};
	
	/**
	 * The choice that a player can make during a turn in the game.
	 * It is considered a PokeMove type attribute. See the class documentation for more info.
	 * @see #getChoice()
	 * @see #setChoice(PokeMove)
	 */
	private PokeMove turnChoice;
	
	/**
	 * The current pokémon that the player have a specific turn. It is determined by its position in the pokemonSquad array.
	 * @see #getCurrentPokemon()
	 * @see #setCurrentPokemon(int)
	 * @see #pokemonSquad
	 * @see #currentPosition
	 */
	private Pokemon currentPokemon;
	
	/**
	 * The current position in the pokemonSquad array of the currentPokemon. Used to change pokémon during a battle.
	 * @see #getCurrentPosition()
	 * @see #pokemonSquad
	 * @see #currentPokemon
	 */
	private int currentPosition;
	
	/**
	 * The other two positions of the pokemonSquad array where the two pokémon not currently used in the battle can be found.
	 * @see #getOtherPosition(int)
	 * @see #setOtherPositions(Player)
	 * @see #currentPosition
	 * @see #pokemonSquad
	 */
	private int[] otherPositions = {0, 0};
	
	private int gamesWon, gamesLost = 0;
	
	
	/**
	 * It creates a new Player object with a String type nickname. 
	 * DO NOT create a new player, as the 2 players required for the game are already implemented with a default nickname, "Player1" and "Player2", 
	 * which can be easily changed trough the setNickname method. 
	 * @param nickname
	 * @see #setNickname(String)
	 */
	private Player(String nickname, int gamesWon, int gamesLost){
		this.nickname = nickname;
		this.gamesWon = gamesWon;
		this.gamesLost = gamesLost;
	}
	
	/**
	 * Gets the pokemonSquad that the player currently has.
	 * @return the array pokemonSquad. If no pokémon has been set in the array it will still return the array but all the pokemon created inside won't have any information set.
	 */
	public Pokemon[] getPokemonSquad() {
		return pokemonSquad;
	}
	
	/**
	 * Gets the pokemon in the array pokemonSquad at the written position.
	 * @param position It must be between 0 and 2, as the array containts 3 pokémon.
	 * @return The pokémon set in the array at the determined position, NOT the pokémon that is currently in battle. 
	 */
	public Pokemon getPokemon(int position) {
		return pokemonSquad[position];
	}
	
	/**
	 * Gets the pokemon based on the current position set in the currentPosition attribute.
	 * @return The pokémon in the array pokemonSquad in the position set in currentPosition attribute.
	 * @see #currentPosition
	 * @see #setCurrentPokemon(int)
	 */
	public Pokemon getCurrentPokemon() {
		return currentPokemon;
	}
	
	/**
	 * Gets the nickname of the player
	 * @return The nickname in the String type
	 * @see #setNickname(String)
	 */
	public String getNickname(){
		return nickname;
	}
	
	/**
	 * Gets the choice made during a turn of battle. 
	 * @return A PokeMove choice, which could represent a pokemon move, a switch, or as a sort of "do nothing" in that turn.
	 */
	public PokeMove getChoice() {
		return turnChoice;
	}
	
	/**
	 * Gets the current position where the current Pokemon in battle can be found in the array pokemonSquad
	 * @return The int position, a number between 0 and 2, as the array contains 3 pokemon
	 */
	public int getCurrentPosition() {
		return currentPosition;
	}
	
	
	
	
	public int getVictories() {
		return victories;
	}
	
	
	
	
	public int getLoses() {
		return loses;
	}
	
	public int getGamesWon() {
		return gamesWon;
	}
	
	public int getGamesLost() {
		return gamesLost;
	}
	
	
	/**
	 * Gets one of the two remaining positions in the array pokemonSquad, as the third is the current one and represents the current pokemon fighting in a turn.
	 * @param position
	 * @return The position chosen by the argument position, which must be just 0 or 1, as the array containts just two elements.
	 */
	public int getOtherPosition(int position) {
		return otherPositions[position];
	}
	
	/**
	 * Sets the nickname of the player
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * Sets one of the pokemon that the player will have while in battle, based on the written position, which have to be a number between 0 and 2, as the squad is made of 3 pokemon.
	 * The pokemon name must be one of the pokemon listed in the createPokemon(String) method.
	 * For the creation of the pokemon to then put in the squad this setter uses the createPokemon(String) method, located inside the Pokemon class. See it for more information about it.
	 * @param pokemonName
	 * @param pokemonPosition
	 */
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
	
	/**
	 * Sets the choice made during a turn of battle.
	 * @param choice
	 */
	public void setChoice(PokeMove choice) {
		this.turnChoice = choice;
	}
	
	public void setVictories(int victories) {
		this.victories = victories;
	}
	
	
	public void setLoses(int loses) {
		this.loses = loses;
	}
	
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}
	
	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}
	
	/**
	 * Sets which is the current pokemon, which will appear in the battle as the active pokemon during a turn. 
	 * It also sets the current position, to fit the position of the new current pokemon in the array pokemonSquad.
	 * @param pokemonPosition
	 * @see #pokemonSquad
	 */
	public void setCurrentPokemon(int pokemonPosition) {
		this.currentPokemon = pokemonSquad[pokemonPosition];
		this.currentPosition = pokemonPosition;
	}
	
	/**
	 * Sets the other positions of the array pokemonSquad by eliminating the current position set of the player and setting the other two in the array otherPositions.
	 * @param p
	 */
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
	
	/**
	 * A method which reverse the player currently active during a turn or a damage calculus. It can be useful when you don't know which of the player 
	 * is the first to act during a turn, as it is determined by their current pokemon speed.
	 * @param p
	 * @return The other player, based on which player is inserted as the argument.
	 */
	public static Player reversePlayer(Player p) {
		if (p == p1) {
			return p2;
		}
		else {
			return p1;
		}
	}
	
	//Players List
	static Player p1 = new Player("Player1", 0, 0);
	static Player p2 = new Player("Player2", 0, 0);
	
	
}