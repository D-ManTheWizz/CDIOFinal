package cdio3.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FarmaMenu extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
			private VerticalPanel contentPanel;
	
	

	
	private MainView main;
//	private FarmaView farmaView;
	private RecipeMenu recipeMenu;
	
	
	
	
	
	
	
	
	
	
	
	public FarmaMenu(MainView main) {
		initWidget(vPanel);
		this.main = main;
		
		RecipeMenu recipeMenu = new RecipeMenu(this.main);
//		FarmaView farmaView = new FarmaView();
		this.vPanel.add(recipeMenu);
	}
}
