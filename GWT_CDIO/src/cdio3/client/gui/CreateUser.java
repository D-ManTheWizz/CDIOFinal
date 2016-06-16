package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateUser extends Composite{

	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public CreateUser(){
		initWidget(vPanel);
		
		CreateUserView createUserView = new CreateUserView();
		this.vPanel.add(createUserView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}
