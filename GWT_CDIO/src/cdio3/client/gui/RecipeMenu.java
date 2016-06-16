package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RecipeMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	private MainView main;
	
	public RecipeMenu(MainView main) {
		initWidget(vPanel);
		this.main = main;
		
		RecipeView recipeView = new RecipeView(this.main, this);
		this.vPanel.add(recipeView);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
	}
}