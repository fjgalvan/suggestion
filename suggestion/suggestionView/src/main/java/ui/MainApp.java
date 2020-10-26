package ui;

import java.util.ArrayList;      
import java.util.List;
import model.SuggestionsService;

public class MainApp {
	public static void main(String[] args) {
		SuggestionsService modelService = new SuggestionsService("C:\\MecanismosDeConexionExterna");
		ViewApp view = new ViewApp();
		List<String> listFactoriesName = new ArrayList<String>();
		listFactoriesName.add("configuration.TwitterFactory");
		listFactoriesName.add("configuration.ExcelFactory");
		ControllerApp controller = new ControllerApp(modelService, view);
		controller.init(listFactoriesName);
	}
}
