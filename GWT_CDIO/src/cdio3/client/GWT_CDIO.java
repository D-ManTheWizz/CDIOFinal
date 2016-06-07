package cdio3.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import cdio3.client.gui.MainView;
import cdio3.client.service.OperatorServiceClientImpl;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWT_CDIO implements EntryPoint {
//	/**
//	 * message displayed to the user when the server cannot be reached or
//	 * returns an error.
//	 */
//	private static final String SERVER_ERROR = "An error occurred while "
//			+ "attempting to contact the server. Please check your network " + "connection and try again.";
//
	/**
	 * This is the entry point method.
	 */					
	public void onModuleLoad() {
		OperatorServiceClientImpl clientImpl = new OperatorServiceClientImpl(GWT.getModuleBaseURL() + "operatorservice");
		
		RootPanel.get().add(clientImpl.getMainView());
	}
}