package cdio3.ASE.interfaces;

import java.io.IOException;

public interface ITUI {
		
	public void printMessage(String input);
	public String getString() throws IOException;
	public int stringToInt();
}
