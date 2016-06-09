package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.server.OperatoerDTO;

public class CreateMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MainView main;
	private CreateView createView;
	
	public CreateMenu(MainView main){
		initWidget(vPanel);
		this.main = main;
		
		Label txt = new Label("Create Menu");
		vPanel.add(txt);
		
		createView = new CreateView(this.main);
		this.vPanel.add(createView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}

	public void promptForPrint(OperatoerDTO result) {
		this.createView.promptForPrint(result);
	}
}
