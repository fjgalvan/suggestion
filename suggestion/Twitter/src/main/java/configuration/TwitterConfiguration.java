package configuration;

import configuration.IConfiguration;
import configuration.IPanel;
import provider.IProvider;
import twitter.TwitterProvider;

public class TwitterConfiguration implements IConfiguration{
	private TwitterPanel tpanel;
	private String userTwitter;
	private Integer lastTweets;

	@Override
	public IProvider configureProvider(IPanel panel) {
		tpanel= (TwitterPanel) panel;
		userTwitter= tpanel.getUserTwitter();
		lastTweets= tpanel.getLastTweets();
		return new TwitterProvider(userTwitter,lastTweets);
	}
	
	
}
