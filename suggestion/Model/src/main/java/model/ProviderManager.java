package model;

import java.util.ArrayList;
import java.util.List;

import connection.ConnectorSearcher;
import connection.MyClassLoader;


public class ProviderManager {
	public ArrayList<Suggestions> listSuggestionsExtern;
	
	public ProviderManager(){
		listSuggestionsExtern= new ArrayList<Suggestions>();
	}
	
	public IProvider loadProvider(String classesToLoad){
		List<String> l= new ArrayList<>();
		l.add(classesToLoad);
		MyClassLoader mecanismos = new MyClassLoader();
		//Se castea automáticamente a IConector en la asignación!!
		return (IProvider) mecanismos.load(ConnectorSearcher.rutaFile, l);
	}

	

	
}