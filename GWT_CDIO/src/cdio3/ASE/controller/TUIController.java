package cdio3.ASE.controller;

import java.io.IOException;

import cdio3.ASE.boundary.TUI;
import cdio3.ASE.interfaces.ITUIController;

public class TUIController implements ITUIController {
	TUI tui = new TUI();
	
	
	public void printMessage(String input) {
		tui.printMessage(input);
		
	}

	
	public String getString() throws IOException {
		String temp = "";
		
		temp = tui.getString();
		
		return temp;
	}

}
