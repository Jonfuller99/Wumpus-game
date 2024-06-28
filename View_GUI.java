/**
* View_GUI.java
* Jon Fuller / Thursday 2:30
*
* View_GUI represents the graphical user interface component within the MVC architecture. 
It encompasses methods tailored for user interaction via graphical elements, managing both input 
and output operations. All user input and output, including GUI elements, are exclusively 
handled within View_GUI, adhering to the MVC pattern's principles of separation of concerns. 
This approach facilitates modularity and maintainability by isolating GUI logic from other components 
of the system, promoting a clear and intuitive user experience.
* 
*/
// View class for Console I/O (View.java)
// Reminder: View knows nothing of the Model
// View only handles I/O statements (i.e., println, nextLine, etc.)

import java.util.*;
import javax.swing.JOptionPane; 
public class View_GUI {
	private Scanner s;
	
// Constructor is done for the student
 public View_GUI() {
	s = new Scanner(System.in);
 } // end no-arg constructor

// Prompts user for an option: (m)ove, (s)hoot, (g)rab, or (c)limb
// Returns lowercase version of the choice
 public char getOption() {
	
	String option = JOptionPane.showInputDialog("Enter (m)ove, (s)hoot, (g)rab, or (c)limb: ");
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
			
			option =JOptionPane.showInputDialog("Invalid option. Please enter (m)ove, (s)hoot, (g)rab, or (c)limb: ");
			x = option.charAt(0);
		break;
		
		}// end swtich
	}// end while
	
		return x;
	
} // end getOption
	
// Prompts user for a direction: (u)p, (d)own, (l)eft, or (r)ight
// Returns lowercase version of the choice
 public char getDirection() {
	
	String option = JOptionPane.showInputDialog("Enter (u)p, (d)own, (l)eft, or (r)ight: ") ;
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
			
			option = JOptionPane.showInputDialog("Invalid option. Please enter (u)p, (d)own, (l)eft, or (r)ight: ");
			x = option.charAt(0);
		break;
		}// end swtich
	}//end while
			return x;
} // end getDirection
	
// Displays any string passed to it followed by a newline
// Used to display a message, such as "You hear a scream."
 public void displayMsg(String msg) {
	JOptionPane. showMessageDialog (null, msg);
 } // end displayMsg
	
// Displays any string passed to it followed by a newline
// Used to display an error message, such as "There is a wall there."
 public void displayError(String error) {
	JOptionPane. showMessageDialog (null, error);
 } // end displayError
	
// Displays any string passed to it followed by a newline
// Used to display the ending message, such as "You leave the cave with the gold!"
// (On a new line) "The Wumpus is dead. You win!"
 public void endGame(String msg) {
	JOptionPane. showMessageDialog (null, msg);
 } // end endGame
} // end class View