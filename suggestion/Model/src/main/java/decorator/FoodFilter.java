package decorator;

import java.util.ArrayList;
import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import model.Suggestions;

public class FoodFilter extends SuggestionDecorator{
	private String chosenFood;
	private Map<String, String> map ;
	
	public FoodFilter(IFilter filter, String chosenFood) {
		super(filter);
		map = new HashMap<String, String>();
		init();
		this.chosenFood= chosenFood;
	}
	
	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		return addFoodFilter(chosenFood, super.getSuggestions(lista));//llamo a lo filtro anterior!!
	}
	
	private List<Suggestions> addFoodFilter(String chosenFood, List<Suggestions> lista){
		List<Suggestions> aux= new ArrayList<Suggestions>();
		for(Suggestions item : lista) {
			if(isValue(chosenFood, item.getProducto())){
				aux.add(item);
			}
		}
		return aux;
		
	}
	private void init(){
		map.put("chatarras", "hamburguesa,pancho,pizza");
		map.put("postres", "flan,gelatina,helado");
		map.put("sanas", "ensalada,pollo,sopa");
		map.put("pastas", "canelones,fideos,ravioles");
	}
	private boolean isValue(String claveElegido, String valor){
		return (map.get(claveElegido).contains(valor));
	}
}
