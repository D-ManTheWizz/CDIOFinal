package cdio3.server.ASE.Interfaces;

import java.io.IOException;

public interface ITUI {
		
	public void printMessage(String input);
	public String getString() throws IOException;
	public int stringToInt();
}
