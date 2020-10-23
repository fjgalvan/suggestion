package twitter;

import java.util.ArrayList;     
import java.util.List;
import provider.IProvider;
import provider.Suggestions;

public class TwitterProvider implements IProvider {
	private ArrayList<Suggestions> listSuggestionsTwitter;
	private TwitterConnector twitterConnector;
	private List<String> listaTweets;
	private TwitterData data;

	public TwitterProvider(String userTwitter, Integer lastTweets) {
		listSuggestionsTwitter = new ArrayList<Suggestions>();
		listaTweets = new ArrayList<String>();
		twitterConnector = new TwitterConnector();
		data= new TwitterData(twitterConnector,listaTweets,userTwitter,lastTweets);
	}

	@Override
	public List<Suggestions> getSuggestions() {
		listSuggestionsTwitter.clear();
		if (twitterConnector.connect()) {
			getValidListSuggestion(data.getListTweets());
		}
		return listSuggestionsTwitter;
	}

	private void getValidListSuggestion(List<String> l) {
		for (int i = 0; i < l.size(); i++) {
			TwitterValidatorTweet tweet = new TwitterValidatorTweet(l.get(i));
			if (tweet.twitterStringValido()) {
				this.listSuggestionsTwitter= (ArrayList<Suggestions>) data.getSuggestionsParcial(l.get(i));
			}
		}
	}


}
