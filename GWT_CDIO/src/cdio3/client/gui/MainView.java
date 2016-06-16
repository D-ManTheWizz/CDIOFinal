package cdio3.client.gui;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.client.events.DataEvent;
import cdio3.client.events.*;
import cdio3.client.service.OperatorServiceClientImpl;
import cdio3.shared.OperatoerDTO;

public class MainView extends Composite {
	private VerticalPanel layoutPanel_1 = new VerticalPanel();
	public Label layoutLabel_1 = new Label();
	private HorizontalPanel layoutPanel_2 = new HorizontalPanel();
	private Label layoutLabel_2 = new Label();
	
	private VerticalPanel v1_Panel = new VerticalPanel();
	private HorizontalPanel h1_in_v1_Panel = new HorizontalPanel();
	private HorizontalPanel h2_in_v1_Panel = new HorizontalPanel();
	
	private OperatoerDTO operatingOperator;
	
	private OperatorServiceClientImpl serviceClientImpl;
	private AdmMenu admMenu;
	private MenuView menu;
	private LoginView loginView;
	private FarmaMenu farmaMenu;
	private CreateUserView createUserView;
	private OpView opView;
	private ChangeUserView changeUserView;
	
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
		} else if(event instanceof UpdatePasswordEvent) {
			updatePasswordReturn(((UpdatePasswordEvent) event).getOprDTO());
		} else if(event instanceof CreateOperatorEvent) {
			createOperatorReturn(((CreateOperatorEvent) event).getAnswer());
		}
	}
	
	private void setClearance(OperatoerDTO oprDTO) {
		if(oprDTO.getStilling() == 666666) {
			loginView.passwordNotValidated();
		} else {
			this.operatingOperator = oprDTO;
			
			this.layoutLabel_1.setText("");
			this.v1_Panel.clear();
	
			menu = new MenuView(this, oprDTO);
			this.h1_in_v1_Panel.add(menu);
			this.v1_Panel.add(h1_in_v1_Panel);
		}
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
	
	public void login(int id, String pass, LoginView loginView) {
		this.loginView = loginView;
		this.serviceClientImpl.login(id, pass);
	}
	
	private void confirmLogin(OperatoerDTO oprDTO) {
		setClearance(oprDTO);
	}
	
	public void updatePassword(OpView opView, OperatoerDTO operatingOperator) {
		this.opView = opView;
		this.serviceClientImpl.updatePassword(this.operatingOperator);
	}
	
	private void updatePasswordReturn(OperatoerDTO oprDTO) {
		this.opView.updatePasswordReturn(oprDTO);		
	}
	
	public void createOperator(CreateUserView createUserView, OperatoerDTO newOprDTO) {
		this.createUserView = createUserView;
		this.serviceClientImpl.createOperator(newOprDTO);
	}
	
	private void createOperatorReturn(boolean answer) {
		this.createUserView.createUserReturn(answer);
	}
	
	public void getOperator(ChangeUserView changeUserView, String searchString) {
		this.changeUserView = changeUserView;
		OperatoerDTO foundOprDTO = new OperatoerDTO(4, "Admin Jensen", "AdJe", "4567-8901", "4567Pass", 4);
		getOperatorReturn(foundOprDTO);
		///////////////////////
	}
	
	private void getOperatorReturn(OperatoerDTO foundOprDTO) {
		this.changeUserView.getOperatorReturn(foundOprDTO);
	}
	
	// Old methods
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
