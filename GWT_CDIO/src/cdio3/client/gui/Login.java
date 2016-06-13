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
		
		
		LoginView menu = new LoginView(this, main);
		this.vPanel.add(menu);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
				
	}
	public void openMenu(int i){
		this.contentPanel.clear();
		this.main.setClearance(i); // New method instead of opening a new Main
//		MainView mainView = new MainView(i);  // This is now outcommented (but saved for ref.)
//		this.contentPanel.add(mainView);
		
	}
}