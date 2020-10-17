package decorator;

import java.util.ArrayList;
import java.util.HashMap; 
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
		System.out.println("\nPriceFilter");
	}

	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		return addPriceFilter(chosenPrice, super.getSuggestions(lista));//llamo a lo filtro anterior!!
	}
	
	private List<Suggestions> addPriceFilter(String chosenFood, List<Suggestions> lista){
		List<Suggestions> listaAux=new ArrayList<Suggestions>();;
		for(Suggestions item : lista) {
			if(!isValue(chosenFood, item.getPrecio())){
				//System.out.println("item borrado: "+item.getPrecio());
				//lista.remove(item);
			}else{
				//System.out.println("item OK: "+item.getProducto());
				listaAux.add(item);
			}
		}
		return listaAux;
		
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
