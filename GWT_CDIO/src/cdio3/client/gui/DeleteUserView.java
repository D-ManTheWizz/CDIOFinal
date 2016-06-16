package cdio3.client.gui;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DeleteUserView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private HorizontalPanel hPanelChange = new HorizontalPanel();
	private VerticalPanel vPanelChange = new VerticalPanel();
	private VerticalPanel vPanelError = new VerticalPanel();
	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt3;
	private Label dBoxlbl;
	private DialogBox dBox;
	private Label lbl1;
	private Label lbl2;
	private DeleteUser deleteUser;
	String User_ID = "10";
	String User_Name = "Ole";
	String CPR = "100194-1111";
	String Role = "Operatoer";
	
	
	public DeleteUserView(DeleteUser changeUser){
		initWidget(this.vPanel);
		this.deleteUser = deleteUser;
		
		Label lbl1 = new Label("Indtast Bruger ID eller Bruger Navn");
		vPanel.add(lbl1);
		this.txt3 = new TextBox();
		hPanel.add(this.txt3);
		
		Button searchBtn = new Button("Soeg");
		searchBtn.addClickHandler(new searchClickHandler());
		this.hPanel.add(searchBtn);
		vPanel.add(hPanel);
		
	}

	public void createSucces(){
		
		this.vPanelChange.clear();
		this.hPanelChange.clear();
		this.vPanelError.clear();
		
		this.lbl1 = new Label("Bruger ID " + User_ID);
		this.vPanelChange.add(lbl1);
		
		this.lbl1 = new Label("Bruger Navn " + User_Name); 
		this.vPanelChange.add(lbl1);
		
		this.lbl1 = new Label("CPR " + CPR);
		this.vPanelChange.add(lbl1);
		
		this.lbl1 = new Label("Rolle " + Role); 
		this.vPanelChange.add(lbl1);

		Button yesBtn = new Button("Slet Bruger");
		yesBtn.addClickHandler(new deleteClickHandler());
		this.hPanelChange.add(yesBtn);
		
		Button noBtn = new Button("Annuller");
		noBtn.addClickHandler(new cancelClickHandler());
		this.hPanelChange.add(noBtn);
		
		this.vPanel.add(vPanelChange);
		this.vPanel.add(hPanelChange);			
	}
	
	public void noCreateSucces(){
		this.lbl2 = new Label("Soegning Fejlede");
		this.vPanelError.add(lbl2);
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
	    
	    
		dBoxlbl = new Label("Er du sikker paa at du vil SLETTE følgende " + Role + "?");		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("ID " + User_ID);		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("Brugernavn " +User_Name);		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("CPR " + CPR);		
		dBoxvPanel.add(dBoxlbl);
		
	    Button cancelButton = new Button("Luk", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	        	  dBox.hide();
	          }
	        });
	    Button yesButton = new Button("Slet Bruger", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	  			dBox.hide();
				new Popup("Brugeren er Slettet").center();
				User_ID ="";
				User_Name = "";
				CPR = "";
				Role = "";
				createSucces();
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
		public Popup(String popTxt){
			super(true);
			lbl1 = new Label(popTxt);
			this.vPanelCon.add(lbl1);
			lbl1 = new Label(" ");
			this.vPanelCon.add(lbl1);
			lbl1 = new Label(" - Click udenfor dette Popup for at lukke det - ");
			this.vPanelCon.add(lbl1);
			setWidget(vPanelCon);
		}
	}
	
	private class searchClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
				createSucces();
		}		
	}
	private class cancelClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
		}		
	}
	private class deleteClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if (User_ID.isEmpty()==false)
					popUp();
		
		else{
			new Popup("Der er ingen Bruger at Slette").center();
		}
	
	}
}
}
