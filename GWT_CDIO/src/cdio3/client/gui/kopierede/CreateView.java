package cdio3.client.gui.kopierede;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.shared.OperatoerDTO;

public class CreateView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt3;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3_1;
	private Label lbl3_2;
	private Label lbl3_3;
	private Label lbl3_4;
	private Label lbl3;
	private Label lbl4;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	String firstName;
	String lastName;
	String CPR;
	
	private MainView main;
	
	public CreateView(MainView main){
		initWidget(vPanel);
		this.main = main;
		
		this.lbl1 = new Label("Enter Operator First Name");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanel.add(this.txt1);
		
		this.lbl2 = new Label("Enter Operator Last Name");
		vPanel.add(this.lbl2);	
		this.txt2 = new TextBox();
		vPanel.add(this.txt2);
		
		this.lbl3 = new Label("Enter Operator CPR");
		vPanel.add(this.lbl3);	
		this.txt3 = new TextBox();
		vPanel.add(this.txt3);
		
		Button createBtn = new Button("Create Operator");
		createBtn.addClickHandler(new createClickHandler());
		this.vPanel.add(createBtn);
	}

	public void createRequest(){
		
		this.lbl3_1 = new Label("Are You Sure You Want To Create Operator");
		this.vPanel.add(lbl3_1);
		this.lbl3_2 = new Label("First Name: " + firstName);
		this.vPanel.add(lbl3_2);
		this.lbl3_3 = new Label("Last Name: " + lastName);
		this.vPanel.add(lbl3_3);
		this.lbl3_4 = new Label("CPR: " + CPR);
		this.vPanel.add(lbl3_4);

		Button yesBtn = new Button("Yes");
		yesBtn.addClickHandler(new yesClickHandler());
		this.hPanel.add(yesBtn);
		
		Button noBtn = new Button("No");
		noBtn.addClickHandler(new noClickHandler());
		this.hPanel.add(noBtn);
		
		this.vPanel.add(hPanel);
		
		this.txt1.setText("");
		this.txt2.setText("");
		this.txt3.setText("");
		
		
	}
	public void noCreateSucces(){
		this.lbl4 = new Label("Operator Creation Unsuccesfull");
		this.vPanel.add(lbl4);
	}
	
	private class yesClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			createOperator();
		}		
	}
	
	private void createOperator() {
		this.main.createOperator(10, firstName, lastName, CPR, 0, this);
	}
	
	private class noClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			noCreateSucces();
		}		
	}
	
	private class createClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			firstName = txt1.getText();
			lastName = txt2.getText();
			CPR = txt3.getText();

			if(firstName.isEmpty()==false && lastName.isEmpty()==false){
				createRequest();			
			}
			else
			noCreateSucces();	
		}
	}

//	public void created() {
//		this.lbl3_1.setText("CREATED!!!");
//	}

	public void promptForPrint(OperatoerDTO result) {
		this.lbl3_1.setText(result.toString());		
	}
}
