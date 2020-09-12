package configuration;

import java.util.List; 
import model.Suggestions;
import twitter.TwitterProvider;
import ui.IConfiguration;
import ui.IPanel;

//public class TwitterConfiguration implements IConfiguration{
//	TwitterPanel tpanel;
//	TwitterProvider tprovider;
//	String ut;
//	Integer lt;
//
//	@Override
//	public void getData(IPanel panel) {
//		tpanel= (TwitterPanel) panel;
//		ut= tpanel.getUserTwitter();
//		lt= tpanel.getLastTweets();
//		
//	}
//
//	@Override
//	public List<Suggestions> buscar() {
//		tprovider= new TwitterProvider(ut,lt);
//		return tprovider.getSuggestions();
//	}
//	
//	public static void main(String[] args) {
//
//	}
//}
