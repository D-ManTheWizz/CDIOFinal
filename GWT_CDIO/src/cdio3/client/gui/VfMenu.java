package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class VfMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MainView main;
	
	public VfMenu(MainView main){
		initWidget(vPanel);
		this.main = main;
		
		VfView vfView = new VfView(this.main, this);
		this.vPanel.add(vfView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
	
	public void openRBMenu(){
		this.contentPanel.clear();
		RaavareBatchMenu rbMenu = new RaavareBatchMenu();
		this.contentPanel.add(rbMenu);
		
	}
	
	public void openPBMenu(){
		this.contentPanel.clear();
		ProductBatchMenu pbMenu = new ProductBatchMenu();
		this.contentPanel.add(pbMenu);
		
	}
	public void openShowRMenu(){
		this.contentPanel.clear();
		RaavareList showRMenu = new RaavareList();
		this.contentPanel.add(showRMenu);
		
	}
}
