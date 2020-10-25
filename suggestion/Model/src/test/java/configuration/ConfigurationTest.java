package configuration;

import org.junit.Test; 

import static org.mockito.Mockito.mock;  

public class ConfigurationTest{
	@Test
    public void configTest(){
		IPanel panel = mock(IPanel.class);
		panel.createPanel();
		panel.getBtnGuardar();
		panel.getBtnCancelar();
		IConfiguration config = mock(IConfiguration.class);
		config.configureProvider(panel);
	}
}
