package twitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.IProvider;
import model.Suggestions;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class TwitterProvider implements IProvider {
	private ArrayList<Suggestions> listSuggestionsTwitter;
	private TwitterConnector tc;
	public Twitter twitter;
	private List<String> listaTweets;

//	public TwitterProvider() {
//		listSuggestionsTwitter = new ArrayList<Suggestions>();
//		listaTweets = new ArrayList<String>();
//		tc = new TwitterConnector();
//	}

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
		}
		for (int i = 0; i < rl.size(); i++) {
			listaTweets.add(rl.get(i).getText());
		}
		return listaTweets;
	}

	private ResponseList<Status> recuperarListadoDeUltimosTweetsEscritos() 
			throws TwitterException {
		// El paging sirve para decir el número máx de tweets que quieres
		// recuperar
		Paging pagina = new Paging();
		pagina.setCount(50);

		// Recupera como máx 50 tweets escritos por el usuario "javier g." 
		ResponseList<Status> listado = tc.twitter.getUserTimeline("javier g.",pagina);

		for (int i = 0; i < listado.size(); i++) {
			listado.get(i).getText();
			System.out.println(listado.get(i).getText());
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

	

	public static void main(String[] args) {

		TwitterProvider tp= new TwitterProvider();
		Iterator<Suggestions> nombreIterator = tp.getSuggestions().iterator();
		while (nombreIterator.hasNext()) {
			Suggestions elemento = nombreIterator.next();
			System.out.println("elemento: ");
			System.out.println(elemento.getLocal()+", "+elemento.getUbicacion()+
			", "+elemento.getProducto()+", "+elemento.getPrecio()+", "+elemento.getFechaDeVigencia().getDate()+"\n");
		}
	}

}
