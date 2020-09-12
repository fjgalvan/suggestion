package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import connection.CollectorConnection;
import model.Model;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("MAIN!!");
        Model m = new Model();
        ViewApp v = new ViewApp(m);
        //m.addObserver(v);
		ControllerApp c = new ControllerApp(m,v);
		v.setVisible(true);
		
		init();
		JPanelGeneral pGeneral= new JPanelGeneral();
		v.nuevoPanel(pGeneral.createPanel());
		v.loadProviders(listProviders());
		//pGeneral.search(panel, config);
	}
	
	public static void init(){
		listProviders();
		listPanels();
		//listConfigPanels();
	}
	
	public static List<String> listProviders(){
		List<String> lp = new ArrayList<String>();
		lp.add("twitter.TwitterProvider");
		lp.add("excel.ExcelProvider");

		CollectorConnection connector = new CollectorConnection();
		connector.loadConnectors(lp);
				
		List<String> ls = new ArrayList<String>(); 
		for(int i = 0; i < connector.getConnectors().size(); i++) {
			ls.add(connector.getConnectors().get(i).getClass().getName().toString());
		}
		return ls;
	}
	
	public static List<String> listPanels(){
		List<String> lp = new ArrayList<String>();
		lp.add("configuration.TwitterPanel");
		lp.add("configuration.ExcelPanel");

		CollectorPanel connector = new CollectorPanel();
		connector.loadPanel(lp);
				
		List<String> ls = new ArrayList<String>(); 
		for(int i = 0; i < connector.getPanel().size(); i++) {
			ls.add(connector.getPanel().get(i).getClass().getName().toString());
		}
		return ls;
	}
	
	public static List<String> listConfigPanels(){
		List<String> lp = new ArrayList<String>();
		lp.add("configuration.TwitterConfiguration");
		lp.add("configuration.ExcelConfiguration");

		CollectorConfiguration connector = new CollectorConfiguration();
		connector.loadConfi(lp);
				
		List<String> ls = new ArrayList<String>(); 
		for(int i = 0; i < connector.getConfig().size(); i++) {
			ls.add(connector.getConfig().get(i).getClass().getName().toString());
		}
		return ls;
	}
	
	
}
