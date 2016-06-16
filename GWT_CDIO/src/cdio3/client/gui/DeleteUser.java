package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DeleteUser extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public DeleteUser(){
		initWidget(vPanel);
		
		DeleteUserView userView = new DeleteUserView(this);
		this.vPanel.add(userView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}