package model;

import java.util.List;
import decorator.BasicFilter;
import decorator.FoodFilter;
import decorator.IFilter;
import decorator.PriceFilter;

public class Model {
	private IProvider provider;
	ProviderManager pm;
	public List<Suggestions> list;
	
	public Model(){
		pm = new ProviderManager();
		
	}
	
	public void inicializar() {
		// Leo todos los Productos que tengo en ProductosBo
		ProductsBo pBo = new ProductsBo();
		pBo.getListaDeProductos();
	}
	
	public List<Suggestions> getSuggestion(){
		this.list= this.provider.getSuggestions();
		return this.list;
	}
	
	public void setProvider(IProvider p){
		this.provider= p;
	}

	public IProvider getProvider() {
		return provider;
	}
	
	public List<Suggestions> getFilteredSuggestions(String chooseFood,String choosePrice){
		IFilter bf= new BasicFilter();
		this.list=bf.getSuggestions(this.list);
		
		IFilter sf= new FoodFilter(bf,chooseFood);
		this.list= sf.getSuggestions(this.list);
		System.out.println("FoodFilter: "+ this.list.size());
		
		IFilter sp= new PriceFilter(sf,choosePrice);
		this.list= sp.getSuggestions(this.list);
		System.out.println("PriceFilter: "+ this.list.size());
		
		return this.list;
	}
}
