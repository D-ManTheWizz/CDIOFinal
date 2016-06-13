package cdio3.client.gui;

public class ChangeRaavare extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	public ChangeRaavare(){
		initWidget(vPanel);
		
		ChangeRaavareView createView = new ChangeRaavareView(this);
		this.vPanel.add(createView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}
