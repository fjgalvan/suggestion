package decorator;

import java.util.Iterator;
import java.util.List;

import model.IProvider;
import model.Suggestions;

public class FoodFilter extends SuggestionDecorator{
	String chosenFood;
	
	public FoodFilter(IProvider provider, String chosenFood) {
		super(provider);
		this.chosenFood= chosenFood;
	}
	
	@Override
	public List<Suggestions> getSuggestions() {
		listSuggestion= super.getSuggestions();
		listSuggestion= addFoodFilter(this.chosenFood);
		return listSuggestion;
	}
	
	private List<Suggestions> addFoodFilter(String chosenFood){
		int count=0;
		Iterator<Suggestions> it = listSuggestion.iterator();
		while(it.hasNext()){
			Suggestions item=it.next();
			if(!isValue(chosenFood, item.getProducto())){
				listSuggestion.remove(count);
			}
			count = count +1;
		}
		return listSuggestion;
		
	}
}
