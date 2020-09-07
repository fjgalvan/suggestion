package connection;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesPrincipal {
private Properties propiedades;
	
	public PropertiesPrincipal(String rutaDelArchivo) {
		this.propiedades = new Properties();
		try {
			propiedades.load(new FileReader(rutaDelArchivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String leerValorDeUnaClave(String clave){
		return propiedades.getProperty(clave);
	}
	public void leerTodas(){
		Enumeration<Object> keys = propiedades.keys();

		while (keys.hasMoreElements()){
		   Object key = keys.nextElement();
		   System.out.println(key + " = "+ propiedades.get(key));
		}
	}
	
	public void modificar(String clave, String valor){
		//propiedades.setProperty("cuatro", "4");
	}
}
