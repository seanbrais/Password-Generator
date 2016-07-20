package code;
import java.util.ArrayList;

import javax.swing.JFrame;

import ui.Window;
import model.Generate;

public class Driver {
	
	
	public static void main(String[] args) {
		
		ArrayList<Character> invalidCharacters = new ArrayList<Character>();
		
		invalidCharacters.add('{');
		invalidCharacters.add('}');
		invalidCharacters.add('(');
		invalidCharacters.add(')');
		invalidCharacters.add('[');
		invalidCharacters.add(']');
		invalidCharacters.add('#');
		invalidCharacters.add(':');
		invalidCharacters.add(';');
		invalidCharacters.add(',');
		invalidCharacters.add('.');
		invalidCharacters.add('?');
		invalidCharacters.add('!');
		invalidCharacters.add('|');
		invalidCharacters.add('=');
		invalidCharacters.add('+');
		invalidCharacters.add('-');
		invalidCharacters.add('*');
		invalidCharacters.add('_');
		invalidCharacters.add('`');
		invalidCharacters.add('~');
		invalidCharacters.add('@');
		invalidCharacters.add('$');
		invalidCharacters.add('%');
		invalidCharacters.add('^');
		invalidCharacters.add('>');
		invalidCharacters.add('<');
		invalidCharacters.add('&');
		ArrayList<Integer> invalidIntegers = characterConvert(invalidCharacters);
		Window win = new Window(invalidIntegers);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
	}
	public static ArrayList<Integer> characterConvert(ArrayList<Character> characterList){
	ArrayList<Integer> invalidIntegers = new ArrayList<Integer>();
	for(int i = 0; i < characterList.size(); i++){
		invalidIntegers.add((int) characterList.get(i));
	}
	
	// Forward Slash
	invalidIntegers.add(92);
	//Backward Slash
	invalidIntegers.add(47);
	//Apostrophe
	invalidIntegers.add(39);
	//Double Quote
	invalidIntegers.add(34);
	return invalidIntegers;	
}
}
