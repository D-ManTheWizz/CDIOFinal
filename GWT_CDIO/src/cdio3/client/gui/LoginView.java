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

import cdio3.shared.OperatoerDTO;

public class LoginView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel vPanelLoggedIn = new VerticalPanel();
	private HorizontalPanel hPanelLoggedIn = new HorizontalPanel();
	public TextBox txt1;
	public PasswordTextBox txt2;
	private Label lbl1;
	private Label lbl2;
	boolean login = false;
	
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

	}

	private class loginClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			int id = Integer.parseInt(txt1.getText());
			String password = txt2.getText();
		
			login(id, password);
		}
	}

	private void login(int id, String password) {
		this.main.login(id, password, this);
	}
}
