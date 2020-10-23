package model;
  
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
	private GeneratorFactory factory;
	
	public Model(){
		this.factory = new GeneratorFactory();
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
		IFilter bf= new BasicFilter();
		IFilter sf= new FoodFilter(bf,chooseFood);
		IFilter sp= new PriceFilter(sf,choosePrice);
		return sp.getSuggestions(this.provider.getSuggestions());
	}
}
