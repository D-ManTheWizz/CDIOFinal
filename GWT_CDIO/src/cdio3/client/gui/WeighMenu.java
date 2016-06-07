package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class WeighMenu extends Composite {
private HorizontalPanel hPanel = new HorizontalPanel();
	
	public WeighMenu(){
		initWidget(hPanel);
		
		Label textLabel = new Label("Weight Menu");
		this.hPanel.add(textLabel);
	}
	
}
