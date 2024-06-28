/**
* Cell.java
* Jon Fuller / Thursday 2:30
*
* The Cell class represents a single square on the game board, storing information about whether 
it contains a Wumpus, gold, or a pit. It includes a constructor to create a new Cell object and 
provides getter and setter methods to access and update its fields as needed. This class encapsulates 
the attributes and behaviors of individual cells within the game board, facilitating their management 
within the overall game model.
*/
// Model class - Cell.java
// Reminder: No I/O statements in the Model (i.e., println, nextLine, etc.)
// Model only holds and manipulates the data

public class Cell {
	private boolean wumpusHere;
	private boolean goldHere;
	private boolean pitHere;

// no-arg constructor sets all data properties to false
 public Cell() {
	wumpusHere = false;
	goldHere = false;
	pitHere = false;
 }

// sets wumpusHere to true
 public void addWumpus() {
	this.wumpusHere = true;
 }

// sets wumpusHere to false
 public void killWumpus() {
	this.wumpusHere = false;
 }

// sets goldHere to true
 public void addGold() {
	this.goldHere = true;
 }

// sets goldHere to false
 public void grabGold() {
	this.goldHere = false;
 }

// sets pitHere to true
 public void addPit() {
	this.pitHere = true;
 }

// returns the current value of wumpusHere
 public boolean containsWumpus() {
	return this.wumpusHere;
 }

// returns the current value of goldHere
 public boolean containsGold() {
	
	return this.goldHere;
 }

// returns the current value of pitHere
 public boolean containsPit() {
	return this.pitHere;
 }
} // end class Cell