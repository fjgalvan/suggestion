package excel;

import java.io.File;     
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.IProvider;
import model.Suggestions;


public class ExcelProvider implements IProvider{
	
	private List<Suggestions> listSuggestionsExcel;
	private ExcelConnector ec;
	public String path;
	
	
	public ExcelProvider(String path){
		this.path= path;
		listSuggestionsExcel = new ArrayList<Suggestions>();
		ec= new ExcelConnector();
	}
	
	@Override
	public List<Suggestions> getSuggestions() {
		if(ec.connect()){
			ExcelValidator ev= new ExcelValidator(this.path);
			if(ev.validadorExcel()){
				listSuggestionsExcel= ev.getListSuggestionsExcel();
			}			
		}
		return listSuggestionsExcel;		
	}
	
	public static void main(String[] args) {
		String path="C:\\Ficheros-Excel\\Sugerencias.xlsx";
		ExcelProvider ep= new ExcelProvider(path);
		Iterator<Suggestions> nombreIterator = ep.getSuggestions().iterator();
		while (nombreIterator.hasNext()) {
			Suggestions elemento = nombreIterator.next();
			System.out.println("elemento: ");
			System.out.println(elemento.getLocal()+", "+elemento.getUbicacion()+
			", "+elemento.getProducto()+", "+elemento.getPrecio()+", "+elemento.getFechaDeVigencia().getDate()+"\n");
		}
	}
}
