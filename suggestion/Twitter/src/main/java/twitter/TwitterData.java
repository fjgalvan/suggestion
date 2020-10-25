package twitter;

import java.util.ArrayList; 
import java.util.List;

import javax.swing.JOptionPane;

import provider.Suggestions;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;

public class TwitterData {
	private static final String errorChooseUserMsg= "Elija un usuario twitter válido";
	private List<String> listaTweets;
	private Integer lastTweets;
	private TwitterConnector tc;
	private String userTwitter;
	private ArrayList<Suggestions> listSuggestionsTwitter;
	
	public TwitterData(TwitterConnector tc, List<String> listaTweets, String userTwitter, Integer lastTweets){
		this.listaTweets= listaTweets;
		this.tc= tc;
		this.userTwitter= userTwitter;
		this.listSuggestionsTwitter = new ArrayList<Suggestions>();
		this.lastTweets= lastTweets;
	}
	
	public List<String> getListTweets() { 

		try {
			listaTweets.clear();
			ResponseList<Status> rl = recuperarListadoDeUltimosTweetsEscritos();
			for (int i = 0; i < rl.size(); i++) {
				listaTweets.add(rl.get(i).getText());
			}
		} catch (TwitterException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, errorChooseUserMsg);
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
	
	public List<Suggestions> getSuggestionsParcial(String s) {
		TwitterValidatorTweet vt = new TwitterValidatorTweet(s);
		TwitterValidatorDateS vf = new TwitterValidatorDateS(s);

		if ((vt.twitterStringValido()) && (vf.VigenciaPromoValida())) {
			ParsearTweetToSuggestion cs = new ParsearTweetToSuggestion(s);
			cs.convertirLocal();
			cs.convertirUbicacion();
			cs.convertirLista();
			cs.convertirFecha();
			listSuggestionsTwitter = cs.getListSuggestionsTwitter(listSuggestionsTwitter);

		}
		return listSuggestionsTwitter;
	}
}
