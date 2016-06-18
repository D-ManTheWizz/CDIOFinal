package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateUser extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	
	private boolean testing = false;
	
	private MainView main;

	public CreateUser(MainView main){
		initWidget(vPanel);
		this.main = main;
		
		CreateUserView createUserView = new CreateUserView(this.main);
		this.vPanel.add(createUserView);
		
		if(testing) {
			this.main.layoutPanel_3.clear();
			
			Button test_btn1 = new Button("setForkertBruger", new ClickHandler() {
				public void onClick(ClickEvent event) {
					
				}
		    });
			this.main.layoutPanel_3.add(test_btn1);
		}
	}
	public void setTesting() {testing = true;}
}