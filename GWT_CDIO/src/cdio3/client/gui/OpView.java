package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.shared.OperatoerDTO;

public class OpView extends Composite {
	private String PasswordOld;
	private String PasswordNew1;
	private String PasswordNew2;
	
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private HorizontalPanel h2Panel = new HorizontalPanel();
	private HorizontalPanel hPanelChange = new HorizontalPanel();
	private VerticalPanel vPanelChange = new VerticalPanel();
	
	private PasswordTextBox txt2;
	private PasswordTextBox txt3;
	private PasswordTextBox txt4;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3 = new Label("");
	
	private MainView main;
	private OperatoerDTO operatingOperator;
	
	public OpView(MainView main, OperatoerDTO operatingOperator){
		initWidget(this.vPanel);
		this.main = main;
		this.operatingOperator = operatingOperator;
		
		Label txt = new Label("Aendre dit Password");
		hPanel.add(txt);
		vPanel.add(hPanel);
		
		this.lbl1 = new Label("Indtast gammelt Password");
		vPanel.add(this.lbl1);	
		this.txt2 = new PasswordTextBox();
		vPanel.add(this.txt2);
		
		this.lbl1 = new Label("Indtast nyt Password");
		vPanel.add(this.lbl1);	
		this.txt3 = new PasswordTextBox();
		vPanel.add(this.txt3);
		
		this.lbl1 = new Label("Indtast nyt Password igen");
		vPanel.add(this.lbl1);	
		this.txt4 = new PasswordTextBox();
		vPanel.add(this.txt4);
		
		Button changeBtn = new Button("Aendre Password");
		changeBtn.addClickHandler(new passwordClickHandler());
		this.h2Panel.add(changeBtn);
		
		Button deleteBtn = new Button("Slet tekst");
		deleteBtn.addClickHandler(new deleteClickHandler());
		this.h2Panel.add(deleteBtn);
		vPanel.add(h2Panel);
		
		vPanel.add(lbl3);
	}

	public void createSucces(){
		this.vPanelChange.clear();
		this.hPanelChange.clear();
		
		this.lbl2 = new Label("Er du sikker paa at du vil aendre dit Password");
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("");
		this.vPanelChange.add(lbl2);

		Button yesBtn = new Button("Ja");
		yesBtn.addClickHandler(new yesClickHandler());
		this.hPanelChange.add(yesBtn);
		
		Button noBtn = new Button("Nej");
		noBtn.addClickHandler(new noClickHandler());
		this.hPanelChange.add(noBtn);
		
		this.vPanel.add(vPanelChange);
		this.vPanel.add(hPanelChange);
		
		clearText();
	}
	
	private void notSameNewPasswords(){
		this.lbl3.setText("Du indtastede ikke samme Password 2 gange i traek");
		this.vPanel.add(lbl3);
		clearText();
	}
	
	private void notSameOldPassword(){
		this.lbl3.setText("Du indtastede et forkert Password, proev igen eller kontakt systemadministratoren");
		this.vPanel.add(lbl3);
		clearText();
	}
	
	private void getText() {
		this.PasswordOld = txt2.getText();
		this.PasswordNew1 = txt3.getText();
		this.PasswordNew2 = txt4.getText();
	}
	
	private void clearText() {
		this.txt2.setText("");
		this.txt3.setText("");
		this.txt4.setText("");
	}
	
	private void clearLbl3() {
		this.lbl3.setText("");
	}
	
	private void clearChangePanels() {
		this.vPanelChange.clear();
		this.hPanelChange.clear();
	}
	
	private void popUp() {
	    DialogBox dBox = new DialogBox();
		VerticalPanel dBoxPanel = new VerticalPanel();
		Label dBoxlbl = new Label();
		
		dBox.setText("Dit Password blev IKKE aendret.");
	    dBoxlbl.setText("Dit Password blev IKKE aendret.");
	    dBoxPanel.add(dBoxlbl);
	    dBox.add(dBoxPanel);
	    dBox.setGlassEnabled(true);
	    dBox.setAnimationEnabled(true);
	    dBox.center();
		dBox.show();	
		
		
//		popUp.passwordNotChangedPopup();    
	}
	
	private boolean validateInput() {
		if(this.operatingOperator.getPassword() == this.PasswordOld) {
			if(this.PasswordNew1 == this.PasswordNew2) {
				return true;
			}
			notSameNewPasswords();
			return false;
		}
		notSameOldPassword();
		return false;
	}
	
	
	private class yesClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			
		}		
	}
	
	private class noClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			clearChangePanels();
			popUp();
		}		
	}
	
	private class passwordClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			clearLbl3();
			getText();
			
			if(validateInput()) {
				createSucces();
			} else {
				// Nothing!
			}
		}
	}
	
	private class deleteClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			clearText();
		}		
	}
}
