package ui;

import java.util.ArrayList;     
import java.util.List;
import java.util.stream.Collectors;
import provider.IFactory;
import model.Model;

public class MainApp {

	public static void main(String[] args) {
		Model m = new Model();
		ViewApp v = new ViewApp();
		List<String> listFactoriesName = new ArrayList<String>();
		listFactoriesName.add("configuration.TwitterFactory");
		listFactoriesName.add("configuration.ExcelFactory");
		List<IFactory> factories= m.initFactories(listFactoriesName);
		v.loadProviders(factories.stream().map(i->i.getProviderName()).collect(Collectors.toList()));
		ControllerApp c = new ControllerApp(m, v);
		c.init(factories);
		v.setVisible(true);
	}

}
