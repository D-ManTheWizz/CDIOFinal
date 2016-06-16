package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.shared.OperatoerDTO;

public class CreateUserView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private VerticalPanel vPanelCMenu = new VerticalPanel();
	private VerticalPanel vPanelError = new VerticalPanel();
	private DialogBox dBox;
	private ListBox listBox1;
	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt3;
	private TextBox txt5;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
	private Label lbl4;
	private Label lbl5;
	private Label dBoxlbl;
	
	private int User_ID;
	private String UserFirstName;
	private String UserSurName;
	private String CPR;
	private String Role;
	private int selected;
	
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	
	private MainView main;
	
	public CreateUserView(MainView main) {
		initWidget(vPanel);
		this.main = main;
	
		vPanel.add(hPanel);
		this.lbl1 = new Label("Indtast Brugerens ID");
		vPanelCMenu.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanelCMenu.add(this.txt1);
		
		this.lbl2 = new Label("Indtast Brugerens Fornavn");
		vPanelCMenu.add(this.lbl2);	
		this.txt2 = new TextBox();
		vPanelCMenu.add(this.txt2);
		
		this.lbl5 = new Label("Indtast Brugerens Efternavn");
		vPanelCMenu.add(this.lbl5);	
		this.txt5 = new TextBox();
		vPanelCMenu.add(this.txt5);
		
		this.lbl3 = new Label("Indtast Brugerens CPR-nummer");
		vPanelCMenu.add(this.lbl3);	
		this.txt3 = new TextBox();
		vPanelCMenu.add(this.txt3);
		
		this.lbl4 = new Label("Vaelg Burgerens Rolle");
		vPanelCMenu.add(this.lbl4);	
		
	    listBox1 = new ListBox();
	    listBox1.addItem("Operatoer");
	    listBox1.addItem("Vaerkfoerer");
	    listBox1.addItem("Farmaceut");
	    listBox1.addItem("Administrator");
	    listBox1.setVisibleItemCount(1);
		vPanelCMenu.add(listBox1);
		
		Button okBtn = new Button("Opret");
		okBtn.addClickHandler(new okClickHandler());
		this.hPanel.add(okBtn);
		
		Button cancelBtn = new Button("Annuller");
		cancelBtn.addClickHandler(new cancelClickHandler());
		this.hPanel.add(cancelBtn);
		
		this.vPanelCMenu.add(hPanel);
		this.vPanel.add(vPanelCMenu);
	}
	
	public void noCreateSucces(){
		this.vPanelError.clear();
		this.lbl3 = new Label("Der skete en fejl. Udfyld alle vaerdierne og proev igen");
		this.vPanelError.add(lbl3);
		this.vPanel.add(vPanelError);
	}
	
	private void popUpConfirmAndCreate() {
	    dBox = new DialogBox();
		VerticalPanel dBoxvPanel = new VerticalPanel();
		HorizontalPanel dBoxhPanel = new HorizontalPanel();
		dBox.setWidget(dBoxvPanel);
		dBox.setGlassEnabled(true);
	    dBox.setAnimationEnabled(true);
	    dBox.center();
	    
	    dBoxvPanel.setSpacing(4);
	    
		if(selected == 0){
			Role = "Operatoer";
		}
		else if (selected == 1)
			Role = "Vaerkfoerer";
		else if (selected == 2)
			Role = "Farmaceut";
		else if (selected == 3)
			Role = "Administrator";
	     
		dBoxlbl = new Label("Er du sikker paa at du vil oprette en " + Role + " med foelgende information:");		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("ID " + User_ID);		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("Brugernavn " + UserFirstName + " " + UserSurName);		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("CPR " + CPR);		
		dBoxvPanel.add(dBoxlbl);
	    
	    Button cancelButton = new Button("Luk", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	        	  dBox.hide();
	          }
	        });
	    
	    Button yesButton = new Button("Opret Bruger", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	        	createUser();
	          }
	        });
		
	    dBoxhPanel.add(yesButton);
	    dBoxhPanel.setCellHorizontalAlignment(yesButton, HasHorizontalAlignment.ALIGN_CENTER);
	    dBoxhPanel.add(cancelButton);
	    dBoxhPanel.setCellHorizontalAlignment(cancelButton, HasHorizontalAlignment.ALIGN_CENTER);
	    dBoxvPanel.add(dBoxhPanel);
		dBox.show();	
		clearText();
	}
	
	private void createUser() {
		dBox.hide();
		OperatoerDTO newOprDTO = new OperatoerDTO(User_ID, UserFirstName, UserSurName, CPR, null, selected);
			
		main.createOperator(this, newOprDTO);
	}
	
	private class popUpUserCreated extends PopupPanel{
		VerticalPanel vPanelCon = new VerticalPanel();
		public popUpUserCreated(){
			super(true);
			lbl2 = new Label("Brugeren er oprettet");
			this.vPanelCon.add(lbl2);
			lbl2 = new Label(" ");
			this.vPanelCon.add(lbl2);
			lbl2 = new Label(" - Click udenfor dette Popup for at lukke det - ");
			this.vPanelCon.add(lbl2);
			setWidget(vPanelCon);
		}
	}
	
	private void clearText() {
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
		txt5.setText("");
	}
	
	public void createUserReturn(boolean answer) {
		// Handle the answer here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		new popUpUserCreated().center();
	}
	
	
	public class okClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			User_ID = Integer.parseInt(txt1.getText());
			UserFirstName = txt2.getText();
			UserSurName = txt5.getText();
			CPR = txt3.getText();
			selected = listBox1.getSelectedIndex();
			
			if(!txt1.getText().isEmpty() || !txt2.getText().isEmpty() || !txt5.getText().isEmpty() || !txt3.getText().isEmpty()){
				clearText();
				popUpConfirmAndCreate();
			}
			else
			noCreateSucces();
		}
	}
	
	public class cancelClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			clearText();
		}
	}
}