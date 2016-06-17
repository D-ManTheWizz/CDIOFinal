package cdio3.server.ASE.boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cdio3.server.ASE.Interfaces.ITUI;

public class TUI implements ITUI {
	private BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
	
	
	@Override
	public String getString() throws IOException {
		return userInput.readLine();
	}

	@Override
	public void printMessage(String message) {
		System.out.println(message);
		
	}

}
