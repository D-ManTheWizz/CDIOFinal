package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RecipeView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private HorizontalPanel hPanelChange = new HorizontalPanel();
	private VerticalPanel vPanelChange = new VerticalPanel();
	private VerticalPanel vPanelError = new VerticalPanel();
	private TextBox txt1;
	private TextBox txt2;
	private TextBox txt3;
	private TextBox txt4;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	private RecipeMenu recipeMenu;
	String Recipe_ID;
	String Recipe_Name;
	String Raavare = "";
	
	private MainView main;
	
	
	public RecipeView(MainView main, RecipeMenu recipeMenu){
		initWidget(this.vPanel);
		this.main = main;
		this.recipeMenu = recipeMenu;
		
		Label txt = new Label("Change Your Password Menu");
		hPanel.add(txt);
		vPanel.add(hPanel);
		
		this.lbl1 = new Label("Enter Recipe ID");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanel.add(this.txt1);
		
		this.lbl1 = new Label("Enter Recipe Name");
		vPanel.add(this.lbl1);	
		this.txt2 = new TextBox();
		vPanel.add(this.txt2);
		
		this.lbl1 = new Label("Enter Raavare");
		vPanel.add(this.lbl1);	
		this.txt3 = new TextBox();
		vPanel.add(this.txt3);
		Button addBtn = new Button("Add Raavare To Recipe");
		addBtn.addClickHandler(new addClickHandler());
		this.vPanel.add(addBtn);
		
		

		
		Button createBtn = new Button("Create Recipe");
		createBtn.addClickHandler(new okClickHandler());
		this.vPanel.add(createBtn);
		
	}

	public void createSucces(){
		this.vPanelChange.clear();
		this.hPanelChange.clear();
		this.vPanelError.clear();
		
		this.lbl2 = new Label("Are You Sure You Want To Create Recipe With ID " + Recipe_ID);
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("Recipe Name " + Recipe_Name); 
		this.vPanelChange.add(lbl2);
		this.lbl2 = new Label("Ingredients " + Raavare);
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
		this.txt3.setText("");
		this.txt4.setText("");

		
		
	}
	public void noCreateSucces(){
		this.lbl3 = new Label("Password Change Unsuccesfull");
		this.vPanelError.add(lbl3);
		this.vPanel.add(vPanelError);
	}
	private void RaavareList() {
		lbl2.setText(Raavare);
		this.vPanel.add(lbl1);
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
			
			if(Recipe_ID.isEmpty()==false && Recipe_Name.isEmpty()==false && Raavare.isEmpty()==false){
				createSucces();	
				//passwordMenu.openPopout();
			}
			else
			noCreateSucces();
			
			
		}
		
	}
	private class addClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			Raavare = Raavare + txt3.getText() + " ";
			txt3.setText("");
			RaavareList();
		}

		
	}
}