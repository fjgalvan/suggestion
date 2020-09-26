package ui;

import java.util.ArrayList;  
import java.util.List;
import java.util.stream.Collectors;
import connection.GeneratorFactory;
import model.IFactory;
import model.Model;

public class MainApp {

	public static void main(String[] args) {
		Model m = new Model();
		ViewApp v = new ViewApp(m);
		
		v.setVisible(true);
		List<IFactory> f= loadFactories();
		
		// CARGO EN EL COMBOBOX
		// Con esta expresiòn lamda STREAM LISTAS de java obtengo 1 elemento de la lista
		v.loadProviders(f.stream().map(i->i.getProviderName()).collect(Collectors.toList()));
		
		ControllerApp c = new ControllerApp(m, v, f);
	}

	private static List<IFactory> loadFactories() {
		List<String> lp = new ArrayList<String>();
		lp.add("configuration.TwitterFactory");
		lp.add("configuration.ExcelFactory");
		GeneratorFactory f = new GeneratorFactory();

		return f.loadFactories(lp);
	}

}
