package cdio3.client.gui.kopierede;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PasswordView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private TextBox txt1;
	private PasswordTextBox txt2;
	private PasswordTextBox txt3;
	private PasswordTextBox txt4;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	String PasswordOld;
	String PasswordNew1;
	String PasswordNew2;
	String ID;
	private MainView main;
	
	public PasswordView(MainView main){
		initWidget(this.vPanel);
		this.main = main;
		
		this.lbl1 = new Label("Enter Operator ID");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanel.add(this.txt1);
		
		this.lbl1 = new Label("Enter Old Password");
		vPanel.add(this.lbl1);	
		this.txt2 = new PasswordTextBox();
		vPanel.add(this.txt2);
		
		this.lbl1 = new Label("Enter New Password");
		vPanel.add(this.lbl1);	
		this.txt3 = new PasswordTextBox();
		vPanel.add(this.txt3);
		
		this.lbl1 = new Label("Enter New Password Again");
		vPanel.add(this.lbl1);	
		this.txt4 = new PasswordTextBox();
		vPanel.add(this.txt4);
		
		
		Button deleteBtn = new Button("Change Password");
		deleteBtn.addClickHandler(new passwordClickHandler());
		this.vPanel.add(deleteBtn);
		
	}

	public void createSucces(){
		//this.createOperator = true;
		
		this.lbl2 = new Label("Are You Sure You Want To Change Password");
		this.vPanel.add(lbl2);
		this.lbl2 = new Label("Old Password " + PasswordOld); //get operator name
		this.vPanel.add(lbl2);
		this.lbl2 = new Label("New Password " + PasswordNew1); //get operator name
		this.vPanel.add(lbl2);

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
		this.txt4.setText("");

		
		
	}
	public void noCreateSucces(){
		this.lbl3 = new Label("Password Change Unsuccesfull");
		this.vPanel.add(lbl3);
	}
	public void notSamePassword(){
		this.lbl3 = new Label("You Didn't Enter The Same Password Twice");
		this.vPanel.add(lbl3);
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
	
	private class passwordClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			ID = txt1.getText();
			PasswordOld = txt2.getText();
			PasswordNew1 = txt3.getText();
			PasswordNew2 = txt4.getText();
			
			if(PasswordNew1.equals(PasswordNew2)==false)
				notSamePassword();
			
			if(PasswordNew1.equals(PasswordNew2) && ID.isEmpty()==false && PasswordOld.isEmpty()==false){
				createSucces();			
			}
			else
			noCreateSucces();
			
			
		}
		
	}
}
