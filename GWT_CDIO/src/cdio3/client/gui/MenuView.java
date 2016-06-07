package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class MenuView extends Composite {
	private HorizontalPanel hPanel = new HorizontalPanel();
	private MainView main;
	
	public MenuView(MainView main){
		initWidget(this.hPanel);
		this.main = main;
		
		Button admBtn = new Button("Admin Menu");
		admBtn.addClickHandler(new admClickHandler());
		this.hPanel.add(admBtn);
		
		Button passBtn = new Button("Change Your Password");
		passBtn.addClickHandler(new passClickHandler());
		this.hPanel.add(passBtn);
		
		Button weighBtn = new Button("Weigh A Product");
		weighBtn.addClickHandler(new weighClickHandler());
		this.hPanel.add(weighBtn);
	}
	
	private class admClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			main.openAdminMenu();
		}
	}
	
	private class passClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			main.openPassMenu();
		}
	}
	
	private class weighClickHandler implements ClickHandler{
		
		@Override
		public void onClick(ClickEvent event) {
			main.openWeighMenu();
		}
	}
}
