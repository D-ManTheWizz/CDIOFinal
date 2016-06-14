package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RaavareBatchView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private VerticalPanel vPanelCMenu = new VerticalPanel();
	private VerticalPanel vPanelError = new VerticalPanel();
	private VerticalPanel vPanelChange = new VerticalPanel();
	private HorizontalPanel hPanelChange = new HorizontalPanel();

	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt3;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
	private Label lbl4;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	private ProductBatchMenu pbMenu;
	String RB_ID;
	String Raavare_ID;
	String Amount;
	public RaavareBatchView() {
		initWidget(vPanel);
	this.pbMenu = pbMenu;
//	Label txt = new Label("Create New Operator Menu");
//	hPanel.add(txt);
	vPanel.add(hPanel);
	this.lbl1 = new Label("Enter Raavare Batch ID");
	vPanelCMenu.add(this.lbl1);	
	this.txt1 = new TextBox();
	vPanelCMenu.add(this.txt1);
	
	this.lbl2 = new Label("Enter Raavare ID");
	vPanelCMenu.add(this.lbl2);	
	this.txt2 = new TextBox();
	vPanelCMenu.add(this.txt2);
	
	this.lbl3 = new Label("Enter Amount");
	vPanelCMenu.add(this.lbl3);	
	this.txt3 = new TextBox();
	vPanelCMenu.add(this.txt3);
	
	Button okBtn = new Button("OK");
	okBtn.addClickHandler(new okClickHandler());
	this.hPanel.add(okBtn);
	
	Button cancelBtn = new Button("Cancel");
	cancelBtn.addClickHandler(new cancelClickHandler());
	this.hPanel.add(cancelBtn);
	
	this.vPanelCMenu.add(hPanel);
	this.vPanel.add(vPanelCMenu);
}
	
	public void createSucces(){
		this.vPanelChange.clear();
		this.hPanelChange.clear();
		this.vPanelError.clear();
		
		this.lbl2 = new Label("Are You Sure You Want To Create Raavare Batch With ID " + RB_ID);
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("Raavare ID " + Raavare_ID); //get operator name
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("Amount " + Amount); //get operator name
		this.vPanelChange.add(lbl2);

		Button yesBtn = new Button("Yes");
		yesBtn.addClickHandler(new yesClickHandler());
		this.hPanelChange.add(yesBtn);
		
		Button noBtn = new Button("No");
		noBtn.addClickHandler(new noClickHandler());
		this.hPanelChange.add(noBtn);
		
		this.vPanel.add(vPanelChange);
		this.vPanel.add(hPanelChange);
		
		this.txt1.setText("");
		this.txt2.setText("");
		this.txt3.setText("");

		
		
	}
	public void noCreateSucces(){
		this.lbl3 = new Label("Raavare Batch Creation Unsuccesfull");
		this.vPanelError.add(lbl3);
		this.vPanel.add(vPanelError);
	}
	
	
	
	public class okClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			RB_ID = txt1.getText();
			Raavare_ID = txt2.getText();
			Amount = txt3.getText();

			
			if(RB_ID.isEmpty()==false && Raavare_ID.isEmpty()==false && Amount.isEmpty()==false){
				createSucces();			
			}
			else
			noCreateSucces();
		}

	}
	public class cancelClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			
		}

	}
	public class yesClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			
		}

	}
	public class noClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			
		}

	}
}
