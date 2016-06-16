package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AdmMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MainView main;

	public AdmMenu(MainView main){
		initWidget(vPanel);
		this.main = main;

		AdmView admView = new AdmView(this);
		this.vPanel.add(admView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
	
	public void openCreateMenu(){
		this.contentPanel.clear();
		CreateUser create = new CreateUser(this.main);
		this.contentPanel.add(create);
	}
	
	public void openChangeMenu(){
		this.contentPanel.clear();
		ChangeUser change = new ChangeUser(/*this.main*/);
		this.contentPanel.add(change);
	}
	
	public void openDeleteMenu(){
		this.contentPanel.clear();
		DeleteUser delete = new DeleteUser(/*this.main*/);
		this.contentPanel.add(delete);
	}
	
	public void openShowMenu(){
		this.contentPanel.clear();
		ShowUser show = new ShowUser(/*this.main*/);
		this.contentPanel.add(show);
	}
}