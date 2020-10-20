package connection;
 
import java.util.ArrayList; 
import java.util.List;

import provider.IFactory;

public class GeneratorFactory {
	private List<IFactory> listFactories;

	public GeneratorFactory() {
		listFactories = new ArrayList<IFactory>();
	}
	
	public List<IFactory> loadFactories(List<String> classesToLoad){
		MyClassLoader mecanismos = new MyClassLoader();
		//Se castea automáticamente a IConector en la asignación!!
		listFactories =mecanismos.load(ConnectorSearcher.rutaFile, classesToLoad);
		return listFactories;
	}
	
}
