package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	public TextBox txt1;
	public PasswordTextBox txt2;
	private Label lbl1;
	private boolean testing = true;
	
	private DialogBox notValidatedBox;
	
	private MainView main;
	
	public LoginView(MainView main){
		initWidget(vPanel);
		this.main = main;
		this.lbl1 = new Label("Login");
		vPanel.add(lbl1);
		
		this.lbl1 = new Label("Indtast Operatoer-ID");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		this.txt1.setText("4");
		vPanel.add(this.txt1);
		
		this.lbl1 = new Label("Indtast Operatoer Password");
		vPanel.add(this.lbl1);	
		this.txt2 = new PasswordTextBox();
		this.txt2.setText("4567Pass");
		vPanel.add(this.txt2);
		
		Button loginBtn = new Button("Login");
		loginBtn.addClickHandler(new loginClickHandler());
		this.vPanel.add(loginBtn);
		
		if(testing) {
			setTesting();
		}
	}

	private class loginClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			int id = Integer.parseInt(txt1.getText());
			String password = txt2.getText();
		
			login(id, password);
		}
	}
	
	private void setTesting() {
		Button test_btn1 = new Button("setForkertPassword()", new ClickHandler() {
			public void onClick(ClickEvent event) {
				txt1.setText("4");
				txt2.setText("ForkertPass");
			}
	    });

		Button test_btn2 = new Button("setRigtigtPassword()", new ClickHandler() {
			public void onClick(ClickEvent event) {
				txt1.setText("4");
				txt2.setText("4567Pass");
			}
	    });
		
		this.main.layoutPanel_3.add(test_btn1);
		this.main.layoutPanel_3.add(test_btn2);
	}

	private void login(int id, String password) {
		this.main.login(id, password, this);
	}

	public void passwordNotValidated() {

		notValidatedBox = new DialogBox();
		VerticalPanel dBoxPanel = new VerticalPanel();
		notValidatedBox.setWidget(dBoxPanel);
		notValidatedBox.setGlassEnabled(true);
		notValidatedBox.setAnimationEnabled(true);
		notValidatedBox.center();
	    
	    dBoxPanel.setSpacing(4);
	    
		Label dBoxlbl = new Label("Det indtastede Id eller password er ikke korrekt.");		
	    dBoxPanel.add(dBoxlbl);
	    
	    Button closeButton = new Button("Luk", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	            closePopUp();
	          }
	        });
	    
	    dBoxPanel.add(closeButton);
	    dBoxPanel.setCellHorizontalAlignment(closeButton, HasHorizontalAlignment.ALIGN_CENTER);
	    notValidatedBox.show();
	}
	
	private void closePopUp() {
		notValidatedBox.hide();
	}
}