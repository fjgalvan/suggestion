package configuration;

import provider.IProvider;
import twitter.TwitterProvider;
import ui.IConfiguration;
import ui.IPanel;

public class TwitterConfiguration implements IConfiguration{
	TwitterPanel tpanel;
	TwitterProvider tprovider;
	String ut;
	Integer lt;

	@Override
	public IProvider configureProvider(IPanel panel) {
		tpanel= (TwitterPanel) panel;
		ut= tpanel.getUserTwitter();
		lt= tpanel.getLastTweets();
		return new TwitterProvider(ut,lt);
	}
	
	
}
