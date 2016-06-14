package cdio3.server.ASE.controller;

import java.io.IOException;

import cdio3.server.ASE.boundary.TUI;
import cdio3.server.ASE.Interfaces.ITUIController;

public class TUIController implements ITUIController {
	TUI tui = new TUI();
	
	@Override
	public void printMessage(String input) {
		tui.printMessage(input);
		
	}

	@Override
	public String getString() throws IOException {
		String temp = "";
		
		temp = tui.getString();
		
		return temp;
	}

}
