package configuration;

import java.util.List; 
import java.util.Observer;

import configuration.IConfiguration;
import configuration.IPanel;
import provider.IFactory;

public class ExcelFactory implements IFactory{
	private static final String providerName= "excel.ExcelProvider";
	@Override
	public IPanel getPanel(List<Observer> l) {
		ExcelPanel ePanel= new ExcelPanel();
		ePanel.addObserver(l.get(0));
		return ePanel;
	}

	@Override
	public IConfiguration getConfiguration() {
		return new ExcelConfiguration();
	}

	@Override
	public String getProviderName() {
		return providerName;
	}

}
