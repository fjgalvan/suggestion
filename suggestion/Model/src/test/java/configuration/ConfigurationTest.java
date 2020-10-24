package configuration;

import org.junit.Test;

import static org.mockito.Mockito.mock;  

public class ConfigurationTest implements IBoundsPanelConfiguration{
	@Test
    public void configTest(){
		IPanel panel = mock(IPanel.class);
		panel.createPanel();
		panel.getBtnGuardar();
		panel.getBtnCancelar();
		IConfiguration config = mock(IConfiguration.class);
		config.configureProvider(panel);
		@SuppressWarnings("unused")
		IBoundsPanelConfiguration bounds= mock(IBoundsPanelConfiguration.class);
		System.out.println(xPanel+" "+ yPanel+" "+ widthPanel+" "+heightPanel);
		System.out.println(xGuardar+" "+ yGuardar+" "+ widthGuardar+" "+heightGuardar);
		System.out.println(xCancelar+" "+ yCancelar+" "+ widthCancelar+" "+heightCancelar);
	}
}
