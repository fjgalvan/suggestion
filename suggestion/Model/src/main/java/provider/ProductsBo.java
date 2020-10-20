package provider;

import java.util.HashMap;
import java.util.Map;


public class ProductsBo {
	private Map<String, String> mapFoods ;
	private Map<String, Double> mapPrices ;
	
	public ProductsBo(){
		mapFoods = new HashMap<String, String>();
		mapPrices = new HashMap<String, Double>();
	}
	
	
	public Map<String, String> getFoods(){
		mapFoods.put("chatarras", "hamburguesa,pancho,pizza");
		mapFoods.put("postres", "flan,gelatina,helado");
		mapFoods.put("sanas", "ensalada,pollo,sopa");
		mapFoods.put("pastas", "canelones,fideos,ravioles");
		return mapFoods;
	}
	
	public Map<String, Double> getPrices(){
		mapPrices.put("bajo", 200.0);
		mapPrices.put("medio", 1000.0);
		mapPrices.put("grande", 3000.0);
		return mapPrices;
	}
	
	
}
