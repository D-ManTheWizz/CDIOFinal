package cdio3.client.gui;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeUserView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private HorizontalPanel hPanelChange = new HorizontalPanel();
	private VerticalPanel vPanelChange = new VerticalPanel();
	private VerticalPanel vPanelError = new VerticalPanel();
	private VerticalPanel vPanelChangeSucces = new VerticalPanel();
	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt3;
	private TextBox txt4;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
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
		vPanel.add(this.txt3);
		
		Button searchBtn = new Button("Søg");
		searchBtn.addClickHandler(new searchClickHandler());
		this.hPanel.add(searchBtn);
		
	}

	public void createSucces(){
		
//		this.txt1.setText("");
//		this.txt2.setText("");
//		this.txt3.setText("");
//		this.txt4.setText("");
		
		this.vPanelChange.clear();
		this.hPanelChange.clear();
		this.vPanelError.clear();
		
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


		Button yesBtn = new Button("Ret Bruger");
		yesBtn.addClickHandler(new changeClickHandler());
		this.hPanelChange.add(yesBtn);
		
		Button noBtn = new Button("Annuller");
		noBtn.addClickHandler(new cancelClickHandler());
		this.hPanelChange.add(noBtn);
		
		this.vPanel.add(vPanelChange);
		this.vPanel.add(hPanelChange);			
	}
	
	private void changeSucces() {
		this.txt1.setText("");
		this.txt2.setText("");
		this.txt3.setText("");
		this.txt4.setText("");
		this.lbl3 = new Label("Succesfull Change");
		this.vPanelChangeSucces.add(lbl3);
		this.vPanel.add(vPanelChangeSucces);
		
	}	
	public void noCreateSucces(){
		this.lbl3 = new Label("Unsuccesfull Search");
		this.vPanelError.add(lbl3);
		this.vPanel.add(vPanelError);
	}
	
	private class yesClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			
		}		
	}
	
	private class noClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {

		}		
	}
	
	private class okClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			User_ID = txt1.getText();
			User_Name = txt2.getText();
			CPR = txt3.getText();
			Role = txt4.getText();
			
			if(User_ID.isEmpty()==false && User_Name.isEmpty()==false && CPR.isEmpty()==false && Role.isEmpty()==false){
				createSucces();	
				//passwordMenu.openPopout();
			}
			else
			noCreateSucces();
			
			
		}
		
	}
	private class searchClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			//search for Raavare ID or Raavare Name
			int i = 1;
			if(i==1){
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
			changeSucces();
		}

	
	}
}
