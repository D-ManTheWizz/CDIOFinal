package cdio3.ASE.boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TUI implements cdio3.ASE.interfaces.ITUI {
	private BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
	
	
	
	public String getString() throws IOException {
		return userInput.readLine();
	}

	
	public int stringToInt() {
		int inputInt = 0;
		try {
			inputInt = Integer.parseInt(userInput.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputInt;
	}

	public void printMessage(String message) {
		System.out.println(message);
		
	}

}
