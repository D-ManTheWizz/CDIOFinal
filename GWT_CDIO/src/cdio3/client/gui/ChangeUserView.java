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

public class ChangeUserView extends Composite {

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
	private int i;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
	private ListBox listBox1;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	private ChangeUser changeUser;
	String User_ID;
	String User_Name;
	String CPR;
	String Role;
	
	
	public ChangeUserView(ChangeUser changeUser){
		initWidget(this.vPanel);
		this.changeUser = changeUser;
		
		Label lbl1 = new Label("Indtast Bruger ID eller Bruger Navn");
		hPanel.add(lbl1);
		vPanel.add(hPanel);
		this.txt3 = new TextBox();
		hPanel.add(this.txt3);
		
		Button searchBtn = new Button("Soeg");
		searchBtn.addClickHandler(new searchClickHandler());
		this.hPanel.add(searchBtn);
		
	}

	public void createSucces(){
		
		this.vPanelChange.clear();
		this.hPanelChange.clear();
		this.vPanelError.clear();
		
		//Hardcoded start values
		User_ID = "10";
		User_Name = "Ole";
		CPR = "100194-1111";
		Role = "Operatør";
		
		this.lbl2 = new Label("Bruger ID " + User_ID);
		this.vPanelChange.add(lbl2);
		this.txt1 = new TextBox();
		txt1.setText(User_ID);
		vPanelChange.add(this.txt1);
		
		this.lbl2 = new Label("Bruger Navn " + User_Name); 
		this.vPanelChange.add(lbl2);
		this.txt2 = new TextBox();
		txt2.setText(User_Name);
		vPanelChange.add(this.txt2);
		
		this.lbl2 = new Label("CPR " + CPR);
		this.vPanelChange.add(lbl2);
		this.txt3 = new TextBox();
		txt3.setText(CPR);
		vPanelChange.add(this.txt3);
		
		this.lbl2 = new Label("Rolle " + Role); 
		this.vPanelChange.add(lbl2);
	    listBox1 = new ListBox();
	    listBox1.addItem("Operatoer");
	    listBox1.addItem("Vaerkfoerer");
	    listBox1.addItem("Farmaceut");
	    listBox1.addItem("Administrator");
	    listBox1.setVisibleItemCount(1);
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
		this.lbl3 = new Label("Soegning Fejlede");
		this.vPanelError.add(lbl3);
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
	    
	    
		dBoxlbl = new Label("Er du sikker paa at du vil rette en " + Role + "med foelgende information:");		
		dBoxvPanelPop1.add(dBoxlbl);
		dBoxlbl = new Label("ID " + User_ID);		
		dBoxvPanelPop1.add(dBoxlbl);
		dBoxlbl = new Label("Brugernavn " +User_Name);		
		dBoxvPanelPop1.add(dBoxlbl);
		dBoxlbl = new Label("CPR " + CPR);		
		dBoxvPanelPop1.add(dBoxlbl);
		
		dBoxhPanelPop.add(dBoxvPanelPop1);
		
		i = listBox1.getVisibleItemCount();
		
		if(i == 0){
			Role = "Operatoer";
		}
		else if (i == 1)
			Role = "Vaerkfoerer";
		else if (i == 2)
			Role = "Farmaceut";
		else if (i == 3)
			Role = "Administrator";
		
		dBoxlbl = new Label("Til en " + Role + " med foelgende information");		
		dBoxvPanelPop2.add(dBoxlbl);
		dBoxlbl = new Label("ID " + User_ID);		
		dBoxvPanelPop2.add(dBoxlbl);
		dBoxlbl = new Label("Brugernavn " +User_Name);		
		dBoxvPanelPop2.add(dBoxlbl);
		dBoxlbl = new Label("CPR " + CPR);		
		dBoxvPanelPop2.add(dBoxlbl);
	    
		dBoxhPanelPop.add(dBoxvPanelPop2);
		
		dBoxvPanel.add(dBoxhPanelPop);
		
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
			lbl2 = new Label("Brugeren er rettet");
			this.vPanelCon.add(lbl2);
			lbl2 = new Label(" ");
			this.vPanelCon.add(lbl2);
			lbl2 = new Label(" - Click udenfor dette Popup for at lukke det - ");
			this.vPanelCon.add(lbl2);
			setWidget(vPanelCon);
		}
	}
	
	private class searchClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			//search for Raavare ID or Raavare Name
			int k = 1;
			if(k==1){
				createSucces();
				
			}
			else{
				noCreateSucces();
			}
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
	private class changeClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			popUp();
		}

	
	}
}
