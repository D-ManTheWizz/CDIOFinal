package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ShowUser extends Composite{

	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public ShowUser(){
		initWidget(vPanel);
		
		ShowUserView showUsersView = new ShowUserView();
		this.vPanel.add(showUsersView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}