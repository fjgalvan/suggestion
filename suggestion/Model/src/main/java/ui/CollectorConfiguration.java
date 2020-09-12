package ui;

import java.util.List;

import connection.ConnectorSearcher;
import connection.MyClassLoader;

public class CollectorConfiguration {
	private List<IConfiguration> listConfig;
	
	
	public List<IConfiguration> loadConfi(List<String>  classesToLoad) {
		MyClassLoader mecanismos = new MyClassLoader();
		// Se castea automáticamente a IConector en la asignación!!
		listConfig = mecanismos.load(ConnectorSearcher.rutaFile,classesToLoad);
		return listConfig;
	}
	
	public List<IConfiguration> getConfig() {
		return listConfig;
	}
}
