package twitter;

import twitter4j.Twitter; 
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import connection.IConnector;

public class TwitterConnector implements IConnector {
	private static final String errorMsg= "Se Produjo un Error de Conexion con Twitter!!!  ";
	Twitter twitter;

	@Override
	public boolean connect() {

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(MyConstantsConnectionTwitter.ConsumerKey)
				.setOAuthConsumerSecret(MyConstantsConnectionTwitter.ConsumerSecret)
				.setOAuthAccessToken(MyConstantsConnectionTwitter.AccessToken)
				.setOAuthAccessTokenSecret(MyConstantsConnectionTwitter.AccessTokenSecret);

		twitter = new TwitterFactory(cb.build()).getInstance();

		if(twitter != null){
			return true;
		}else{ 
			System.out.println(errorMsg);
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
