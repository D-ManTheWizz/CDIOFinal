package cdio3.client.gui;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.client.events.DataEvent;
import cdio3.client.events.LoginEvent;
import cdio3.client.service.OperatorServiceClientImpl;
import cdio3.shared.OperatoerDTO;

public class MainView extends Composite {
	private VerticalPanel layoutPanel_1 = new VerticalPanel();
	private Label layoutLabel_1 = new Label();
	private HorizontalPanel layoutPanel_2 = new HorizontalPanel();
	private Label layoutLabel_2 = new Label();
	
	private VerticalPanel v1_Panel = new VerticalPanel();
	private HorizontalPanel h1_in_v1_Panel = new HorizontalPanel();
	private HorizontalPanel h2_in_v1_Panel = new HorizontalPanel();
	
	private OperatoerDTO operatingOperator;
	
	private MenuView menu;
	private FarmaMenu farmaMenu;
	private VfMenu vfMenu;
	private OpMenu opMenu;
	private LoginView login;
	
	// Old
	private OperatorServiceClientImpl serviceClientImpl;
	private AdmMenu admMenu;
	
	public MainView(OperatorServiceClientImpl serviceImpl){
		initWidget(this.layoutPanel_1);
		this.serviceClientImpl = serviceImpl;
		int height = Window.getClientHeight();
		int width = Window.getClientWidth();
		int layoutHeight = (height/10);
		int layoutWidth = (width/4);
		
		this.layoutLabel_1.setPixelSize(layoutWidth, layoutHeight);
		this.layoutPanel_1.add(layoutLabel_1);
		this.layoutPanel_1.add(layoutPanel_2);
		this.layoutLabel_2.setPixelSize(layoutWidth, layoutHeight);
		this.layoutPanel_2.add(layoutLabel_2);
		this.layoutPanel_2.add(v1_Panel);
		this.v1_Panel.setBorderWidth(1);

		Login login = new Login(this);
		this.v1_Panel.add(login);
	}
	
	public void handleEvent(DataEvent event) {
		if(event instanceof LoginEvent) {
			confirmLogin(((LoginEvent) event).getOprDTO());
		}
	}
	
	public void setClearance(OperatoerDTO oprDTO) {
		this.operatingOperator = oprDTO;
		
		this.v1_Panel.clear();

		menu = new MenuView(this, oprDTO);
		this.h1_in_v1_Panel.add(menu);
		this.v1_Panel.add(h1_in_v1_Panel);
	}
	
	public void openAdminMenu(){
		this.h2_in_v1_Panel.clear();
		admMenu = new AdmMenu(this);
		this.h2_in_v1_Panel.add(admMenu);
		this.v1_Panel.add(h2_in_v1_Panel);
	}
	
	public void openFarmaMenu(){
		this.h2_in_v1_Panel.clear();
		farmaMenu = new FarmaMenu(this);
		this.h2_in_v1_Panel.add(farmaMenu);
		this.v1_Panel.add(h2_in_v1_Panel);		
	}
	
	public void openVfMenu(){
		this.h2_in_v1_Panel.clear();
		VfMenu vfMenu = new VfMenu(this);
		this.h2_in_v1_Panel.add(vfMenu);
		this.v1_Panel.add(h2_in_v1_Panel);
	}
	
	public void openOpMenu(){
		this.h2_in_v1_Panel.clear();
		OpMenu opMenu = new OpMenu(this, this.operatingOperator);
		this.h2_in_v1_Panel.add(opMenu);
		this.v1_Panel.add(h2_in_v1_Panel);
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
}
