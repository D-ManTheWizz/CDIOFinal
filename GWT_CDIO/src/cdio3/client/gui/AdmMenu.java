package cdio3.client.gui;

//public class AdmMenu extends Composite {
//	
//	private MainView main;
//	
//	public AdmMenu(MainView main) {
//		this.main = main;
//	}
//
//}

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AdmMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	private MainView main;
	public AdmMenu(MainView main){
		initWidget(vPanel);
		this.main = main;
		AdmView vfView = new AdmView(this);
		this.vPanel.add(vfView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
	
	public void openCreateMenu(){
		this.contentPanel.clear();
		CreateUser create = new CreateUser();
		this.contentPanel.add(create);
		
	}
	public void openChangeMenu(){
		this.contentPanel.clear();
		ChangeUser change = new ChangeUser();
		this.contentPanel.add(change);
		
	}
	
	public void openDeleteMenu(){
		this.contentPanel.clear();
		DeleteUser delete = new DeleteUser();
		this.contentPanel.add(delete);
		
	}
	
	public void openShowMenu(){
		this.contentPanel.clear();
		ShowUsers show = new ShowUsers();
		this.contentPanel.add(show);
		
	}
}
