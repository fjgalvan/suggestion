package twitter;

import twitter4j.Twitter; 
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import connection.IConnector;

public class TwitterConnector implements IConnector {
	Twitter twitter;

	@Override
	public boolean connect() {

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(MyConstantsTwitter.ConsumerKey)
				.setOAuthConsumerSecret(MyConstantsTwitter.ConsumerSecret)
				.setOAuthAccessToken(MyConstantsTwitter.AccessToken)
				.setOAuthAccessTokenSecret(MyConstantsTwitter.AccessTokenSecret);

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
