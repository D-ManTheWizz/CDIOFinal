package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateUser extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	
	private MainView main;

	public CreateUser(MainView main){
		initWidget(vPanel);
		this.main = main;
		
		CreateUserView createUserView = new CreateUserView(this.main);
		this.vPanel.add(createUserView);
	}
}