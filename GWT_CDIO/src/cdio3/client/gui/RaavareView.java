package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RaavareView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private Label lbl1;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	private RaavareMenu farmaMenu;
	String firstName;
	String lastName;
	String CPR;
	
	public RaavareView(RaavareMenu farmaMenu){
		initWidget(this.vPanel);
		this.farmaMenu = farmaMenu;
		
//		lbl1.setText("VF Menu");
//		this.vPanel.add(lbl1);
		Button raavareBtn = new Button("Create Raavare");
		raavareBtn.addClickHandler(new createClickHandler());
		hPanel.add(raavareBtn);
		
		Button receptBtn = new Button("Change Raavare");
		receptBtn.addClickHandler(new changeClickHandler());
		hPanel.add(receptBtn);
		
		Button productBtn = new Button("Show Raavare");
		productBtn.addClickHandler(new showRListClickHandler());
		this.hPanel.add(productBtn);
		
		this.vPanel.add(hPanel);
//		this.vPanelCMenu.add(hPanel);
//		this.vPanel.add(vPanelCMenu);
	}
	
			
			
	private class showRListClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			//vfMenu.openPBMenu();
		}		
	}

	private class changeClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			farmaMenu.openChangeMenu();
		}		
	}
	
	public class createClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			farmaMenu.openCreateMenu();

		}

	}
}
