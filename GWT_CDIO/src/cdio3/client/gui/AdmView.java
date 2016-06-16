package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AdmView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private Label lbl1;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	private AdmMenu admMenu;
	String firstName;
	String lastName;
	String CPR;
	
	public AdmView(AdmMenu admMenu){
		initWidget(this.vPanel);
		this.admMenu = admMenu;
		
//		lbl1.setText("VF Menu");
//		this.vPanel.add(lbl1);
		Button createBtn = new Button("Opret Bruger");
		createBtn.addClickHandler(new createClickHandler());
		hPanel.add(createBtn);
		
		Button changeBtn = new Button("Ret Bruger");
		changeBtn.addClickHandler(new changeClickHandler());
		hPanel.add(changeBtn);
		
		Button deleteBtn = new Button("Slet Bruger");
		deleteBtn.addClickHandler(new deleteClickHandler());
		this.hPanel.add(deleteBtn);
		
		Button showBtn = new Button("Vis Bruger");
		showBtn.addClickHandler(new showClickHandler());
		this.hPanel.add(showBtn);
		
		this.vPanel.add(hPanel);
//		this.vPanelCMenu.add(hPanel);
//		this.vPanel.add(vPanelCMenu);
	}
	

			
			
	private class createClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			admMenu.openCreateMenu();
		}		
	}

	private class changeClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			admMenu.openChangeMenu();
		}		
	}
	
	public class deleteClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			admMenu.openDeleteMenu();

		}

	}
	public class showClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			admMenu.openShowMenu();

		}

	}
}
