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

public class ChangeUserView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private HorizontalPanel hPanelChange = new HorizontalPanel();
	private VerticalPanel vPanelChange = new VerticalPanel();
	private VerticalPanel vPanelError = new VerticalPanel();
	private TextBox txt1 = new TextBox();
	private TextBox txt2 = new TextBox();
	private TextBox txt3;
	private TextBox txt4 = new TextBox();
	private Label dBoxlbl;
	private DialogBox dBox;
	private int i;
	private Label lbl1;
	private Label lbl2;
	private ListBox listBox1;
	
	private MainView main;
	
	String User_IdOld = "10";
	String User_IdNew;
	String User_NameOld = "Ole";
	String User_NameNew;
	String CPROld = "100194-1111";
	String CPRNew;
	String RoleOld = "Operat�r";
	String RoleNew;
		
	public ChangeUserView(MainView main){
		initWidget(this.vPanel);
		this.main = main;
		
		Label lbl1 = new Label("Indtast Bruger ID eller Bruger Navn (fulde navn).");
		vPanel.add(lbl1);
		this.txt3 = new TextBox();
		hPanel.add(this.txt3);
		
		Button searchBtn = new Button("Soeg");
		searchBtn.addClickHandler(new searchClickHandler());
		this.hPanel.add(searchBtn);
		vPanel.add(hPanel);		
	}

	public void setFoundOpr(OperatoerDTO foundOprDTO){		
		this.vPanelChange.clear();
		this.hPanelChange.clear();
		this.vPanelError.clear();
		
		int stilling = foundOprDTO.getStilling();
		listBox1 = new ListBox();
	    listBox1.addItem("Operatoer");
	    listBox1.addItem("Vaerkfoerer");
	    listBox1.addItem("Farmaceut");
	    listBox1.addItem("Administrator");
	    listBox1.setVisibleItemCount(1);
	    listBox1.setItemSelected(stilling-1, true);
	    String rolle = new String(listBox1.getItemText(stilling-1));
		
		this.lbl1 = new Label("Bruger ID: " + foundOprDTO.getOprId());
		this.vPanelChange.add(lbl1);
		this.txt1 = new TextBox();
		txt1.setText("No " + foundOprDTO.getOprId());
		vPanelChange.add(this.txt1);
		
		this.lbl1 = new Label("Bruger Navn: " + foundOprDTO.getOprNavn()); 
		this.vPanelChange.add(lbl1);
		this.txt2 = new TextBox();
		txt2.setText(foundOprDTO.getOprNavn());
		vPanelChange.add(this.txt2);
		
		this.lbl1 = new Label("CPR: " + foundOprDTO.getCpr());
		this.vPanelChange.add(lbl1);
		this.txt4 = new TextBox();
		txt4.setText(foundOprDTO.getCpr());
		vPanelChange.add(this.txt4);
		
		this.lbl1 = new Label(); 
		lbl1.setText("Rolle: " + rolle);
		this.vPanelChange.add(lbl1);

		vPanelChange.add(listBox1);
		
		Button yesBtn = new Button("Ret Bruger");
		yesBtn.addClickHandler(new changeClickHandler());
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
		VerticalPanel dBoxvPanelPop1 = new VerticalPanel();
		VerticalPanel dBoxvPanelPop2 = new VerticalPanel();
		HorizontalPanel dBoxhPanel = new HorizontalPanel();
		HorizontalPanel dBoxhPanelPop = new HorizontalPanel();
		dBox.setWidget(dBoxvPanel);
		dBox.setGlassEnabled(true);
	    dBox.setAnimationEnabled(true);
	    dBox.center();
	    
	    dBoxvPanel.setSpacing(4);
	    	    
		dBoxlbl = new Label("Er du sikker paa at du vil rette en " + RoleOld + " med foelgende information");		
		dBoxvPanelPop1.add(dBoxlbl);
		dBoxlbl = new Label("ID " + User_IdOld);		
		dBoxvPanelPop1.add(dBoxlbl);
		dBoxlbl = new Label("Brugernavn " +User_NameOld);		
		dBoxvPanelPop1.add(dBoxlbl);
		dBoxlbl = new Label("CPR " + CPROld);		
		dBoxvPanelPop1.add(dBoxlbl);
		
		dBoxhPanelPop.add(dBoxvPanelPop1);
		
		i = listBox1.getSelectedIndex();
		
		if(i == 0){
			RoleNew = "Operatoer";
		}
		else if (i == 1)
			RoleNew = "Vaerkfoerer";
		else if (i == 2)
			RoleNew = "Farmaceut";
		else if (i == 3)
			RoleNew = "Administrator";
		User_IdNew = txt1.getText();
		User_NameNew = txt2.getText();
		CPRNew = txt3.getText();
		
		dBoxlbl = new Label("Til en " + RoleNew + " med foelgende information");		
		dBoxvPanelPop2.add(dBoxlbl);
		dBoxlbl = new Label("ID " + User_IdNew);		
		dBoxvPanelPop2.add(dBoxlbl);
		dBoxlbl = new Label("Brugernavn " + User_NameNew);		
		dBoxvPanelPop2.add(dBoxlbl);
		dBoxlbl = new Label("CPR " + CPRNew);		
		dBoxvPanelPop2.add(dBoxlbl);
	    
		dBoxhPanelPop.add(dBoxvPanelPop2);
		
		dBoxvPanel.add(dBoxhPanelPop);
		
	    Button cancelButton = new Button("Luk", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	        	  dBox.hide();
	          }
	        });
	    
	    Button yesButton = new Button("Ret Bruger", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	  			dBox.hide();
				new Popup().center();
				User_IdOld = User_IdNew;
				User_NameOld = User_NameNew;
				CPROld = CPRNew;
				RoleOld = RoleNew;
//				createSucces();
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
	
	private class Popup extends PopupPanel{
		VerticalPanel vPanelCon = new VerticalPanel();
		public Popup(){
			super(true);
			lbl1 = new Label("Brugeren er rettet");
			this.vPanelCon.add(lbl1);
			lbl1 = new Label(" ");
			this.vPanelCon.add(lbl1);
			lbl1 = new Label(" - Click udenfor dette Popup for at lukke det - ");
			this.vPanelCon.add(lbl1);
			setWidget(vPanelCon);
		}
	}
	
	private void clearText() {
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
	}
	
	private void searchAndSet() {
		String searchString = new String(this.txt3.getText());
		clearText();	
		this.main.getOperator(this, searchString);
	}
	
	public void getOperatorReturn(OperatoerDTO foundOprDTO) {
		setFoundOpr(foundOprDTO);
	}
	
	
	private class searchClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			searchAndSet();
		}		
	}
	
	private class cancelClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			clearText();
		}		
	}
	
	private class changeClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			popUp();
		}
	}
}