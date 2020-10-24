package model;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import provider.IProvider;
import provider.Suggestions;
import util.DateS;

public class ModelTest {
	@Test
    public void modelTest(){
		Model model= new Model();
		List<String> listFactoriesName = new ArrayList<String>();
		listFactoriesName.add("configuration.TwitterFactory");
		listFactoriesName.add("configuration.ExcelFactory");
		model.initFactories(listFactoriesName);
		IProvider provider= mock(IProvider.class);
		model.setProvider(provider);
		model.getProvider();
		List<Suggestions> listSuggestions = new ArrayList<Suggestions>();
		DateS date= new DateS(20,9,2021);
		Suggestions suggest= new Suggestions("mcDonald","virreyes","hamburguesa",199.0,date);
		listSuggestions.add(suggest);
		model.getFilteredSuggestions("chatarras", "medio");
	}
}
