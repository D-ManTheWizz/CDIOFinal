package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateRaavare extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public CreateRaavare(){
		initWidget(vPanel);
		
		CreateRaavareView createView = new CreateRaavareView(this);
		this.vPanel.add(createView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}
