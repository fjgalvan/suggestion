package configuration;

import java.util.List; 

import ui.IConfiguration;
import ui.IPanel;

import java.util.Observer;

import provider.IFactory;

public class TwitterFactory implements IFactory{
	private static final String providerTwitterName= "twitter.TwitterProvider";
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
		return providerTwitterName;
	}

}