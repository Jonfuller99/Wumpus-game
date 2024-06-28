/**
* Proj8.java
* Jon Fuller / Thursday 2:30
*
* The Proj8 class serves as the controller in the Model-View-Controller (MVC) architecture.
 It initializes a Board object and a View object, orchestrating the game flow by calling methods 
 in these objects. Proj8 is responsible for mediating interactions between the Board and View classes, 
 ensuring they do not directly interact with each other. 
 
 *EXTRA CREDIT INCLUDED*

*/
// Controller class - Proj 8.java
// Reminder: No I/O statements in the controller class (i.e., println, nextLine, etc.)
// Use Board and View classes to do all of the 'work' for this application

public class Proj8 {
	public static void main(String[] args) {
		Board board = new Board();
		View view = new View();
		//View_GUI view = new View_GUI();
		view.displayMsg(board.boardState());
		view.displayMsg(board.evaluateSpot());
		boolean yes = true;
		
		char input = view.getOption();
		while(yes){
			//view.displayMsg(board.evaluateSpot());
			
			
			switch(input){
				case 'M':
				case 'm':
					if(board.move(view.getDirection())){
						view.displayError("There is a wall there.");
					}
					
					
						
					if(board.amEaten()){
						view.displayError("You have been eaten! You lose.");
						yes = false;
						break;
					}
					
					if(board.fallen()){
						view.displayError("You have fallen into a pit! You lose.");
						yes = false;
						break;
					}
					
					
					view.displayMsg(board.evaluateSpot());
					input = view.getOption();			
					
				break;
				
				case 'S':
				case 's':
					if(board.hasArrow()){
						if(board.shoot(view.getDirection())){
							view.displayMsg("You hear a scream.");
						}
					}
					else{
						view.displayMsg("You have no arrow left.");
					}
					
					view.displayMsg(board.evaluateSpot());
					input = view.getOption();		
				break;

				case 'G':
				case 'g':
					if(board.grabGold()){
						view.displayMsg("You pick up the gold.");
					}
					else{
						view.displayMsg("There is no gold.");
					}
					
					view.displayMsg(board.evaluateSpot());
					input = view.getOption();		
				break;
				
				case 'C':
				case 'c':
					
					
					
					
					if(board.climb()){
						if(board.hasGold() && (board.wumpusGone()) && board.escaped()){
							view.endGame("You leave the cave with the gold! The Wumpus is dead. You win!");
							yes = false;
							break;
						}
						 if(board.hasGold() && board.escaped() && !(board.wumpusGone())){
							view.endGame("You leave the cave with the gold! The Wumpus is still alive. You lose.");
							yes = false;
							break;

						}
						 if(board.escaped() && board.wumpusGone() && !(board.hasGold())){
							view.endGame("You leave the cave without the gold. The wumpus is dead! You lose.");
							yes = false;
							break;

						}
						if(!(board.hasGold()) && !(board.wumpusGone()) && board.escaped()){
							view.endGame("You leave the cave without the gold. The wumpus is still alive. You lose.");
							yes = false;
							break;

						}
					}
					else{
						view.endGame("Not at the exit.");
						input = view.getOption();
					}
						
						
					
					
				
				
	
			}// end switch	
		}// end while yes
	}// end main
}// end class