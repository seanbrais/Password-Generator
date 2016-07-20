package model;
import java.util.ArrayList;
import java.util.Random;


public class Generate {
	public static String generatePassword(ArrayList<Integer> invalidIntegers, int size) {
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		integerList = createIntegerList(invalidIntegers);
		String password = "";
		for(int i = 0; i < size; i++){
			int seed = integerList.get(new Random().nextInt(integerList.size()));
			char character = (char) seed;
			password = password + character;
		}
		return password;
	}
	
	private static ArrayList<Integer> createIntegerList(ArrayList<Integer> invalidIntegerList){
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		for(int i = 33; i < 126; i++){
			if(invalidIntegerList.contains(i)){
			}
			else{
				integerList.add(i);
			}
		}	
		return integerList;
	}
}
