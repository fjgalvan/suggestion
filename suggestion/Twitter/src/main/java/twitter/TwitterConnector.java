package twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import connection.IConnector;
import connection.PropertiesPrincipal;

public class TwitterConnector implements IConnector {
	Twitter twitter;

//	public TwitterConnector(Twitter twitter) {
//		this.twitter = twitter;
//	}

	@Override
	public boolean connect() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		PropertiesPrincipal pp = new PropertiesPrincipal(
				MyConstantsTwitter.ROUTE_PROPERTIES);

		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(
						pp.leerValorDeUnaClave(MyConstantsTwitter.ConsumerKey))
				.setOAuthConsumerSecret(
						pp.leerValorDeUnaClave(MyConstantsTwitter.ConsumerSecret))
				.setOAuthAccessToken(
						pp.leerValorDeUnaClave(MyConstantsTwitter.AccessToken))
				.setOAuthAccessTokenSecret(
						pp.leerValorDeUnaClave(MyConstantsTwitter.AccessTokenSecret));

		twitter = new TwitterFactory(cb.build()).getInstance();

		if(twitter != null){
			return true;
		}else{ 
			System.out.println("Se Produjo un Error de Conexion con Twitter!!!  ");
			return false;
		}
	}

	@Override
	public boolean disconnect() {
		return false;
	}

	public Twitter getTwitter() {
		return twitter;
	}
	
}
