package twitter;

import java.util.ArrayList;  
import java.util.List;

import javax.swing.JOptionPane;

import model.IProvider;
import model.Suggestions;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;

public class TwitterProvider implements IProvider {
	String userTwitter;
	Integer lastTweets;
	private ArrayList<Suggestions> listSuggestionsTwitter;
	private TwitterConnector tc;
	private List<String> listaTweets;

	public TwitterProvider(String userTwitter, Integer lastTweets) {
		this.userTwitter= userTwitter;
		this.lastTweets= lastTweets;
		listSuggestionsTwitter = new ArrayList<Suggestions>();
		listaTweets = new ArrayList<String>();
		tc = new TwitterConnector();
	}

	@Override
	public List<Suggestions> getSuggestions() {
		if (tc.connect()) {
			getValidListSuggestion(getListTweets());
		}
		return listSuggestionsTwitter;
	}

	private void getValidListSuggestion(List<String> l) {
		for (int i = 0; i < l.size(); i++) {
			TwitterValidatorTweet v = new TwitterValidatorTweet(l.get(i));
			if (v.twitterStringValido()) {
				getSuggestionsParcial(l.get(i));
			}
		}
	}

	// Leo y guardo todos los tweets en tipo lista de String
	private List<String> getListTweets() { 
		ResponseList<Status> rl = null;

		try {
			rl = recuperarListadoDeUltimosTweetsEscritos();
		} catch (TwitterException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Elija un usuario twitter válido");
		}
		for (int i = 0; i < rl.size(); i++) {
			listaTweets.add(rl.get(i).getText());
		}
		return listaTweets;
	}

	private ResponseList<Status> recuperarListadoDeUltimosTweetsEscritos() 
			throws TwitterException {
		Paging pagina = new Paging();
		pagina.setCount(this.lastTweets);
		ResponseList<Status> listado = tc.twitter.getUserTimeline(this.userTwitter,pagina);

		for (int i = 0; i < listado.size(); i++) {
			listado.get(i).getText();
		}
		return listado;
	}

	private List<Suggestions> getSuggestionsParcial(String s) {
		TwitterValidatorTweet vt = new TwitterValidatorTweet(s);
		TwitterValidatorDateS vf = new TwitterValidatorDateS(s);

		if ((vt.twitterStringValido()) && (vf.VigenciaPromoValida())) {
			ParsearTweetInSuggestion cs = new ParsearTweetInSuggestion(s);
			cs.convertirLocal();
			cs.convertirUbicacion();
			cs.convertirLista();
			cs.convertirFecha();
			listSuggestionsTwitter = cs.getListSugerenciaTwitter(listSuggestionsTwitter);

		}
		return listSuggestionsTwitter;
	}

}
