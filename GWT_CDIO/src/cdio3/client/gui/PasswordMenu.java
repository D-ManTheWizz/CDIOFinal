package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PasswordMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	private MainView main;
	
	public PasswordMenu(MainView main){
		initWidget(vPanel);
		this.main = main;		
		
		Label txt = new Label("Password Menu");
		vPanel.add(txt);
		
		PasswordView passwordView = new PasswordView(this.main);
		this.vPanel.add(passwordView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}
