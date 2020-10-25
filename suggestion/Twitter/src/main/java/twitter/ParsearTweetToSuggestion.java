package twitter;

import java.util.ArrayList;     
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import provider.Suggestions;
import util.DateS;

public class ParsearTweetToSuggestion {
	String twitterString;
	int posicion=0;
	int posicion2=0;
	private String local;
	private String ubicacion;
	private DateS fechaDeVigencia;
	private HashMap<String,Double> listaProductosPrecios;
	private DateS date;
	
	
	public ParsearTweetToSuggestion(String twitterString){
		this.twitterString= twitterString;
		this.listaProductosPrecios = new HashMap<String,Double>();
	}
	
	public void convertirLocal(){
		int posicion=0;
		String local="";
		
		for(int i=0; i<twitterString.length(); i++){
			if(twitterString.charAt(i) == '_'){
				posicion=i;
				break;
			}
		}
		for(int j=7; j<posicion; j++){
			local= local + twitterString.charAt(j);
		}
		this.local= local;
	}
	
	public void convertirUbicacion(){
		String ubicacion="";
		
		for(int i=0; i<twitterString.length(); i++){
			if(twitterString.charAt(i) == '_'){
				posicion=i;
				break;
			}
		}
		for(int j=posicion+1; j<twitterString.length(); j++){
			if(twitterString.charAt(j) == '_'){
				posicion2=j;
				break;
			}
		}
		
		for(int k=posicion+1; k<posicion2; k++){
			ubicacion= ubicacion + twitterString.charAt(k);
		}
		this.ubicacion= ubicacion;
	}
	
	public void convertirLista(){
		int posicion3=0;
		int posicion4=0;
		int aux1=0;
		int aux2=0;
		
		
		String producto="";
		String precioString="";
		double precio= 0.0;
		
		
		for(int i=0; i<twitterString.length(); i++){
			if(twitterString.charAt(i) == '('){
				posicion3=i;
				break;
			}
		}
		for(int i=0; i<twitterString.length(); i++){
			if(twitterString.charAt(i) == ')'){
				posicion4=i;
				break;
			}
		}
		for(int i=posicion3+1; i<posicion4; i++){
			if(twitterString.charAt(i) == '/'){
				aux1=aux1 +1;
			}
		}
		int cantCiclos=posicion3+1;
		
		for(int i=cantCiclos; i<posicion4; i++){
			if(aux2==0){
				if(twitterString.charAt(i) != '/'){
				producto= producto + twitterString.charAt(i);
				} if(twitterString.charAt(i) == '/'){
					aux2= 1;
				}
			}
				
			if(aux2==1){
				if((twitterString.charAt(i) != ',') && (twitterString.charAt(i) != '/')){
					precioString= precioString + twitterString.charAt(i); 
				} if((twitterString.charAt(i) == ',')||(i==posicion4-1)){
					aux2= 0;
					precio= Double.parseDouble(precioString);
					this.listaProductosPrecios.put(producto, precio);
					producto="";
					precioString="";
				}
			}		
		}
	}

	public void convertirFecha(){
		int posInicio=0;
		String ddString="";
		String mmString="";
		String aaaaString="";
		
		for(int i=0; i<twitterString.length(); i++){
			if(twitterString.charAt(i) == ')'){
				posInicio=i+2;
				break;
			}
		}
		for(int i=posInicio; i<twitterString.length(); i++){
			if((i==posInicio) || (i==posInicio+1)){ 
				ddString=ddString + twitterString.charAt(i);
			}
			if((i==posInicio+3) || (i==posInicio+4)){ 
				mmString=mmString + twitterString.charAt(i);
			}
			if((i==posInicio+6) || (i==posInicio+7) || (i==posInicio+8) || (i==posInicio+9)){
				aaaaString=aaaaString + twitterString.charAt(i);
			}
		}	
		
		date= new DateS(Integer.parseInt(ddString),Integer.parseInt(mmString),Integer.parseInt(aaaaString));
		this.fechaDeVigencia= date;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Suggestions> getListSuggestionsTwitter(ArrayList<Suggestions> l){
		Iterator iterador = listaProductosPrecios.entrySet().iterator();
		 Map.Entry producto;
		    while (iterador.hasNext()) {
		        producto = (Map.Entry) iterador.next();
		        Suggestions i= new Suggestions(local, ubicacion, producto.getKey().toString(),
		        		Double.parseDouble(producto.getValue().toString()) , fechaDeVigencia);
		        l.add(i);
		    }
		return l;
		
	}

	public DateS getDate() {
		return date;
	}
	
}
