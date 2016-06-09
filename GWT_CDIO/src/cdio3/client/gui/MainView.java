package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.client.service.OperatorServiceClientImpl;
import cdio3.shared.OperatoerDTO;

public class MainView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private OperatorServiceClientImpl serviceClientImpl;
	private AdminMenu admMenu;
	private CreateView createView;
	
	public MainView(OperatorServiceClientImpl serviceImpl){
		initWidget(this.vPanel);
		this.serviceClientImpl = serviceImpl;
		this.vPanel.setBorderWidth(1);
				
		MenuView menu = new MenuView(this);
		this.vPanel.add(menu);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
						
		Label textLabel = new Label("Click Wanted Menu");
		this.contentPanel.add(textLabel);
	}
	
	public void openAdminMenu(){
		this.contentPanel.clear();
		admMenu = new AdminMenu(this);
		this.contentPanel.add(admMenu);		
	}
	
	public void openPassMenu(){
		this.contentPanel.clear();
		PasswordMenu passMenu = new PasswordMenu(this);
		this.contentPanel.add(passMenu);
	}
	
	public void openWeighMenu(){
		this.contentPanel.clear();
		WeighMenu weighMenu = new WeighMenu();
		this.contentPanel.add(weighMenu);
	}
	
	public void login(int id, String pass) {
		this.serviceClientImpl.login(id, pass);
	}
	
	public void updateLogin() {
		this.admMenu.loginSucces();	
	}

	public void createOperator(int oprId, String firstName, String lastName, String CPR, int stilling, CreateView createView) {
		this.createView = createView;
		this.serviceClientImpl.createOperator(oprId, firstName, lastName, CPR, stilling);
	}

	public void changeOperator(String ID, String firstName, String lastName) {
		this.serviceClientImpl.changeOperator(ID, firstName, lastName);
	}

	public void changed() {
		this.admMenu.changed();
	}

	public void deleteOperator(String ID) {
		this.serviceClientImpl.deleteOperator(ID);
	}

	public void deleted() {
		this.admMenu.deleted();
	}

	public void promptForPrint(OperatoerDTO result) {
		this.createView.promptForPrint(result);
	}
}
