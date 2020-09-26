package configuration;

import java.util.List;

import model.IFactory;
import ui.IConfiguration;
import ui.IPanel;
import java.util.Observer;

public class TwitterFactory implements IFactory{

	@Override
	public IPanel getPanel(List<Observer> l) {
		TwitterPanel tPanel= new TwitterPanel(); 
		tPanel.addObserver(l.get(0));
		return tPanel;
	}

	@Override
	public IConfiguration getConfiguration() {
		return new TwitterConfiguration();
	}

	@Override
	public String getProviderName() {
		return "twitter.TwitterProvider";
	}

}