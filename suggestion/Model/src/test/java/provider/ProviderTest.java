package provider;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import util.DateS;

public class ProviderTest {
	@Test
    public void providerTest(){
		IFactory factory= mock(IFactory.class);
		factory.getPanel(null);
		factory.getConfiguration();
		factory.getProviderName();
		IProvider provider= mock(IProvider.class);
		provider.getSuggestions();
		ProductsBo product= new ProductsBo();
		product.getFoods();
		product.getPrices();
		DateS date= new DateS(20,9,2021);
		Suggestions suggest= new Suggestions("mcDonald","virreyes","hamburguesa",199.0,date);
		suggest.getLocal();
		suggest.getUbicacion();
		suggest.getFechaDeVigencia();
		suggest.getProducto();
		suggest.getPrecio();
	}
}
