package cdio3.server.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LogicController {
	
	private ArrayList<String> password = new ArrayList<String>();
	
	public String generatePassword() {
		
		// create a list of numbers 1-8       
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		
		// shuffle the list
		Collections.shuffle(a); 
		
		for(int i=0; i<=7; i++) {
			
			// iterate through the shuffled list
			int choice = a.get(i); 
			
			// run all 8 cases in random order
			switch(choice) {
			
				// get a random UpperCase letter and add to the StringArray: password
				case 1: getUppercase();
						break;
						
				// get a random	LowerCase letter and add to the StringArray: password
				case 2: getLowercase();
						break;
				
				// get a random integer and add to the StringArray: password
				case 3: getInt();
						break;
						
				// get a random special-sign and add to the StringArray: password
				case 4: getSpecial();
						break;
						
				// get a random letter/int/sign and add to the StringArray: password
				case 5: getRandom();
						break;
						
				// get a random letter/int/sign and add to the StringArray: password
				case 6: getRandom();
						break;
				
				// get a random letter/int/sign and add to the StringArray: password
				case 7: getRandom();
						break;
				
				// get a random letter/int/sign and add to the StringArray: password
				case 8: getRandom();
						break;						
			}	
		}
		
		// generate the password from the StringArray: password
		String generatedPassword = 	password.get(0) + password.get(1) + 
									password.get(2) + password.get(3) + 
									password.get(4) + password.get(5) + 
									password.get(6) + password.get(7);

		return generatedPassword;		      
	}
	
	private void getUppercase() {
		
		String[] upper = {"A","B","C","D","E","F","G","H","I","J","K","L",
				"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Collections.shuffle(Arrays.asList(upper));
		
		password.add(upper[0]);
	}
	
	private void getLowercase() {
		
		String[] lower = {"a","b","c","d","e","f","g","h","i","j","k","l",
				"m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		Collections.shuffle(Arrays.asList(lower));
		
		password.add(lower[0]);
	}
	
	private void getInt() {
		
		String[] number = {"0","1","2","3","4","5","6","7","8","9"};
		Collections.shuffle(Arrays.asList(number));
		
		password.add(number[0]);
	}
	
	private void getSpecial() {
		
		String[] special = {".", ",", "-", "_", "+", "!", "?", "="};
		Collections.shuffle(Arrays.asList(special));
		
		password.add(special[0]);
	}
	
	private void getRandom() {
		
		String[] random = {".", ",", "-", "_", "+", "!", "?", "=","0","1",
				"2","3","4","5","6","7","8","9","a","b","c","d","e","f","g",
				"h","i","j","k","l","m","n","o","p","q","r","s","t","u","v",
				"w","x","y","z","A","B","C","D","E","F","G","H","I","J","K",
				"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Collections.shuffle(Arrays.asList(random));
		
		password.add(random[0]);
	}
	
	/*
	 *  round the weight to two digits
	 */
	private double round(double weight) {
		double rounded = (double) Math.round(weight * 100) / 100;
		return rounded;
	}
}
