package provider;

import java.util.HashMap;
import java.util.Map;


public class ProductsBo {
	private static final String scrapFood= "chatarras";
	private static final String dessertFood= "postres";
	private static final String healthyFood= "sanas";
	private static final String pastaFood= "pastas";
	private static final String scrapFoodEnabled= "hamburguesa,pancho,pizza";
	private static final String dessertFoodEnabled= "flan,gelatina,helado";
	private static final String healthyFoodEnabled= "ensalada,pollo,sopa";
	private static final String pastaFoodEnabled= "canelones,fideos,ravioles";
	private static final String lowPrice= "bajo";
	private static final String middlePrice= "medio";
	private static final String bigPrice= "grande";
	private static final Double maxLowPrice= 200.0;
	private static final Double maxMiddlePrice= 1000.0;
	private static final Double maxBigPrice= 3000.0;
	private Map<String, String> mapFoods ;
	private Map<String, Double> mapPrices ;
	
	public ProductsBo(){
		mapFoods = new HashMap<String, String>();
		mapPrices = new HashMap<String, Double>();
	}
	
	
	public Map<String, String> getFoods(){
		mapFoods.put(scrapFood, scrapFoodEnabled);
		mapFoods.put(dessertFood, dessertFoodEnabled);
		mapFoods.put(healthyFood, healthyFoodEnabled);
		mapFoods.put(pastaFood, pastaFoodEnabled);
		return mapFoods;
	}
	
	public Map<String, Double> getPrices(){
		mapPrices.put(lowPrice, maxLowPrice);
		mapPrices.put(middlePrice, maxMiddlePrice);
		mapPrices.put(bigPrice, maxBigPrice);
		return mapPrices;
	}
	
	
}
