package decorator;

import java.util.List; 
import provider.Suggestions;

public class BasicFilter implements IFilter{
	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		return lista;
	}


}
