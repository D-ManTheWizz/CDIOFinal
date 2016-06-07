package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MainView main;
	private AdminMenu adminMenu;
	private CreateView createView;
	
	public CreateMenu(AdminMenu adminMenu, MainView main){
		initWidget(vPanel);
		this.main = main;
		this.adminMenu = adminMenu;
		
		Label txt = new Label("Create Menu");
		vPanel.add(txt);
		
		createView = new CreateView(main);
		this.vPanel.add(createView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}

	public void created() {
		this.createView.created();
	}
}
