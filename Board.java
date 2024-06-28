/**
* Board.java
* Jon Fuller / Thursday 2:30
*
* The Board class represents the game board containing a two-dimensional array of Cells and a Player object. 
It includes a constructor to create a new random game board according to the game rules. The class implements methods 
for the player to grab gold, climb out of the cave, retrieve information about the player's current position
 (e.g., detecting stench), move the player, shoot an arrow, and display the current state of the board. Additional 
 methods can be added as needed.
*/
// Model class - Board.java
// Reminder: No I/O statements in the Model (i.e., println, nextLine, etc.)
// Model only holds and manipulates the data

import java.util.*;


public class Board {
	private Cell[][] game;
	private int rows, cols;
	private Player player;
	private int exitRow;
	private int exitCol;
	private boolean exit;
	private boolean wumpusDead;

// No-arg constructor
// 1) Set exit and wumpusDead to false
// 2) Randomly pick the dimensions (4-6 by 4-6) for rows, columns
// 3) Initialize the game board that size
// 4) Instantiate the player object using exitRow (rows-1) and exitCol (0)
// 5) Use nested for loop to add Cells to the game and add pits (DONE)
// 6) Randomly place one wampus and gold into  the game
	


 public Board() {
	 
	exit = false;
	wumpusDead = false;
	Random r = new Random();
	rows = r.nextInt(3)+4;
	cols = r.nextInt(3)+4;
	
	game = new Cell[rows][cols];
	
	exitRow = rows - 1;
	exitCol = 0;
	player = new Player(exitRow, exitCol);
	
	
	
	
	

// Code below given to student
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
			game[i][j] = new Cell();
			if (i != exitRow || j != exitCol) {
				int chance = r.nextInt(100);
				if (chance <= 9) {
					//place a pit (10% chance)
					game[i][j].addPit();
				}
			}
		} // end outer for
	} // end inner for

	int randomRow = r.nextInt(rows);
	int randomColumn = r.nextInt(cols);
	while(game[randomRow][randomColumn].containsPit() && randomRow!=exitRow && randomColumn != exitCol){
		randomRow = r.nextInt(rows);
		randomColumn = r.nextInt(cols);
	}
	
	game[randomRow][randomColumn].addWumpus();
	
	int randomRow2 = r.nextInt(rows);
	int randomColumn2 = r.nextInt(cols);
	while(game[randomRow2][randomColumn2].containsPit() && game[randomRow2][randomColumn2].containsWumpus() && randomRow2!=exitRow && randomColumn2 != exitCol){
		randomRow2 = r.nextInt(rows);
		randomColumn2 = r.nextInt(cols);
	}
	
	game[randomRow2][randomColumn2].addGold();

 } // end no-arg constructor
	
// Returns true if the wampus is at a given row/col position
// otherwise returns false	
 public boolean amEaten() {
	 if(game[player.getRow()][player.getCol()].containsWumpus()){
		 return true; 
	 }
	 else{
		 return false;
		 
	 }

 } // end amEaten()

// Returns true if there is a pit at a given row/col position
// otherwise returns false	
 public boolean fallen() {
	if(game[player.getRow()][player.getCol()].containsPit()){
		return true;
	}
	else{
		return false;
	}

 } // end fallen()
	
// Returns true if the wampus is dead
// otherwise returns false	
 public boolean wumpusGone() {
	//boolean x = false;
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
			if(game[i][j].containsWumpus()){
				return  false;
				
			}// end if
			
		}
	}
	return true;
 } // end wumpusGone()

// Returns true if player escaped (exit is true)
// otherwise returns false	
 public boolean escaped() {
	if(exit){
		return true;	
	}
	else{
		return false;
	}
 } // end escaped()
	
// Returns true if player has the gold
// otherwise returns false	
 public boolean hasGold() {
	if(player.hasGold()){
		return true;
	}
	else{
		return false;
	}
 } // end hasGold()
	
// Returns true if player has an arrow
// otherwise returns false	
 public boolean hasArrow() {
	if(player.hasArrow()){
		return true;
	}
	else{
	return false;
	}
 } // end hasArrow()
	
// If there is gold at a given row/col, play grabs the gold and return true
// otherwise returns false	
public boolean grabGold() {
	if(game[player.getRow()][player.getCol()].containsGold()){
		player.grabGold();
		game[player.getRow()][player.getCol()].grabGold();
		return true;	
	}
	else{
		return false;
	}
 } // end grabGold()
	
// If players current position is at the exitRow and exitCol
// set exit to true and return true
// otherwise returns false	
public boolean climb() {
	if(game[player.getRow()][player.getCol()] == game[exitRow][exitCol]){
		exit = true;
		return true;	
	}
	else{
		return false;
	}

 } // end climb()

// Initially set wampus and pit to false
// Create a StringBuilder object 'sb' (since no I/O allowed in the model)
// Get the current row/col of the player 
// If that position 'contains gold', append message to 'sb'
// If a wampus or pit is nearby, set to true
// If there is a wampus nearby, append message to 'sb'
// If there is a pit nearby, append message to 'sb'
// Return 'sb' as a String
public String evaluateSpot() {
	boolean wumpus2 = false;
	boolean pit = false;
	StringBuilder sb = new StringBuilder();
	int playerRow = player.getRow();
	int playerCol = player.getCol();
	
	
	
	if(game[playerRow][playerCol].containsGold()){
		sb.append("You see a glitter.\n");
	}
	
	for(int i = Math.max(0, playerRow - 1)  ; i < Math.min(game.length , playerRow+2); i++){ //Math max information got from java documentation https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#max-int-int-
		for(int j = Math.max(0, playerCol - 1) ; j<Math.min(game[0].length , playerCol+2); j++){ //Math min information got from java documentation https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#min-int-int-
			
			if ((i == playerRow - 1 && j == playerCol - 1) || (i == playerRow - 1 && j == playerCol + 1) ||
            (i == playerRow + 1 && j == playerCol - 1) || (i == playerRow + 1 && j == playerCol + 1)){
				continue;
			}
			
			if(game[i][j].containsPit()){
				pit = true;
				
			}
		}
	}
			
			/*
			if(i>=0 && game[i][j].containsWumpus()){
					wumpus = true;
			}
			if(i < game.length && game[i][j].containsWumpus()){
				wumpus = true;
				
			}
			
			if(j >= 0 && game[i][j].containsWumpus()){
				wumpus = true;
				
			}
			if(j< game[0].length && game[i][j].containsWumpus()){
				wumpus = true;
				
			}
			*/
			
	
	for(int i = Math.max(0, playerRow - 1)  ; i < Math.min(game.length , playerRow+2); i++){ //Math max information got from java documentation https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#max-int-int-
		for(int j = Math.max(0, playerCol - 1) ; j<Math.min(game[0].length , playerCol+2); j++){ //Math min information got from java documentation https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#min-int-int-
			
			if ((i == playerRow - 1 && j == playerCol - 1) || (i == playerRow - 1 && j == playerCol + 1) ||
            (i == playerRow + 1 && j == playerCol - 1) || (i == playerRow + 1 && j == playerCol + 1)){
				continue;
			}
			
			if(game[i][j].containsWumpus()){
				wumpus2 = true;
				
			}
		}
	}
	
	/*
	for(int i = 0 ; i <game.length; i++){
		for(int j = 0 ; j<game[0].length; j++){
			if(i>0 && game[i-1][j].containsPit()){
				pit = true;	
			}
			if(i < game.length-1 && game[i+1][j].containsPit()){
				pit = true;
				
			}
			
			if(j > 0 && game[i][j-1].containsPit()){
				pit = true;
				
			}
			if(j< game[0].length-1 && game[i][j+1].containsPit()){
				pit = true;
				
			}	
		}
	}
	*/
		if(pit){
			sb.append("You feel a breeze.\n");
		}
		if(wumpus2){
			sb.append("You smell a stench.\n");
		}
	
	return sb.toString();

 } // end evaluateSpot()

// If no wall, move player based on direction ('u', 'd', 'l', 'r')
// return whether there is a wall there or not
public boolean move(char dir) {
	boolean wall = false;
	
	switch(dir){
		case 'u':
			if(player.getRow() <= 0){
				wall = true;
			}
			else{
				player.move(dir);
			}
		break;
		case 'd':
			if(player.getRow() >= game.length-1){
				wall = true;
			}
			else{
				player.move(dir);
			}
		break;	
		case 'l':
			if(player.getCol() <= 0){
				wall = true;
			}
			else{
				player.move(dir);
			}
		break;	
		case 'r':
			if(player.getCol() >= game[0].length-1){
				wall = true;
			}
			else{
				player.move(dir);
			}
		break;
		
		
	}
	
	
	
	
	/*
	
	if(dir == 'u' && player.getCol() <= 0){
		wall = true;
		
		}
	else{
		player.move(dir);
	}	
	
	if(dir == 'd' && player.getCol() == game.length){
		wall = true;
		
		}
	else{
		player.move(dir);
	}
	
	if(dir == 'l' && player.getRow() <= 0){
		wall = true;
		
		}
	else{
		player.move(dir);
		}	
	
	if(dir == 'r' && player.getRow() == game[0].length){
		wall = true;
		
		}
	else{
		player.move(dir);
	}
	
	*/
	return wall;
 } // end move()

// Get the currrent position of the player
// returns whether the shot hit the Wumpus
// If a player has an arrow, shoot it and determine if the wampus is killed (return true)
// otherwise return false
 public boolean shoot(char dir) {
	int playerRow = player.getRow();
	int playerCol = player.getCol(); 
	boolean x = false;
	
	if(player.hasArrow()){
		player.shootArrow();
		if(dir=='l'){
			for(int i = playerCol; i >= 0  ; i--){
				if(game[playerRow][i].containsWumpus()){
					game[playerRow][i].killWumpus();	
					x = true;
				}
				
			}
		}// end dir=='u'
	
	
	
	if(dir=='r'){
		for(int i = playerCol; i < game[0].length  ; i++){
			if(game[playerRow][i].containsWumpus()){
				game[playerRow][i].killWumpus();	
				x = true;
			}
			
		}
	}// end dir=='d'
	
	if(dir=='u'){
		for(int i = playerRow; i >= 0  ; i--){
			if(game[i][playerCol].containsWumpus()){
				game[i][playerCol].killWumpus();	
				x = true;
			}
			
		}
	}// end dir=='l'

	if(dir=='d'){
		for(int i = playerRow; i < game.length  ; i++){
			if(game[i][playerCol].containsWumpus()){
				game[i][playerCol].killWumpus();	
				x = true;
			}
			
		}
	}// end dir=='r'	
	
	}// end player.hasArrow()
	return x;
 } // end shoot()
 
 // Use to display the current state of the board (game)
// returns a String representation of the board
public String boardState() {
	StringBuilder sb = new StringBuilder();
	
	for(int i = 0; i < rows; i++){

		for(int j = 0 ; j < cols ; j++){
			if(game[i][j].containsWumpus()){
				sb.append("[true,");
			}
			else{
				sb.append("[false,");
			}
			
			if(game[i][j].containsGold()){
				sb.append("true,");
			}
			else{
				sb.append("false,");
			}			

			if(game[i][j].containsPit()){
			sb.append("true]");
			}
			else{
				sb.append("false]");
			}	

	
		}
		sb.append("\n");
	}
	return sb.toString();
 } // end boardState

} // end class Board