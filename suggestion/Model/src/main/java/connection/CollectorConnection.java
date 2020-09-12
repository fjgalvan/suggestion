package connection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.IProvider;

public class CollectorConnection {
	private List<IProvider> listConnector;


	public CollectorConnection() {

		listConnector = new ArrayList<IProvider>();
	}
	
	public List<IProvider> loadConnectors(List<String> classesToLoad){
		MyClassLoader mecanismos = new MyClassLoader();
		//Se castea automáticamente a IConector en la asignación!!
		listConnector =mecanismos.load(ConnectorSearcher.rutaFile, classesToLoad);
		return listConnector;
	}

//	public void connectAll() 
//			throws IllegalAccessException,
//			IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException {
//		Iterator<IProvider> it = listConnector.iterator();
//		while (it.hasNext()) {
//			IProvider instance = it.next();
//			instance.getSuggestions();
//		}
//	}
	
	public List<IProvider> getConnectors() {
		return listConnector;
	}
	public static void main( String[] args ) throws ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalAccessException
    {
        System.out.println( "Hello World!" );
        List<String> classesToLoad= new ArrayList<String>();
        classesToLoad.add("twitter.TwitterProvider");
        classesToLoad.add("excel.ExcelProvider");
        
        CollectorConnection connector= new CollectorConnection();
        connector.loadConnectors(classesToLoad);
        
        System.out.println(connector.getConnectors().get(1).getClass().getName().toString());
        //connector.connectAll();
        
        
        
    }
}
