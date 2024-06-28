/**
* View.java
* Jon Fuller / Thursday 2:30
*
* View encapsulates the View component within the MVC architecture, handling all user 
input and output operations for the program. It features methods tailored for various types of 
user input and output scenarios, ensuring comprehensive coverage of interaction with the application. 
As the sole interface for user interaction, View encompasses all aspects of input and output, adhering to the 
MVC pattern's principles of separation of concerns. This segregation fosters clarity and maintainability by isolating 
user interface logic from other components of the system.
*/
// View class for Console I/O (View.java)
// Reminder: View knows nothing of the Model
// View only handles I/O statements (i.e., println, nextLine, etc.)

import java.util.*;

public class View {
	private Scanner s;
	
// Constructor is done for the student
 public View() {
	s = new Scanner(System.in);
 } // end no-arg constructor

// Prompts user for an option: (m)ove, (s)hoot, (g)rab, or (c)limb
// Returns lowercase version of the choice
 public char getOption() {
	System.out.print("\nEnter (m)ove, (s)hoot, (g)rab, or (c)limb: ");
	String option = s.nextLine();
	char x = option.charAt(0);
	boolean yes = true;
	while(yes){
	switch(x){
		case 'M':
		case 'm':
			x = 'm';
			yes = false;
		break;
		
		case 'S':
		case 's':
			x = 's';
			yes = false;
		break;

		case 'G':
		case 'g':
			x = 'g';
			yes = false;
		break;
		
		case 'C':
		case 'c':
			x = 'c';
			yes = false;
		break;
		
		default:
			System.out.print("Invalid option. Please enter (m)ove, (s)hoot, (g)rab, or (c)limb: ");
			option = s.nextLine();
			x = option.charAt(0);
		break;
		
		}// end swtich
	}// end while
	
		return x;
	
} // end getOption
	
// Prompts user for a direction: (u)p, (d)own, (l)eft, or (r)ight
// Returns lowercase version of the choice
 public char getDirection() {
	System.out.print("Enter (u)p, (d)own, (l)eft, or (r)ight: ");
	String option = s.nextLine();
	char x = option.charAt(0);
	boolean yes = true;
	while(yes){
	switch(x){
		case 'U':
		case 'u':
			x = 'u';
			yes = false;
		break;
		
		case 'D':
		case 'd':
			x = 'd';
			yes = false;
		break;

		case 'L':
		case 'l':
			x = 'l';
			yes = false;
		break;
		
		case 'R':
		case 'r':
			x = 'r';
			yes = false;
		break;
		
		default:
			System.out.print("Invalid option. Please enter (u)p, (d)own, (l)eft, or (r)ight: ");
			option = s.nextLine();
			x = option.charAt(0);
		break;
		}// end swtich
	}//end while
			return x;
} // end getDirection
	
// Displays any string passed to it followed by a newline
// Used to display a message, such as "You hear a scream."
 public void displayMsg(String msg) {
	System.out.println(msg);
 } // end displayMsg
	
// Displays any string passed to it followed by a newline
// Used to display an error message, such as "There is a wall there."
 public void displayError(String error) {
	System.out.println(error);
 } // end displayError
	
// Displays any string passed to it followed by a newline
// Used to display the ending message, such as "You leave the cave with the gold!"
// (On a new line) "The Wumpus is dead. You win!"
 public void endGame(String msg) {
	System.out.println(msg);
 } // end endGame
} // end class View