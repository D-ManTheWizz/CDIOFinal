package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeRaavareView extends Composite {

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
	private ChangeRaavare RaavareMenu;
	String Raavare_ID;
	String Raavare_Name;
	String Supplier;
	String Amount;
	
	
	public ChangeRaavareView(ChangeRaavare RaavareMenu){
		initWidget(this.vPanel);
		this.RaavareMenu = RaavareMenu;
		
		Label lbl1 = new Label("Search Raavare ID Or Raavare Name");
		hPanel.add(lbl1);
		vPanel.add(hPanel);
		this.txt3 = new TextBox();
		vPanel.add(this.txt3);
		
		Button searchBtn = new Button("Search");
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
		
		Raavare_ID = "10";
		Raavare_Name = "Cheese";
		Supplier = "Arla";
		Amount = "10";
		
		this.lbl2 = new Label("Change Raavare With ID " + Raavare_ID);
		this.vPanelChange.add(lbl2);
		this.txt1 = new TextBox();
		txt1.setText(Raavare_ID);
		vPanelChange.add(this.txt1);
		
		this.lbl2 = new Label("Raavare Name " + Raavare_Name); 
		this.vPanelChange.add(lbl2);
		this.txt2 = new TextBox();
		txt2.setText(Raavare_Name);
		vPanelChange.add(this.txt2);
		
		this.lbl2 = new Label("Supplier " + Supplier);
		this.vPanelChange.add(lbl2);
		this.txt3 = new TextBox();
		txt3.setText(Supplier);
		vPanelChange.add(this.txt3);
		
		this.lbl2 = new Label("Amount " + Amount); 
		this.vPanelChange.add(lbl2);
		this.txt4 = new TextBox();
		txt4.setText(Amount);
		vPanelChange.add(this.txt4);

		Button yesBtn = new Button("Change");
		yesBtn.addClickHandler(new changeClickHandler());
		this.hPanelChange.add(yesBtn);
		
		Button noBtn = new Button("Cancel");
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

		}		
	}
	private class changeClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			changeSucces();
		}

	
	}
}