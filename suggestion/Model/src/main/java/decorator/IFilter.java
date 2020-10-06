package decorator;

import java.util.List;

import model.Suggestions;

public interface IFilter {
	List<Suggestions> getSuggestions(List<Suggestions> lista); 
}
