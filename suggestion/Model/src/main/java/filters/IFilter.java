package filters;

import java.util.List; 
import provider.Suggestions;

public interface IFilter {
	List<Suggestions> getSuggestions(List<Suggestions> lista); 
}
