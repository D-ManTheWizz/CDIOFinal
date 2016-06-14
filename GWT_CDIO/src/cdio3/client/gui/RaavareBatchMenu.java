package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RaavareBatchMenu extends Composite{

	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public RaavareBatchMenu(){
		initWidget(vPanel);
		
		RaavareBatchView rbView = new RaavareBatchView();
		this.vPanel.add(rbView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}
