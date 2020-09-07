package connection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.IProvider;

public class CollectorConnection {
	private List<IProvider> listConnector;
	ConnectorSearcher search;

	public CollectorConnection() {
		search = new ConnectorSearcher();
		listConnector = new ArrayList<IProvider>();
	}
	
	public List<IProvider> loadConnectors(){
		MyClassLoader mecanismos = new MyClassLoader();
		//Se castea automáticamente a IConector en la asignación!!
		listConnector.add(mecanismos.load("C:\\MecanismosDeConexionExterna","twitter.TwitterProvider"));//(search.getPath()); 
		return listConnector;
	}

	public void connectAll() 
			throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		Iterator<IProvider> it = listConnector.iterator();
		while (it.hasNext()) {
			IProvider instance = it.next();
			instance.getSuggestions();
		}
	}
	
	public List<IProvider> getConnectors() {
		return listConnector;
	}
	public static void main( String[] args ) throws ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalAccessException
    {
        System.out.println( "Hello World!" );
        CollectorConnection connector= new CollectorConnection();
        connector.loadConnectors();
        
        System.out.println(connector.getConnectors().get(0).getClass().getName().toString());
    }
}
