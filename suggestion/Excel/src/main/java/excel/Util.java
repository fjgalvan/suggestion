package excel;

import java.nio.file.InvalidPathException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	private static final String regularExpression= "(?:[a-zA-Z]\\:)\\\\([\\w-]+\\\\)*\\w([\\w-.])+";
	public static boolean isAbsolutePath(String cadena){
		try{
		    java.nio.file.Paths.get(cadena);
		    return true;
		}catch (InvalidPathException err){
			return false;
		}
	}
	public static boolean isAbsolutePath2(String cadena){
		Pattern p= Pattern.compile(regularExpression);
		Matcher m= p.matcher(cadena);
		if(m.find()){
			return true;
		}
		else{
			return false;
		}
	}
}
