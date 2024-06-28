/**
* Player.java
* Jon Fuller / Thursday 2:30
*
* The Player class represents the user in the game, keeping track of whether they have an arrow, 
if they've picked up gold, and their current position on the board. It has methods to set and get these values, 
as well as a method to move the player around the board. This class manages everything related to the player's status and movements within the game.
*/
// Model class - Player.java

public class Player {
	private boolean arrow;
	private boolean gold;
	private int row;
	private int col;

// 4 arg constructor
public Player(int r, int c) {
	row = r;
	col = c;
	arrow = true;
	gold = false;
 }
	
 public void shootArrow() {
	arrow = false;
 }

 public void grabGold() {
	gold = true;
 }

 public boolean hasGold() {
	return gold;
 }

 public int getRow() {
	return row;
 }

 public int getCol() {
	return col;
 }

public boolean hasArrow() {
	return arrow;
 }

// Move player based on direction ('u', 'd', 'l', 'r')
 public void move(char dir) {
	switch(dir) {
		case 'l':
			col--;
			break;
		case 'r':
			col++;
			break;
		case 'u':
			row--;
			break;
		case 'd':
			row++;
			break;
	} // end switch
 } // end move()

} // end class Player