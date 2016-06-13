package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.client.service.OperatorServiceClientImpl;
import cdio3.shared.OperatoerDTO;

public class MainView extends Composite {
	// Old
//	private VerticalPanel vPanel = new VerticalPanel();
//	private VerticalPanel contentPanel;
	
	// New
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	private int clearanceLvl = 0;
//	private int k;
//	private MenuView oMenu = new MenuView(this, k);
	
	private FarmaMenu farmaMenu;
	private VfMenu vfMenu;
	private OpMenu opMenu;
	
	// Old
	private OperatorServiceClientImpl serviceClientImpl;
	private AdmMenu admMenu;
//	private AdminView admView;
//	private CreateView createView;
	
	public MainView(OperatorServiceClientImpl serviceImpl){
		Login login = new Login(this); // HER ELLER EFTER initWIDGET?????!!??
		initWidget(this.vPanel);
		this.serviceClientImpl = serviceImpl;
		this.vPanel.setBorderWidth(1);
				
		MenuView menu = new MenuView(this, clearanceLvl);
		this.vPanel.add(menu);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
		
		// Old
//		Label textLabel = new Label("Click Wanted Menu");
//		this.contentPanel.add(textLabel);
	}
	
	public void setClearance(int clearanceLvl) {
		this.clearanceLvl = clearanceLvl;
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
//	public void login(int id, String pass, AdminView admView) {
//		this.admView = admView;
//		this.serviceClientImpl.login(id, pass);
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
//	public void changed() {
//		this.admMenu.changed();
//	}
//
//	public void deleteOperator(String ID) {
//		this.serviceClientImpl.deleteOperator(ID);
//	}
//
//	public void deleted() {
//		this.admMenu.deleted();
//	}
//
//	public void promptForPrint(OperatoerDTO oprDTO) {
//		this.createView.promptForPrint(oprDTO);
//	}
//
//	public void confirmLogin(OperatoerDTO oprDTO) {
//		this.admView.confirmLogin(oprDTO);
//	}
}
