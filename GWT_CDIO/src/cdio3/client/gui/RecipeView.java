package cdio3.client.gui;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RecipeView extends Composite {
	private String Recipe_ID;
	private String Recipe_Name;
	
	private HorizontalPanel hPanel_Holding_vPanel = new HorizontalPanel();
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private HorizontalPanel hPanelChange = new HorizontalPanel();
	private VerticalPanel vPanelChange = new VerticalPanel();
	private VerticalPanel vPanelError = new VerticalPanel();
	private VerticalPanel vPanelLabels = new VerticalPanel();
	
	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt4;
	private ListBox listBox;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3 = new Label();
	private Label lbl4 = new Label();
	private Label lbl5 = new Label();

	private ArrayList<String> raavareList = new ArrayList<String>();
	
	@SuppressWarnings("unused")
	private MainView main;
		
	public RecipeView(MainView main){
		initWidget(this.hPanel_Holding_vPanel);
		this.main = main;
		
		this.hPanel_Holding_vPanel.add(vPanel);
		
		Label txt = new Label("Opret en Recept");
		hPanel.add(txt);
		vPanel.add(hPanel);
		
		this.lbl1 = new Label("Indtast Recept ID");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanel.add(this.txt1);
		
		this.lbl1 = new Label("Indtast Recept Navn");
		vPanel.add(this.lbl1);	
		this.txt2 = new TextBox();
		vPanel.add(this.txt2);
		
		this.lbl1 = new Label("Tilfoej Raavare");
		vPanel.add(this.lbl1);	
		
		listBox = new ListBox();
	    listBox.addItem("Vealg en vare");
		listBox.addItem("Vare 0");
	    listBox.addItem("Vare 1");
	    listBox.addItem("Vare 2");
	    listBox.addItem("Vare 3");
	    listBox.addItem("Vare 4");
	    listBox.setVisibleItemCount(1);
		vPanel.add(listBox);
		
		Button addBtn = new Button("Tilfoej Raavare");
		addBtn.addClickHandler(new addRaavareClickHandler());
		this.vPanel.add(addBtn);
		
		Button createBtn = new Button("Opret Recept");
		createBtn.addClickHandler(new okClickHandler());
		this.vPanel.add(createBtn);
		
		this.vPanelError.add(lbl3);
		this.vPanel.add(vPanelError);

		this.vPanelLabels.add(lbl4);
		this.vPanelLabels.add(lbl5);
		this.hPanel_Holding_vPanel.add(vPanelLabels);
	}

	public void createSucces(){
		this.vPanelChange.clear();
		this.hPanelChange.clear();
		this.vPanelError.clear();
		
		this.lbl2 = new Label("Are You Sure You Want To Create Recipe With ID " + Recipe_ID);
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("Recipe Name " + Recipe_Name); 
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("Ingredients ");
		this.vPanelChange.add(lbl2);

		Button yesBtn = new Button("Yes");
		yesBtn.addClickHandler(new yesClickHandler());
		this.hPanelChange.add(yesBtn);
		
		Button noBtn = new Button("No");
		noBtn.addClickHandler(new noClickHandler());
		this.hPanelChange.add(noBtn);
		
		this.vPanel.add(vPanelChange);
		this.vPanel.add(hPanelChange);
		
		this.txt2.setText("");
		this.txt4.setText("");		
	}
	
	public void noCreateSucces(){
		this.lbl3.setText("Recepten blev ikke oprettet");
	}
	
	private void makeRaavareList() {
		this.lbl3.setText("");
		this.lbl4.setText("Raavarer tilfoejet:");
		String raavare = listBox.getSelectedValue();
		
		if(raavare == "Vealg en vare") {
			this.lbl3.setText("Husk at vaelge en vare");
		} else {
			this.raavareList.add(raavare);
			
			String raavarerShown = new String("");
			
			for(String temp : raavareList) {
				raavarerShown = raavarerShown + temp + ", ";
			}
			this.lbl5.setText(raavarerShown);
			listBox.setItemSelected(0, true);
		}
	}
	
	
	private class yesClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			
		}		
	}
	
	private class noClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {

		}		
	}
	
	private class okClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			Recipe_ID = txt1.getText();
			Recipe_Name = txt2.getText();
			
			if(Recipe_ID.isEmpty()==false && Recipe_Name.isEmpty()==false){
				createSucces();	
				//passwordMenu.openPopout();
			}
			else
			noCreateSucces();			
		}	
	}
	
	private class addRaavareClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			makeRaavareList();
		}		
	}
}