package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateRaavareView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private HorizontalPanel hPanelChange = new HorizontalPanel();
	private VerticalPanel vPanelChange = new VerticalPanel();
	private VerticalPanel vPanelError = new VerticalPanel();
	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt3;
	private TextBox txt4;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	private CreateRaavare RaavareMenu;
	String Raavare_ID;
	String Raavare_Name;
	String Supplier;
	String Amount;
	
	
	public CreateRaavareView(CreateRaavare RaavareMenu){
		initWidget(this.vPanel);
		this.RaavareMenu = RaavareMenu;
		
		Label txt = new Label("Change Your Password Menu");
		hPanel.add(txt);
		vPanel.add(hPanel);
		
		this.lbl1 = new Label("Enter Raavare ID");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanel.add(this.txt1);
		
		this.lbl1 = new Label("Enter Raavare Navn");
		vPanel.add(this.lbl1);	
		this.txt2 = new TextBox();
		vPanel.add(this.txt2);
		
		this.lbl1 = new Label("Enter Supplier");
		vPanel.add(this.lbl1);	
		this.txt3 = new TextBox();
		vPanel.add(this.txt3);
		
		this.lbl1 = new Label("Enter Amount");
		vPanel.add(this.lbl1);	
		this.txt4 = new TextBox();
		vPanel.add(this.txt4);
		
		Button deleteBtn = new Button("Create Raavare");
		deleteBtn.addClickHandler(new okClickHandler());
		this.vPanel.add(deleteBtn);
		
	}

	public void createSucces(){
		this.vPanelChange.clear();
		this.hPanelChange.clear();
		this.vPanelError.clear();
		
		this.lbl2 = new Label("Are You Sure You Want To Create Raavare With ID " + Raavare_ID);
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("Raavare Name " + Raavare_Name); 
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("Supplier " + Supplier);
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("Amount " + Amount); 
		this.vPanelChange.add(lbl2);

		Button yesBtn = new Button("Yes");
		yesBtn.addClickHandler(new yesClickHandler());
		this.hPanelChange.add(yesBtn);
		
		Button noBtn = new Button("No");
		noBtn.addClickHandler(new noClickHandler());
		this.hPanelChange.add(noBtn);
		
		this.vPanel.add(vPanelChange);
		this.vPanel.add(hPanelChange);
		
		this.txt2.setText("");
		this.txt3.setText("");
		this.txt4.setText("");

		
		
	}
	public void noCreateSucces(){
		this.lbl3 = new Label("Password Change Unsuccesfull");
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
			Raavare_ID = txt1.getText();
			Raavare_Name = txt2.getText();
			Supplier = txt3.getText();
			Amount = txt4.getText();
			
			if(Raavare_ID.isEmpty()==false && Raavare_Name.isEmpty()==false && Supplier.isEmpty()==false && Amount.isEmpty()==false){
				createSucces();	
				//passwordMenu.openPopout();
			}
			else
			noCreateSucces();
			
			
		}
		
	}
}