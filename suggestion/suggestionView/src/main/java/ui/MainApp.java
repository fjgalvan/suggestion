package ui;

import java.util.ArrayList;      
import java.util.List;
import model.SuggestionsService;

public class MainApp {
	public static void main(String[] args) {
		SuggestionsService m = new SuggestionsService("C:\\MecanismosDeConexionExterna");
		ViewApp v = new ViewApp();
		List<String> listFactoriesName = new ArrayList<String>();
		listFactoriesName.add("configuration.TwitterFactory");
		listFactoriesName.add("configuration.ExcelFactory");
		ControllerApp c = new ControllerApp(m, v);
		c.init(listFactoriesName);
	}
}
