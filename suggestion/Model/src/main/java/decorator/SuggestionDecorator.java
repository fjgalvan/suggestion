package decorator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.IProvider;
import model.Suggestions;

public abstract class SuggestionDecorator implements IProvider{
	private final IProvider provider;
	public Map<String, String> map ;
	List<Suggestions> listSuggestion;
	
	public SuggestionDecorator(IProvider provider){
		this.provider= provider;
		map = new HashMap<String, String>();
		init();
	}
	
	@Override
	public List<Suggestions> getSuggestions() {
		listSuggestion=this.provider.getSuggestions();
		return listSuggestion;
	}
	
	public void init(){
		map.put("chatarras", "hamburguesa,pancho,pizza");
		map.put("postres", "flan,gelatina,helado");
		map.put("sanas", "ensalada,pollo,sopa");
		map.put("pastas", "canelones,fideos,ravioles");
	}
	
	public boolean isValue(String claveElegido, String valor){
		Iterator<String> it = map.keySet().iterator();
		boolean res= false;
		while(it.hasNext()){
			String key = it.next();
			System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
			if((map.get(key).contains(valor)) && (key.equals(claveElegido))){
				res= true;
				break;
			}
		}
		return res;
	}
}
