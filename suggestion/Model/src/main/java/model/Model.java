package model;

import java.util.ArrayList; 
import java.util.List;
import decorator.BasicFilter;
import decorator.FoodFilter;
import decorator.IFilter;
import decorator.PriceFilter;

public class Model {
	private IProvider provider;
	private String providerName="";
	ProviderManager pm;
	public List<Suggestions> list;
	private List<Suggestions> aux;
	
	public Model(){
		list= new ArrayList<Suggestions>();
		aux= new ArrayList<Suggestions>();
		pm = new ProviderManager();
		
	}
	
	public void inicializar() {
		// Leo todos los Productos que tengo en ProductosBo
		ProductsBo pBo = new ProductsBo();
		pBo.getListaDeProductos();
	}
	
	public List<Suggestions> getSuggestion(){
		if(this.list.isEmpty() || !(providerName.equals(this.provider.getClass().getName()))){
			this.list.clear();
			this.list= this.provider.getSuggestions();
			this.aux= this.list;
			providerName=this.provider.getClass().getName();
		}else{
			this.list= this.aux;
		}
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
		IFilter sf= new FoodFilter(bf,chooseFood);
		IFilter sp= new PriceFilter(sf,choosePrice);
		this.list= sp.getSuggestions(sf.getSuggestions(bf.getSuggestions(this.list)));
		
		return this.list;
	}
}
