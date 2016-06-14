package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MainView main;
	
	public Login(MainView main){
		this.main = main; // Login gets opened by Main, not Main opened by Login
		
		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(1);
		
		
		LoginView menu = new LoginView(this.main);
		this.vPanel.add(menu);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);			
	}
}