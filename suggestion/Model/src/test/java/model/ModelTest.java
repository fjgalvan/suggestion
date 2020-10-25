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
		SuggestionsService suggestionsService= new SuggestionsService("C:\\MecanismosDeConexionExterna");
		List<String> listFactoriesName = new ArrayList<String>();
		listFactoriesName.add("configuration.TwitterFactory");
		listFactoriesName.add("configuration.ExcelFactory");
		suggestionsService.initFactories(listFactoriesName);
		IProvider provider= mock(IProvider.class);
		suggestionsService.setProvider(provider);
		suggestionsService.getProvider();
		List<Suggestions> listSuggestions = new ArrayList<Suggestions>();
		DateS date= new DateS(20,9,2021);
		Suggestions suggest= new Suggestions("mcDonald","virreyes","hamburguesa",199.0,date);
		listSuggestions.add(suggest);
		suggestionsService.getFilteredSuggestions("chatarras", "medio");
	}
}
