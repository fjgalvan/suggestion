package model;
  
import java.util.List;

import connection.GeneratorFactory;
import provider.IFactory;
import provider.IProvider;
import provider.Suggestions;
import filters.BasicFilter;
import filters.FoodFilter;
import filters.IFilter;
import filters.PriceFilter;

public class SuggestionsService {
	private IProvider provider;
	private GeneratorFactory factory;
	
	public SuggestionsService(String path){
		this.factory = new GeneratorFactory(path);
	}
	
	public List<IFactory> initFactories(List<String>  listFactories) {
		return this.factory.loadFactories(listFactories);
	}
	public void setProvider(IProvider p){
		this.provider= p;
	}
	public IProvider getProvider() {
		return provider;
	}
	public List<Suggestions> getFilteredSuggestions(String chooseFood,String choosePrice){
		IFilter basic = new BasicFilter();
		IFilter food = null;
		IFilter price = null;
		IFilter suggestionsFilter = basic;
		if(chooseFood!=null){
			food= new FoodFilter(basic,chooseFood);
			suggestionsFilter= food;
		}
		if(choosePrice!=null){
			if(food != null){
				price= new PriceFilter(food,choosePrice);
			}else{
				price= new PriceFilter(basic,choosePrice);
			}
			suggestionsFilter = price; 
		}
		return suggestionsFilter.getSuggestions(this.provider.getSuggestions());
	}
}
