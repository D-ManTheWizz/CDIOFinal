package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import cdio3.shared.OperatoerDTO;

public class MenuView extends Composite {
	private HorizontalPanel hPanel = new HorizontalPanel();
	private Label lbl1;
	
	private MainView main;
	
	public MenuView(MainView main, OperatoerDTO oprDTO){
		initWidget(this.hPanel);
		this.main = main;
		
		int clearanceLvl = oprDTO.getStilling();
		
//		this.lbl1 = new Label("Indtast Operatoer-ID: " + oprDTO.getOprNavn());
//		hPanel.add(this.lbl1);	
		
		// New
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
		
		// Old
//		Button admBtn = new Button("Admin Menu");
//		admBtn.addClickHandler(new admClickHandler());
//		this.hPanel.add(admBtn);
//		
//		Button passBtn = new Button("Change Your Password");
//		passBtn.addClickHandler(new passClickHandler());
//		this.hPanel.add(passBtn);
//		
//		Button weighBtn = new Button("Weigh A Product");
//		weighBtn.addClickHandler(new weighClickHandler());
//		this.hPanel.add(weighBtn);
	}
	
	private void adm() {
		Button admBtn = new Button("Admin Menu");
		admBtn.addClickHandler(new admClickHandler());
		this.hPanel.add(admBtn);
		
	}

	private void farma() {
		Button farmabtn = new Button("Farma Menu");
		farmabtn.addClickHandler(new farmaClickHandler());
		this.hPanel.add(farmabtn);
		
	}

	private void vf() {
		Button weighBtn = new Button("Vf Menu");
		weighBtn.addClickHandler(new vfClickHandler());
		this.hPanel.add(weighBtn);
		
	}

	private void op() {
		Button passBtn = new Button("Change Your Password");
		passBtn.addClickHandler(new opClickHandler());
		this.hPanel.add(passBtn);
		
	}
	
	// New ClickHandelers
	private class admClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			main.openAdminMenu();
			
		}
		
	}
	private class farmaClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			main.openFarmaMenu();
			
		}
		
	}
	
	private class vfClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			main.openVfMenu();
			
		}
		
	}
	
	private class opClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			main.openOpMenu();
			
		}
		
	}
	
	// Old ClickHandelers
//	private class admClickHandler implements ClickHandler{
//
//		@Override
//		public void onClick(ClickEvent event) {
//			main.openAdminMenu();
//		}
//	}
//	
//	private class passClickHandler implements ClickHandler{
//
//		@Override
//		public void onClick(ClickEvent event) {
//			main.openPassMenu();
//		}
//	}
//	
//	private class weighClickHandler implements ClickHandler{
//		
//		@Override
//		public void onClick(ClickEvent event) {
//			main.openWeighMenu();
//		}
//	}
}
