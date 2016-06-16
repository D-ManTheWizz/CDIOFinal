package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RecipeMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	
	public RecipeMenu(MainView main) {
		initWidget(vPanel);

		RecipeView recipeView = new RecipeView(main);
		this.vPanel.add(recipeView);
	}
}