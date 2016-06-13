package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.shared.OperatoerDTO;

public class MenuView extends Composite {
	private HorizontalPanel hPanel = new HorizontalPanel();
	private VerticalPanel vPanel = new VerticalPanel();
	private Label lbl1;
	
	private MainView main;
	
	public MenuView(MainView main, OperatoerDTO oprDTO){
		initWidget(this.vPanel);
		this.main = main;
		
		int clearanceLvl = oprDTO.getStilling();
		
		this.lbl1 = new Label("Velkommen " + oprDTO.getOprNavn());
		this.vPanel.add(this.lbl1);	
		
		if (clearanceLvl==1){
			op();
		}
		
		else if (clearanceLvl==2){
			op();
			vf();
		}
		
		else if(clearanceLvl==3){
			op();
			vf();
			farma();
		}
		else if(clearanceLvl==4){
			op();
			vf();
			farma();
			adm();
		}
		this.vPanel.add(this.hPanel);
	}
	
	private void adm() {
		Button admBtn = new Button("Brugeradministration");
		admBtn.addClickHandler(new admClickHandler());
		this.hPanel.add(admBtn);
		
	}

	private void farma() {
		Button farmabtn = new Button("Receptstyring");
		farmabtn.addClickHandler(new farmaClickHandler());
		this.hPanel.add(farmabtn);
		
	}

	private void vf() {
		Button weighBtn = new Button("Lagerstyring");
		weighBtn.addClickHandler(new vfClickHandler());
		this.hPanel.add(weighBtn);
		
	}

	private void op() {
		Button passBtn = new Button("Ændre Password");
		passBtn.addClickHandler(new opClickHandler());
		this.hPanel.add(passBtn);
		
	}
	
	
	private class admClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			openAdminMenu();
		}
	}
	
	private class farmaClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			openFarmaMenu();	
		}
	}
	
	private class vfClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			openVfMenu();	
		}
	}
	
	private class opClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			openOpMenu();	
		}
	}
	
	
	private void openAdminMenu() {
		main.openAdminMenu();
	}
	
	private void openFarmaMenu() {
		main.openFarmaMenu();
	}
	
	private void openVfMenu() {
		main.openVfMenu();
	}
	
	private void openOpMenu() {
		main.openOpMenu();
	}
}
