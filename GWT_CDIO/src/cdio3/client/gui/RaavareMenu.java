package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RaavareMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public RaavareMenu(){
		initWidget(vPanel);
		
		RaavareView farmaView = new RaavareView(this);
		this.vPanel.add(farmaView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
	
	public void openChangeMenu(){
		this.contentPanel.clear();
		ChangeRaavare ChangeMenu = new ChangeRaavare();
		this.contentPanel.add(ChangeMenu);
		
	}
	
	public void openCreateMenu(){
		this.contentPanel.clear();
		CreateRaavare CreateMenu = new CreateRaavare();
		this.contentPanel.add(CreateMenu);
		
	}
	public void openShowRMenu(){
		this.contentPanel.clear();
		RaavareList RLMenu = new RaavareList();
		this.contentPanel.add(RLMenu);
		
	}
}

