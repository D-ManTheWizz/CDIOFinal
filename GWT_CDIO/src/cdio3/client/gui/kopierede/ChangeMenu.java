package cdio3.client.gui.kopierede;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MainView main;
	private AdminMenu adminMenu;
	private ChangeView changeView; 
	
	public ChangeMenu(AdminMenu adminMenu, MainView main){
		initWidget(vPanel);
		
		Label txt = new Label("Change Menu");
		vPanel.add(txt);
		
		changeView = new ChangeView(main);
		this.vPanel.add(changeView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}

	public void changed() {
		this.changeView.changed();
	}
}
