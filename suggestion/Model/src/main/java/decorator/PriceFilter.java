package decorator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.IProvider;
import model.Suggestions;

public class PriceFilter extends SuggestionDecorator {
	String chosenPrice;
	List<Suggestions> listSuggestion;
	public Map<String, String> map ;
	
	public PriceFilter(IFilter filter, String chosenPrice) {
		super(filter);
		this.chosenPrice= chosenPrice;
	}

	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		
		return null;
	}

//	private List<Suggestions> addPriceFilter(String chosenPrice) {
//		int count=0;
//		Iterator<Suggestions> it = listSuggestion.iterator();
//		while(it.hasNext()){
//			Suggestions item=it.next();
//			if(!isValue(chosenPrice, item.getProducto())){
//				listSuggestion.remove(count);
//			}
//			count = count +1;
//		}
//		return listSuggestion;
//	}
}
