package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.shared.OperatoerDTO;

public class OpMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	
	public OpMenu(MainView main, OperatoerDTO operatingOperator){
		initWidget(vPanel);
		
		OpView passwordView = new OpView(main, operatingOperator);
		this.vPanel.add(passwordView);
	}
}
