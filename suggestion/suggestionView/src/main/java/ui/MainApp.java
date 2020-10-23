package ui;

import java.util.ArrayList;      
import java.util.List;
import model.Model;

public class MainApp {

	public static void main(String[] args) {
		Model m = new Model();
		ViewApp v = new ViewApp();
		List<String> listFactoriesName = new ArrayList<String>();
		listFactoriesName.add("configuration.TwitterFactory");
		listFactoriesName.add("configuration.ExcelFactory");
		ControllerApp c = new ControllerApp(m, v);
		c.init(listFactoriesName);
	}

	
}
