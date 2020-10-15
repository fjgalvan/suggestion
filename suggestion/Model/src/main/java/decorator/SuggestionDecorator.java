package decorator;

import java.util.List;
import model.Suggestions;

public abstract class SuggestionDecorator implements IFilter{
	private final IFilter filter;
	
	public SuggestionDecorator(IFilter filter){
		this.filter= filter;
	}

	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		return this.filter.getSuggestions(lista);
	}
	
}
