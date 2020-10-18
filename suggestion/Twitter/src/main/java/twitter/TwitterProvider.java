package twitter;

import java.util.ArrayList;   
import java.util.List;
import model.IProvider;
import model.Suggestions;

public class TwitterProvider implements IProvider {
	private ArrayList<Suggestions> listSuggestionsTwitter;
	private TwitterConnector tc;
	private List<String> listaTweets;
	private TwitterData data;

	public TwitterProvider(String userTwitter, Integer lastTweets) {
		listSuggestionsTwitter = new ArrayList<Suggestions>();
		listaTweets = new ArrayList<String>();
		tc = new TwitterConnector();
		data= new TwitterData(tc,listaTweets,userTwitter,lastTweets);
	}

	@Override
	public List<Suggestions> getSuggestions() {
		if (tc.connect()) {
			getValidListSuggestion(data.getListTweets());
		}
		return listSuggestionsTwitter;
	}

	private void getValidListSuggestion(List<String> l) {
		for (int i = 0; i < l.size(); i++) {
			TwitterValidatorTweet v = new TwitterValidatorTweet(l.get(i));
			if (v.twitterStringValido()) {
				this.listSuggestionsTwitter= (ArrayList<Suggestions>) data.getSuggestionsParcial(l.get(i));
			}
		}
	}


}
