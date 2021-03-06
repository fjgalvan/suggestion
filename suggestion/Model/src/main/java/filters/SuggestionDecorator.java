package filters;

import java.util.List; 
import provider.Suggestions;

public abstract class SuggestionDecorator implements IFilter{
	private IFilter filter;
	
	public SuggestionDecorator(IFilter filter){
		this.filter= filter;
	}

	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		return this.filter.getSuggestions(lista);
	}
	
}
