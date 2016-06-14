//package cdio3.client.gui;
//
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.Label;
////import com.google.gwt.user.client.ui.PopupPanel;
//import com.google.gwt.user.client.ui.SimplePanel;
//import com.google.gwt.user.client.ui.VerticalPanel;
//public class PopupPanel extends SimplePanel{
//	VerticalPanel vPanel = new VerticalPanel();
//	private OpView view;
//	public PopupPanel(){
//		setWidget(new Label("Click outside of this popup to close it"));
//		PopupPanel pPanel = new PopupPanel();	
//		this.view = view;
//		
//		this.lbl2 = new Label("Are You Sure You Want To Change Password");
//		this.vPanelChange.add(lbl2);
//		this.lbl2 = new Label("Old Password " + view.PasswordOld); //get operator name
//		this.vPanelChange.add(lbl2);
//		this.lbl2 = new Label("New Password " + view.PasswordNew1); //get operator name
//		this.vPanelChange.add(lbl2);
//
//		Button yesBtn = new Button("Yes");
//		yesBtn.addClickHandler(new yesClickHandler());
//		this.hPanelChange.add(yesBtn);
//		
//		Button noBtn = new Button("No");
//		noBtn.addClickHandler(new noClickHandler());
//		this.hPanelChange.add(noBtn);
//		
//		this.vPanel.add(vPanelChange);
//		this.vPanel.add(hPanelChange);
//		
//		this.txt2.setText("");
//		this.txt3.setText("");
//		this.txt4.setText("");
//		
//		vPanel.add(pPanel);
//
//	}
//
//}
//private class yesClickHandler implements ClickHandler{
//
//	@Override
//	public void onClick(ClickEvent event) {
//		
//	}		
//}
//
//private class noClickHandler implements ClickHandler{
//
//	@Override
//	public void onClick(ClickEvent event) {
//
//	}		
//}
