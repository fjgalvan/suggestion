package decorator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.IProvider;
import model.Suggestions;

public class FoodFilter extends SuggestionDecorator{
	String chosenFood;
	public Map<String, String> map ;
	
	public FoodFilter(IFilter filter, String chosenFood) {
		super(filter);
		map = new HashMap<String, String>();
		init();
		this.chosenFood= chosenFood;
	}
	
	@Override
	public List<Suggestions> getSuggestions(List<Suggestions> lista) {
		return addFoodFilter(chosenFood, super.getSuggestions(lista));//llamo a lo filtro anterior!!
	}
	
	private List<Suggestions> addFoodFilter(String chosenFood, List<Suggestions> lista){
		for(Suggestions item : lista) {
			if(!isValue(chosenFood, item.getProducto())){
				lista.remove(item);
			}
		}
		return lista;
		
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
