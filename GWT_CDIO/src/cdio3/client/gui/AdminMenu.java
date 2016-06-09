package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
	
public class AdminMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MainView main;
	private AdminView adminView;
	private CreateMenu createMenu;
	private ChangeMenu changeMenu;
	private DeleteMenu deleteMenu;
	
	public AdminMenu(MainView main){
		initWidget(this.vPanel);
		this.main = main;
		this.vPanel.setBorderWidth(1);
		
		
		adminView = new AdminView(this, main);
		this.vPanel.add(adminView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
				
		
		Label textLabel = new Label("Admin Menu");
		this.contentPanel.add(textLabel);
	}
	
	public void openCreateMenu(){
		this.contentPanel.clear();

		createMenu = new CreateMenu(main);
		this.contentPanel.add(createMenu);
		
	}
	
	public void openChangeMenu(){
		this.contentPanel.clear();
		changeMenu = new ChangeMenu(this, main);
		this.contentPanel.add(changeMenu);
		
	}
	
	public void openDeleteMenu(){
		this.contentPanel.clear();
		deleteMenu = new DeleteMenu(this, main);
		this.contentPanel.add(deleteMenu);
		
	}

	public void loginSucces() {
		this.adminView.loginSucces();	
	}

	public void changed() {
		this.changeMenu.changed();
	}

	public void deleted() {
		this.deleteMenu.deleted();
	}
}
