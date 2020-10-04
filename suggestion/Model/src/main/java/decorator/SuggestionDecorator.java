package decorator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.IProvider;
import model.Suggestions;

public abstract class SuggestionDecorator implements IFilter{
	private final IFilter filter;
	
	public SuggestionDecorator(IFilter filter){
		this.filter= filter;
	}

	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		// TODO Auto-generated method stub
		return this.filter.getSuggestions(lista);
	}
	
}
