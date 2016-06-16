package cdio3.client.gui;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class VfView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private Label lbl1;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	
	private MainView main;
	private VfMenu vfMenu;
	String firstName;
	String lastName;
	String CPR;
	
	public VfView(MainView main, VfMenu vfMenu){
		initWidget(this.vPanel);
		this.main = main;
		this.vfMenu = vfMenu;
		
//		lbl1.setText("VF Menu");
//		this.vPanel.add(lbl1);
		Button raavareBtn = new Button("Raavare List");
		raavareBtn.addClickHandler(new raavareClickHandler());
		hPanel.add(raavareBtn);
		
		Button receptBtn = new Button("Create Raavare Batch");
		receptBtn.addClickHandler(new receptClickHandler());
		hPanel.add(receptBtn);
		
		Button productBtn = new Button("Create Product Batch");
		productBtn.addClickHandler(new productClickHandler());
		this.hPanel.add(productBtn);
		
		this.vPanel.add(hPanel);
//		this.vPanelCMenu.add(hPanel);
//		this.vPanel.add(vPanelCMenu);
	}
			
			
	private class productClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			vfMenu.openPBMenu();
		}		
	}

	private class receptClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			vfMenu.openRBMenu();
		}		
	}
	
	public class raavareClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			vfMenu.openShowRMenu();
		}
	}
}