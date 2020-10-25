package connection;
 
import java.util.ArrayList; 
import java.util.List;

import provider.IFactory;

public class GeneratorFactory {
	private List<IFactory> listFactories;
	private String path;

	public GeneratorFactory(String path) {
		listFactories = new ArrayList<IFactory>();
		this.path= path;
	}
	
	public List<IFactory> loadFactories(List<String> classesToLoad){
		MyClassLoader mecanismos = new MyClassLoader();
		//Se castea automáticamente a IFactory en la asignación!!
		listFactories =mecanismos.load(this.path, classesToLoad);
		return listFactories;
	}
	
}
