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

public class AdminView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private TextBox txt1;
	private PasswordTextBox txt2;
	private Label lbl1;
	private Label lbl2;
	boolean login = false;
	private Button loginBtn;
	
	private AdminMenu adminMenu;
	private MainView main;

	public AdminView(AdminMenu adminMenu, MainView main){
		initWidget(vPanel);
		this.adminMenu = adminMenu;
		this.main = main;
		
		this.lbl1 = new Label("Enter Operator-ID");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanel.add(this.txt1);
		
		this.lbl1 = new Label("Enter Operator Password");
		vPanel.add(this.lbl1);	
		this.txt2 = new PasswordTextBox();
		vPanel.add(this.txt2);
		
		loginBtn = new Button("Login");
		loginBtn.addClickHandler(new loginClickHandler());
		this.vPanel.add(loginBtn);
		

	}

	public void loginSucces(){
		System.out.println("LOGIN SUCCES");
		this.login = true;
		this.lbl2 = new Label("Login Succesful");
		this.vPanel.add(lbl2);
		this.txt1.setText("");
		this.txt2.setText("");
		
		Button createBtn = new Button("Create New Operator");
		createBtn.addClickHandler(new createClickHandler());
		this.hPanel.add(createBtn);
		
		Button changeBtn = new Button("Change Operator Information");
		changeBtn.addClickHandler(new changeClickHandler());
		this.hPanel.add(changeBtn);
		
		Button deleteBtn = new Button("Delete An Operator");
		deleteBtn.addClickHandler(new deleteClickHandler());
		this.hPanel.add(deleteBtn);
		
		vPanel.add(hPanel);
		
	}
	
	private class createClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if(login==true)
			adminMenu.openCreateMenu();
		}		
	}
	
	private class changeClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if(login==true)
			adminMenu.openChangeMenu();			
		}		
	}
	
	private class deleteClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if(login==true)
				adminMenu.openDeleteMenu();	
		}		
	}
	
	private class loginClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			int id = Integer.parseInt(txt1.getText());
			String pass = txt2.getText();
			login(id, pass);				
		}
	}
	
	private void login(int id, String pass) {
		this.main.login(id, pass);
	}
}
