package decorator;

import java.util.Iterator;
import java.util.List;

import model.IProvider;
import model.Suggestions;

public class PriceFilter extends SuggestionDecorator {
	String chosenPrice;
	
	public PriceFilter(IProvider provider, String chosenPrice) {
		super(provider);
		this.chosenPrice= chosenPrice;
	}

	@Override
	public List<Suggestions> getSuggestions() {
		listSuggestion = super.getSuggestions();
		listSuggestion = addPriceFilter( this.chosenPrice);
		return listSuggestion;
	}

	private List<Suggestions> addPriceFilter(String chosenPrice) {
		int count=0;
		Iterator<Suggestions> it = listSuggestion.iterator();
		while(it.hasNext()){
			Suggestions item=it.next();
			if(!isValue(chosenPrice, item.getProducto())){
				listSuggestion.remove(count);
			}
			count = count +1;
		}
		return listSuggestion;
	}
}
