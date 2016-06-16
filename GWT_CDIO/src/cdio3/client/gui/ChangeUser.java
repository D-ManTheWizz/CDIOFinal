package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeUser extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public ChangeUser(){
		initWidget(vPanel);
		
		ChangeUserView userView = new ChangeUserView(this);
		this.vPanel.add(userView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}