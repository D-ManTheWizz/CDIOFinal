package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeUser extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	
	public ChangeUser(MainView main){
		initWidget(vPanel);
		
		ChangeUserView userView = new ChangeUserView(main);
		this.vPanel.add(userView);
	}
}