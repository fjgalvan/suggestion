package provider;

import java.util.List;
import java.util.Observer;

import ui.IConfiguration;
import ui.IPanel;

public interface IFactory {
	public IPanel getPanel(List<Observer> o);
	public IConfiguration getConfiguration();
	public String getProviderName();
}
