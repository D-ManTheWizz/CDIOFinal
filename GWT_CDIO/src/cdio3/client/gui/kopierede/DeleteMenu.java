package cdio3.client.gui.kopierede;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DeleteMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MainView main;
	private DeleteView deleteView;
	
	public DeleteMenu(AdminMenu adminMenu, MainView main){
		initWidget(vPanel);
		this.main = main;
		
		Label txt = new Label("Change Menu");
		vPanel.add(txt);
		
		deleteView = new DeleteView(this, main);
		this.vPanel.add(deleteView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}

	public void deleted() {
		this.deleteView.deleted();
	}
}
