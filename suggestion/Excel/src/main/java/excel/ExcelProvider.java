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
	
	
	public ExcelProvider(){
		listSuggestionsExcel = new ArrayList<Suggestions>();
		ec= new ExcelConnector();
	}
	
	@Override
	public List<Suggestions> getSuggestions() {
		if(ec.connect()){
			String nombreArchivo = MyConstantsConexiones.nombreArchivoExcelXlsx;
			String rutaArchivo =  MyConstantsConexiones.rutaArchivoExcelXlsx+ nombreArchivo;
			//String hoja = MyConstantsConexiones.hojaExcelXlsx;
			ExcelValidator ev= new ExcelValidator(rutaArchivo);
			
			if(ev.validadorExcel()){
				listSuggestionsExcel= ev.getListSuggestionsExcel();
			}			
		}
		return listSuggestionsExcel;		
	}
	
	public static void main(String[] args) {

		ExcelProvider ep= new ExcelProvider();
		Iterator<Suggestions> nombreIterator = ep.getSuggestions().iterator();
		while (nombreIterator.hasNext()) {
			Suggestions elemento = nombreIterator.next();
			System.out.println("elemento: ");
			System.out.println(elemento.getLocal()+", "+elemento.getUbicacion()+
			", "+elemento.getProducto()+", "+elemento.getPrecio()+", "+elemento.getFechaDeVigencia().getDate()+"\n");
		}
	}
	
}
