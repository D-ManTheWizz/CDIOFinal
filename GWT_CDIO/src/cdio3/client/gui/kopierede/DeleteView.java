package cdio3.client.gui.kopierede;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DeleteView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private TextBox txt1;
	private Label lbl1;
	private Label lbl2;
	private Label lbl3;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	String firstName;
	String lastName;
	String ID;
	
	private MainView main;
	private DeleteMenu deleteMenu;
	
	public DeleteView(DeleteMenu deleteMenu, MainView main){
		initWidget(vPanel);
		this.main = main;
		this.deleteMenu = deleteMenu;
		
		this.lbl1 = new Label("Enter Operator ID");
		vPanel.add(this.lbl1);	
		this.txt1 = new TextBox();
		vPanel.add(this.txt1);
		
		
		Button deleteBtn = new Button("Delete Operator");
		deleteBtn.addClickHandler(new deleteClickHandler());
		this.vPanel.add(deleteBtn);

	}

	public void deleteRequest(){
		this.lbl2 = new Label("Are You Sure You Want To Delete Operator With ID: " + ID);
		this.vPanel.add(lbl2);
		this.lbl2 = new Label("Name: "); //get operator name
		this.vPanel.add(lbl2);

		Button yesBtn = new Button("Yes");
		yesBtn.addClickHandler(new yesClickHandler());
		this.hPanel.add(yesBtn);
		
		Button noBtn = new Button("No");
		noBtn.addClickHandler(new noClickHandler());
		this.hPanel.add(noBtn);
		
		this.vPanel.add(hPanel);
		
		this.txt1.setText("");
	}
	
	public void noDeleteSucces(){
		this.lbl3 = new Label("Operator Creation Unsuccesfull");
		this.vPanel.add(lbl3);
	}
	
	private class yesClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			deleteOperator(ID);
		}		
	}
	
	private class noClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			noDeleteSucces();
		}		
	}
	
	private class deleteClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			ID = txt1.getText();

			if(ID.isEmpty()==false){
				deleteRequest();			
			}
			else
				noDeleteSucces();
		}
	}
	
	private void deleteOperator(String ID) {
		main.deleteOperator(ID);
	}

	public void deleted() {
		this.lbl2.setText("DELETED!");
	}
}
