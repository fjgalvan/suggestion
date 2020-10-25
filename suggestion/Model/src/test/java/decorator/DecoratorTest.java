package decorator;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import filters.BasicFilter;
import filters.FoodFilter;
import filters.IFilter;
import filters.PriceFilter;
import provider.Suggestions;
import util.DateS;

public class DecoratorTest {
	@Test
    public void decoratorTest(){
		IFilter filter= mock(IFilter.class);
		List<Suggestions> listSuggestions = new ArrayList<Suggestions>();
		DateS date= new DateS(20,9,2021);
		Suggestions suggest= new Suggestions("mcDonald","virreyes","hamburguesa",199.0,date);
		listSuggestions.add(suggest);
		filter.getSuggestions(listSuggestions);
		BasicFilter basicFilter= new BasicFilter();
		basicFilter.getSuggestions(listSuggestions);
		IFilter bf= new BasicFilter();
		bf.getSuggestions(listSuggestions);
		IFilter sf= new FoodFilter(bf,"chatarras");
		sf.getSuggestions(listSuggestions);
		IFilter sp= new PriceFilter(sf,"bajo");
		sp.getSuggestions(listSuggestions);
	}
}
