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

public class CreateUserView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private VerticalPanel vPanelCMenu = new VerticalPanel();
	private VerticalPanel vPanelError = new VerticalPanel();
	private DialogBox dBox;
	private int i;
	private ListBox listBox1;
	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt3;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
	private Label lbl4;
	private Label dBoxlbl;
	//private popUp popup;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	@SuppressWarnings("unused")
	private CreateUser createUser;
	String User_ID;
	String UserName;
	String CPR;
	String Role;
	
	public CreateUserView() {
		initWidget(vPanel);
	
		vPanel.add(hPanel);
		this.lbl1 = new Label("Indtast Brugerens ID");
		vPanelCMenu.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanelCMenu.add(this.txt1);
		
		this.lbl2 = new Label("Indtast Brugerens Navn");
		vPanelCMenu.add(this.lbl2);	
		this.txt2 = new TextBox();
		vPanelCMenu.add(this.txt2);
		
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
	
	private void popUp() {
	    dBox = new DialogBox();
		VerticalPanel dBoxvPanel = new VerticalPanel();
		HorizontalPanel dBoxhPanel = new HorizontalPanel();
		dBox.setWidget(dBoxvPanel);
		dBox.setGlassEnabled(true);
	    dBox.setAnimationEnabled(true);
	    dBox.center();
	    
	    dBoxvPanel.setSpacing(4);
	    
		if(i == 0){
			Role = "Operatoer";
		}
		else if (i == 1)
			Role = "Vaerkfoerer";
		else if (i == 2)
			Role = "Farmaceut";
		else if (i == 3)
			Role = "Administrator";
	     
		dBoxlbl = new Label("Er du sikker paa at du vil oprette en " + Role + " med foelgende information:");		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("ID " + User_ID);		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("Brugernavn " + UserName);		
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
	  			dBox.hide();
				new Popup().center();
	          }
	        });
		
	    dBoxhPanel.add(yesButton);
	    dBoxhPanel.setCellHorizontalAlignment(yesButton, HasHorizontalAlignment.ALIGN_CENTER);
	    dBoxhPanel.add(cancelButton);
	    dBoxhPanel.setCellHorizontalAlignment(cancelButton, HasHorizontalAlignment.ALIGN_CENTER);
	    dBoxvPanel.add(dBoxhPanel);
		dBox.show();	
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
	}
	
	private class Popup extends PopupPanel{
		VerticalPanel vPanelCon = new VerticalPanel();
		public Popup(){
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
	
	public class okClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			User_ID = txt1.getText();
			UserName = txt2.getText();
			CPR = txt3.getText();
			i = listBox1.getSelectedIndex();
			
			if(User_ID.isEmpty()==false && UserName.isEmpty()==false && CPR.isEmpty()==false){
				popUp();
			}
			else
			noCreateSucces();
		}
	}
	
	public class cancelClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
		}
	}
}