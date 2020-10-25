package connection;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ConnectionTest {
	@Test
    public void connectionTest(){
		IConnector connector= mock(IConnector.class);
		connector.connect();
		connector.disconnect();
		List<String> listFactoriesName = new ArrayList<String>();
		listFactoriesName.add("configuration.TwitterFactory");
		listFactoriesName.add("configuration.ExcelFactory");
		GeneratorFactory factories= new GeneratorFactory("C:\\MecanismosDeConexionExterna");
		factories.loadFactories(listFactoriesName);
		MyClassLoader load= new MyClassLoader();
		String path="C:\\MecanismosDeConexionExterna";
		load.load(path, listFactoriesName);
	}
}
