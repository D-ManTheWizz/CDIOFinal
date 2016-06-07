package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangeView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt3;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
	private Label lbl4;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	String firstName;
	String lastName;
	String ID;
	
	private MainView main;
	
	public ChangeView(MainView main){
		initWidget(vPanel);
		this.main = main;
		
		this.lbl1 = new Label("Enter Operator ID");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanel.add(this.txt1);
		
		this.lbl2 = new Label("Enter New Operator Firstname");
		vPanel.add(this.lbl2);	
		this.txt2 = new TextBox();
		vPanel.add(this.txt2);
		
		this.lbl3 = new Label("Enter New Operator Lastname");
		vPanel.add(this.lbl3);	
		this.txt3 = new TextBox();
		vPanel.add(this.txt3);
		
		Button changeBtn = new Button("Change Operator");
		changeBtn.addClickHandler(new changeClickHandler());
		this.vPanel.add(changeBtn);
	}

	public void changeRequest(){	
		this.lbl3 = new Label("Are You Sure You Want To Cange Operator With ID: " + ID);
		this.vPanel.add(lbl3);
		this.lbl3 = new Label("To " + firstName + " " + lastName);
		this.vPanel.add(lbl3);

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
	public void noChangeSucces(){
		this.lbl4 = new Label("Operator Creation Unsuccesfull");
		this.vPanel.add(lbl4);
	}
	
	private class yesClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			changeOperator(ID, firstName, lastName);
		}		
	}
	
	private class noClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			noChangeSucces();
		}		
	}
	
	private class changeClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			ID = txt1.getText();
			firstName = txt2.getText();
			lastName = txt3.getText();
			
			if(firstName.isEmpty()==false || lastName.isEmpty()==false || ID.isEmpty()==false){
				changeRequest();
			}
			else
				noChangeSucces();
		}	
	}
	
	private void changeOperator(String ID, String firstName, String lastName) {
		this.main.changeOperator(ID, firstName, lastName);
	}

	public void changed() {
		this.lbl3.setText("CHANGED!");
	}
}
