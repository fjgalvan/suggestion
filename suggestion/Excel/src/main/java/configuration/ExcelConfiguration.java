package configuration;

import configuration.ExcelPanel;
import excel.ExcelProvider;
import model.IProvider;
import ui.IConfiguration;
import ui.IPanel;

public class ExcelConfiguration implements IConfiguration{
	ExcelPanel ePanel;
	ExcelProvider eProvider;
	String path;

	@Override
	public IProvider configureProvider(IPanel panel) {
		ePanel= (ExcelPanel) panel;
		path= ePanel.getPath();
		
		return new ExcelProvider(path);
	}	
}
