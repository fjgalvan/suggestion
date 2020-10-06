package decorator;

import java.util.HashMap; 
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import model.Suggestions;

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
		return addPriceFilter(chosenPrice, super.getSuggestions(lista));//llamo a lo filtro anterior!!
	}
	
	private List<Suggestions> addPriceFilter(String chosenFood, List<Suggestions> lista){
		for(Suggestions item : lista) {
			if(!isValue(chosenFood, item.getPrecio())){
				lista.remove(item);
			}
		}
		return lista;
		
	}
	public void init(){
		map.put("bajo", 200.0);
		map.put("medio", 1000.0);
		map.put("grande", 3000.0);
	}
	public boolean isValue(String claveElegido, Double valor){
		return (valor <= map.get(claveElegido));
	}
}
