package model;

import java.util.ArrayList;
import java.util.List;


public class ProviderManager {
	public ArrayList<IProvider> listaDeConectores;
	//public IPersistence persistence;
	public ArrayList<Suggestions> listSuggestionsExtern;
	
	public ProviderManager(){
		listaDeConectores = new ArrayList<IProvider>();
		listSuggestionsExtern= new ArrayList<Suggestions>();
	}
	
	public void inicializar(){
		//cargar dinámicamente las promos
	}

	
	public List<IProvider> getProviders(){
		return listaDeConectores;
	}
	

	
}