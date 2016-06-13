package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel vPanelLoggedIn = new VerticalPanel();
	private HorizontalPanel hPanelLoggedIn = new HorizontalPanel();
	private TextBox txt1;
	private PasswordTextBox txt2;
	private Label lbl1;
	private Label lbl2;
	boolean login = false;
	
	private MainView main;
	private Login loginMenu;
	
	public LoginView(Login loginMenu, MainView main){
		initWidget(vPanel);
		this.main = main;
		this.loginMenu = loginMenu;
		
		this.lbl1 = new Label("Admin Menu");
		vPanel.add(lbl1);
		
		this.lbl1 = new Label("Enter Operator-ID");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanel.add(this.txt1);
		
		this.lbl1 = new Label("Enter Operator Password");
		vPanel.add(this.lbl1);	
		this.txt2 = new PasswordTextBox();
		vPanel.add(this.txt2);
		
		Button loginBtn = new Button("Login");
		loginBtn.addClickHandler(new loginClickHandler());
		this.vPanel.add(loginBtn);

	}

	public void loginSucces(){
		this.vPanelLoggedIn.clear();
		this.hPanelLoggedIn.clear();
		
		this.login = true;
		this.lbl2 = new Label("Login Succesful");
		this.vPanelLoggedIn.add(lbl2);
		this.txt1.setText("");
		this.txt2.setText("");
		
		vPanel.add(vPanelLoggedIn);
		vPanel.add(hPanelLoggedIn);
	}
	
	public void loggedIn(){
		this.txt1.setText("");
		this.txt2.setText("");
	}
	
	
	private class loginClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			String ID = txt1.getText();
			String Password = txt2.getText();
			if(login){
				loggedIn();
			}
			else if(ID.equals("10") && Password.equals("1234")){
				loginSucces();
				loginMenu.openMenu(1);	
				
			}
			else if(ID.equals("11") && Password.equals("1234")){	
				loginSucces();
				loginMenu.openMenu(2);	
			}
			else if(ID.equals("12") && Password.equals("1234")){	
				loginSucces();
				loginMenu.openMenu(3);	
			}
			else if(ID.equals("13") && Password.equals("1234")){
				loginSucces();
				loginMenu.openMenu(4);	
			}
			
		}
		
	}
}
