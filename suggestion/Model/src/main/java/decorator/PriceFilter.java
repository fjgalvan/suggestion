package decorator;

import java.util.ArrayList;  
import java.util.HashMap; 
import java.util.List;
import java.util.Map;
import provider.ProductsBo;
import provider.Suggestions;

public class PriceFilter extends SuggestionDecorator {
	String chosenPrice;
	List<Suggestions> listSuggestion;
	public Map<String, Double> map ;
	
	public PriceFilter(IFilter filter, String chosenPrice) {
		super(filter);
		map = new HashMap<String, Double>();
		init();
		this.chosenPrice= chosenPrice;
	}

	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		return addPriceFilter(chosenPrice, super.getSuggestions(lista));
	}
	
	private List<Suggestions> addPriceFilter(String chosenPrice, List<Suggestions> lista){
		List<Suggestions> listaAux=new ArrayList<Suggestions>();;
		for(Suggestions item : lista) {
			if(isValue(chosenPrice, item.getPrecio())){
				listaAux.add(item);
			}
		}
		return listaAux;
		
	}
	public void init(){
		ProductsBo products= new ProductsBo();
		this.map= products.getPrices();
	}
	public boolean isValue(String claveElegido, Double valor){
		return (valor <= map.get(claveElegido));
	}
}
