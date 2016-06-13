package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class OpMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public OpMenu(){
		initWidget(vPanel);
		
		OpView passwordView = new OpView(this);
		this.vPanel.add(passwordView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
	
//	public void openPopout(){
//		this.contentPanel.clear();
//		PopupPanel pop = new PopupPanel();
//		this.contentPanel.add(pop);
//		
//	}
}
