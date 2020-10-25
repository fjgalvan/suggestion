package twitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	private static final String regularExpressionUserTwitter= "^@[A-Za-z0-9_]{1,15}$";
	
	public static boolean isNumeric(String cadena){
		try {
			if(Integer.parseInt(cadena) >= 1){
				return true;
			}
			else{
				return false;
			}
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public static boolean isUserTwitter(String cadena){
		Pattern p= Pattern.compile(regularExpressionUserTwitter);
		Matcher m= p.matcher(cadena);
		if(m.find()){
			return true;
		}
		else{
			return false;
		}
	}
	
}
