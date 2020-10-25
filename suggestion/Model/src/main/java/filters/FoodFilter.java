package filters;

import java.util.ArrayList;  
import java.util.HashMap; 
import java.util.List;
import java.util.Map;
import provider.ProductsBo;
import provider.Suggestions;

public class FoodFilter extends SuggestionDecorator{
	private String chosenFood;
	private Map<String, String> map ;
	
	public FoodFilter(IFilter filter, String chosenFood) {
		super(filter);
		this.map = new HashMap<String, String>();
		init();
		this.chosenFood= chosenFood;
	}
	
	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		return addFoodFilter(this.chosenFood, super.getSuggestions(lista));
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
		ProductsBo products= new ProductsBo();
		this.map= products.getFoods();
	}
	private boolean isValue(String claveElegido, String valor){
		return (this.map.get(claveElegido).contains(valor));
	}
}
