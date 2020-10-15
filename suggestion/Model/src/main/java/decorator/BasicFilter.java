package decorator;

import java.util.List;

import model.Suggestions;

public class BasicFilter implements IFilter{
	List<Suggestions> lista;
	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		this.lista=lista;
		return this.lista;
	}


}
