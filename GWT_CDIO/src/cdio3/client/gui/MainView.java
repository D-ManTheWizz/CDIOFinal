package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.client.service.OperatorServiceClientImpl;
import cdio3.shared.OperatoerDTO;

public class MainView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MenuView menu;
	private FarmaMenu farmaMenu;
	private VfMenu vfMenu;
	private OpMenu opMenu;
	private LoginView login;
	
	// Old
	private OperatorServiceClientImpl serviceClientImpl;
	private AdmMenu admMenu;
	
	public MainView(OperatorServiceClientImpl serviceImpl){
		initWidget(this.vPanel);
		this.serviceClientImpl = serviceImpl;
		this.vPanel.setBorderWidth(1);
		
		Login login = new Login(this);
		this.vPanel.add(login);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
	
	public void setClearance(OperatoerDTO oprDTO) {
		
		this.vPanel.clear();
//		this.contentPanel.clear();
		menu = new MenuView(this, oprDTO);
		this.vPanel.add(menu);
	}
	
	public void openAdminMenu(){
		this.contentPanel.clear();
		admMenu = new AdmMenu(this);
		this.contentPanel.add(admMenu);		
	}
	
	public void openFarmaMenu(){
		this.contentPanel.clear();
		farmaMenu = new FarmaMenu(this);
		this.contentPanel.add(farmaMenu);
		
	}
	
	public void openVfMenu(){
		this.contentPanel.clear();
		VfMenu vfMenu = new VfMenu(this);
		this.contentPanel.add(vfMenu);
		
	}
	
	public void openOpMenu(){
		this.contentPanel.clear();
		OpMenu opMenu = new OpMenu(this);
		this.contentPanel.add(opMenu);
		
	}
	
	public void login(int id, String pass, LoginView login) {
		this.login = login;
		this.serviceClientImpl.login(id, pass);
	}
	
	public void confirmLogin(OperatoerDTO oprDTO) {
		setClearance(oprDTO);
	}
	
	
	
	
	// Old methods
//	
//	public void openPassMenu(){
//		this.contentPanel.clear();
//		PasswordMenu passMenu = new PasswordMenu(this);
//		this.contentPanel.add(passMenu);
//	}
//	
//	public void openWeighMenu(){
//		this.contentPanel.clear();
//		WeighMenu weighMenu = new WeighMenu();
//		this.contentPanel.add(weighMenu);
//	}
//
//	public void createOperator(int oprId, String firstName, String lastName, String CPR, int stilling, CreateView createView) {
//		this.createView = createView;
//		this.serviceClientImpl.createOperator(oprId, firstName, lastName, CPR, stilling);
//	}
//
//	public void changeOperator(String ID, String firstName, String lastName) {
//		this.serviceClientImpl.changeOperator(ID, firstName, lastName);
//	}
//
	public void changed() {
//		this.admMenu.changed();
	}
//
//	public void deleteOperator(String ID) {
//		this.serviceClientImpl.deleteOperator(ID);
//	}
//
	public void deleted() {
//		this.admMenu.deleted();
	}
//
	public void promptForPrint(OperatoerDTO oprDTO) {
//		this.createView.promptForPrint(oprDTO);
	}
}
