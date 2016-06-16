package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FarmaMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();

	private MainView main;
//	private FarmaView farmaView;

	public FarmaMenu(MainView main) {
		initWidget(vPanel);
		this.main = main;
		
		RecipeMenu recipeMenu = new RecipeMenu(this.main);
//		FarmaView farmaView = new FarmaView(this.main);
		this.vPanel.add(recipeMenu);
	}
}
