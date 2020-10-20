package model;

import java.util.ArrayList;   
import java.util.List;

import connection.GeneratorFactory;
import provider.IFactory;
import provider.IProvider;
import provider.Suggestions;
import decorator.BasicFilter;
import decorator.FoodFilter;
import decorator.IFilter;
import decorator.PriceFilter;

public class Model {
	private IProvider provider;
	private String providerName="";
	private List<Suggestions> listSuggestions;
	private List<Suggestions> auxListSuggestions;
	private GeneratorFactory factory;
	
	public Model(){
		this.listSuggestions= new ArrayList<Suggestions>();
		this.auxListSuggestions= new ArrayList<Suggestions>();
		this.factory = new GeneratorFactory();
	}
	
	
	public List<IFactory> initFactories(List<String>  listFactories) {
		return this.factory.loadFactories(listFactories);
	}
	
	public List<Suggestions> getSuggestion(){
		if(this.listSuggestions.isEmpty() || !(this.providerName.equals(this.provider.getClass().getName()))){
			this.listSuggestions.clear();
			this.listSuggestions= this.provider.getSuggestions();
			this.auxListSuggestions= this.listSuggestions;
			this.providerName=this.provider.getClass().getName();
		}else{
			this.listSuggestions= this.auxListSuggestions;
		}
		return this.listSuggestions;
	}
	
	public void setProvider(IProvider p){
		this.provider= p;
	}

	public IProvider getProvider() {
		return provider;
	}
	
	public List<Suggestions> getFilteredSuggestions(String chooseFood,String choosePrice){
		IFilter bf= new BasicFilter();
		IFilter sf= new FoodFilter(bf,chooseFood);
		IFilter sp= new PriceFilter(sf,choosePrice);
		this.listSuggestions= sp.getSuggestions(sf.getSuggestions(bf.getSuggestions(this.listSuggestions)));
		return this.listSuggestions;
	}
}
