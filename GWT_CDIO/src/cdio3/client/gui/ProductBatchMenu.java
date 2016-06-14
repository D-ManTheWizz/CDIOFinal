package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProductBatchMenu extends Composite{

	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public ProductBatchMenu(){
		initWidget(vPanel);
		
		ProductBatchView pbView = new ProductBatchView();
		this.vPanel.add(pbView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}
