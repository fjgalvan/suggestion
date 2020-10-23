package configuration;

import provider.IProvider;
import configuration.ExcelPanel; 
import configuration.IConfiguration;
import configuration.IPanel;
import excel.ExcelProvider;

public class ExcelConfiguration implements IConfiguration{
	private ExcelPanel ePanel;
	private String path;

	@Override
	public IProvider configureProvider(IPanel panel) {
		ePanel= (ExcelPanel) panel;
		path= ePanel.getPath();
		
		return new ExcelProvider(path);
	}	
}
