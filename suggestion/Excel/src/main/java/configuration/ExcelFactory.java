package configuration;

import java.util.List; 
import java.util.Observer;
import provider.IFactory;
import ui.IConfiguration;
import ui.IPanel;

public class ExcelFactory implements IFactory{

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
		return "excel.ExcelProvider";
	}

}
