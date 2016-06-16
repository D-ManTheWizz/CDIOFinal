package cdio3.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;



public class ShowUserView extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel vPanelCMenu = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();

	private DialogBox dBox;
	private int i;
	private ListBox listBox1;
	private Label lbl1;
	private Label dBoxlbl;
	boolean CPRContainNumbers = false;
	boolean createOperator = false;
	private ShowUser showUser;
	private String Role;
	private String User_ID;
	private String UserName;
	private String CPR;
	
	public ShowUserView() {
		initWidget(vPanel);
	this.showUser = showUser;
//	Label txt = new Label("Create New Operator Menu");
//	hPanel.add(txt);
	
	this.lbl1 = new Label("User Table");
	vPanelCMenu.add(this.lbl1);	
	
    listBox1 = new ListBox();
    listBox1.addItem("Operator, Ole");
    listBox1.addItem("Foreman, Ford");
    listBox1.addItem("Pharmacist, Phil");
    listBox1.addItem("Administrator, Admin Jensen");
    listBox1.setVisibleItemCount(1);
	hPanel.add(listBox1);
	
	
	Button infoBtn = new Button("Show Info");
	infoBtn.addClickHandler(new infoClickHandler());
	this.hPanel.add(infoBtn);
	
	this.vPanelCMenu.add(hPanel);
	this.vPanel.add(vPanelCMenu);
	}
	private void popUp() {
	    dBox = new DialogBox();
		VerticalPanel dBoxvPanel = new VerticalPanel();
		dBox.setWidget(dBoxvPanel);
		dBox.setGlassEnabled(true);
	    dBox.setAnimationEnabled(true);
	    dBox.center();
	    
	    dBoxvPanel.setSpacing(2);
	    
		if(i == 0){
			Role = "Operatoer";
		}
		else if (i == 1)
			Role = "Vaerkfoerer";
		else if (i == 2)
			Role = "Farmaceut";
		else if (i == 3)
			Role = "Administrator";
	    
	    
		dBoxlbl = new Label("Rolle " + Role);		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("ID " + User_ID);		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("Brugernavn " + UserName);		
		dBoxvPanel.add(dBoxlbl);
		dBoxlbl = new Label("CPR " + CPR);		
		dBoxvPanel.add(dBoxlbl);
	    
	    Button cancelButton = new Button("Luk", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	        	  dBox.hide();
	          }
	        });
		
	    dBoxvPanel.add(cancelButton);
	    dBoxvPanel.setCellVerticalAlignment(cancelButton, HasVerticalAlignment.ALIGN_MIDDLE);
		dBox.show();	
	}
	public class infoClickHandler implements ClickHandler {
		
		@Override
		public void onClick(ClickEvent event) {
//			for (i=0; i<listBox1.getItemCount(); i++){
//				if (i == listBox1.getSelectedIndex()){
//					mypop.center();
//					mypop.setAutoHideEnabled(false);
//				}
//					
//			}
			i = listBox1.getVisibleItemCount();
			popUp();
		}

	}

}
